package com.varxyz.banking.account.controller;

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

@Controller("controller.accountController")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	Customer customer;
	String email;
	
	@GetMapping("/account/add_account")
	public String addAccountForm(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		email = (String) session.getAttribute("email");
		System.out.println(email);
		
		return "/account/add_account";
	}
	
	@PostMapping("/account/add_account")
	public String login(HttpServletRequest request, Model model) {
		customer = customerService.getCustomerByEmail(email);
		String accType = request.getParameter("accType");
		char accType_char = accType.charAt(0);
		
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
			System.out.println(sa);
			accountService.addAccount(sa);
			model.addAttribute("account", sa);
		}else {
			CheckingAccount ca = new CheckingAccount();
			ca.setAccType(accType_char);
			ca.setCustomer(customer);
			ca.setAccountNum(accountNum);
			System.out.println(ca);
			accountService.addAccount(ca);
			model.addAttribute("account", ca);
		}
		return "account/success_add_account";
	}
}
