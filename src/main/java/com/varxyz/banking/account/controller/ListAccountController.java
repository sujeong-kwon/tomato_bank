package com.varxyz.banking.account.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.varxyz.banking.account.domain.Account;
import com.varxyz.banking.account.service.AccountService;
import com.varxyz.banking.customer.service.CustomerService;

@Controller("controller.listAccountController")
public class ListAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	long cid;
	
	@GetMapping("/account/list_account")
	public ModelAndView listAccountForm(HttpServletRequest request, ModelAndView mav) {
		HttpSession session = request.getSession(false);		
		cid = (long) session.getAttribute("cid");
		List<Account> account = new ArrayList<Account>();
		account  = accountService.getAccountsByCustomerId(cid);
		mav.addObject("account", account);
		mav.setViewName("account/list_account");
		return mav;
	}
}
