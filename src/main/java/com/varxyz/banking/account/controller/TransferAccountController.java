package com.varxyz.banking.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.account.domain.Account;
import com.varxyz.banking.account.service.AccountService;
import com.varxyz.banking.customer.service.CustomerService;

@Controller("controller.transferAccountController")
public class TransferAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/account/transfer_account")
	public ModelAndView transferAccountForm(HttpServletRequest request, ModelAndView mav) {
		String aid = request.getParameter("aid");
		Long aid_long = Long.parseLong(aid);
		Account account = new Account();
		account = accountService.getAccountByAid(aid_long);
		// 전체 계좌 리스트 가져와서 select option으로 뿌리기
		System.out.println(account);
		mav.addObject("account", account);
		mav.setViewName("account/transfer_account");
		return mav;
	}
	
	@PostMapping("/account/transfer_account")
	public ModelAndView transferAccount(HttpServletRequest request, ModelAndView mav) {
		String aid = request.getParameter("aid");
		Long aid_long = Long.parseLong(aid);
		Account account = new Account();
		account = accountService.getAccountByAid(aid_long);
		System.out.println(account);
		mav.addObject("account", account);
		mav.setViewName("account/transfer_account");
		return mav;
	}
}
