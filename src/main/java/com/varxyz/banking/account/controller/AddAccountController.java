package com.varxyz.banking.account.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.account.domain.Account;
import com.varxyz.banking.account.domain.CheckingAccount;
import com.varxyz.banking.account.domain.SavingsAccount;
import com.varxyz.banking.account.service.AccountService;
import com.varxyz.banking.customer.domain.Customer;
import com.varxyz.banking.customer.service.CustomerService;

@Controller("controller.addAccountController")
public class AddAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	Customer customer;
	String email;
	String session_passwd;
	long cid;
	
	@GetMapping("/account/add_account")
	public String addAccountForm(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		email = (String) session.getAttribute("email");
		session_passwd = (String) session.getAttribute("passwd");
		cid = (long) session.getAttribute("cid");
		
		return "account/add_account";
	}
	
	@PostMapping("/account/add_account")
	public String login(HttpServletRequest request, Model model) {
		String accType = request.getParameter("accType");
		char accType_char = accType.charAt(0);
		customer = customerService.getCustomerByEmail(email);
		String balance = request.getParameter("balance");
		double balance_double = Double.parseDouble(balance);
		String passwd = request.getParameter("passwd");
		
		Random rd = new Random();
		String ranNum = "";
		String result = "";
		for(int i=0; i<9; i++) {
			int creatNum = rd.nextInt(8)+1;
			ranNum = Integer.toString(creatNum);
			result += ranNum;
			if(i==2) {
				result += "-";
			}else if(i==4) {
				result += "-";
			}
		}
		System.out.println(result);
		String accountNum = result;
			
		if(accType_char == 'S') {
			SavingsAccount sa = new SavingsAccount();
			sa.setAccType(accType_char);
			sa.setCustomer(customer);
			sa.setAccountNum(accountNum);
			sa.setBalance(balance_double);
			System.out.println(sa);
			accountService.addAccount(sa);
			List<Account> s_account = accountService.getAccountsByCustomerId(cid);
			model.addAttribute("account", s_account);
		}else {
			CheckingAccount ca = new CheckingAccount();
			ca.setAccType(accType_char);
			ca.setCustomer(customer);
			ca.setAccountNum(accountNum);
			ca.setBalance(balance_double);
			System.out.println(ca);
			accountService.addAccount(ca);
			List<Account> a_account = accountService.getAccountsByCustomerId(cid);
			model.addAttribute("account", a_account);
		}
		if(session_passwd.equals(passwd)) {
			System.out.println("성공");
			return "account/list_account";
		}else {
			System.out.println("실패");
			return "account/add_account";
		}
		
	}
}
