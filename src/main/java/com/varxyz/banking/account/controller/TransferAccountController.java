package com.varxyz.banking.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.account.domain.Account;
import com.varxyz.banking.account.domain.CheckingAccount;
import com.varxyz.banking.account.domain.SavingsAccount;
import com.varxyz.banking.account.exception.InsufficientBalanceException;
import com.varxyz.banking.account.exception.OverdraftException;
import com.varxyz.banking.account.service.AccountService;
import com.varxyz.banking.customer.service.CustomerService;

@Controller("controller.transferAccountController")
public class TransferAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	Long aid_long;
	char accType_char;
	
	@GetMapping("/account/transfer_account")
	public ModelAndView transferAccountForm(HttpServletRequest request, ModelAndView mav) {
		String aid = request.getParameter("aid");
		aid_long = Long.parseLong(aid);
		Account account = new Account();
		account = accountService.getAccountByAid(aid_long);
		String accType = request.getParameter("accType");
		accType_char = accType.charAt(0);
		// 전체 계좌 리스트 가져와서 select option으로 뿌리기
		mav.addObject("account", account);
		mav.setViewName("account/transfer_account");
		return mav;
	}
	
	@PostMapping("/account/transfer_account")
	public ModelAndView transferAccount(HttpServletRequest request, ModelAndView mav) throws InsufficientBalanceException, OverdraftException {
		// 입력받은 출금계좌, 출금금액 받기
		// 타입도 받아서 어떤 계좌인지 파악한 후 withdraw
		// withdraw에서 return 받은 값을 balance에 업데이트
		// 출금계좌는 withdraw 입금계좌는 deposit
		// 입금계좌 text 받아서 accountNum으로 계좌 찾기
		String amount = request.getParameter("amount");
		double amount_double = Double.parseDouble(amount);
		String de_account = request.getParameter("de_account");
		
		if(accType_char == 'S') {
			System.out.println(accType_char);
			SavingsAccount sa = new SavingsAccount();
			sa = (SavingsAccount) accountService.getAccountByAid(aid_long);
			double from_account_balance = sa.withdraw(amount_double);
			sa.setBalance(from_account_balance);
			sa.setAid(aid_long);
			accountService.updateAccount(sa);
			mav.addObject("account", sa);
			System.out.println(sa);
		}else {
			System.out.println(accType_char);
			CheckingAccount ca = new CheckingAccount();
			ca = (CheckingAccount) accountService.getAccountByAid(aid_long);
			double from_account_balance = ca.withdraw(amount_double);
			ca.setBalance(from_account_balance);
			ca.setAid(aid_long);
			System.out.println(aid_long);
			accountService.updateAccount(ca);
			mav.addObject("account", ca);
			System.out.println(ca);
		}
		
		Account account = new Account();
		account = accountService.getAccountByAccountNum(de_account); // 입금계좌
		double to_account_balance = account.deposit(amount_double);
		account.setBalance(to_account_balance);
		account.setAid(account.getAid());
		accountService.updateAccount(account);
		System.out.println(account);
		//644-12-5666

		mav.setViewName("account/success_transfer");	
		return mav;
	}
}
