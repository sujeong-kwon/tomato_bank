package com.varxyz.banking.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.customer.domain.Customer;
import com.varxyz.banking.customer.service.CustomerService;

@Controller("controller.customerController")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	String email;
	
	@GetMapping("/customer/main")
	public ModelAndView main(HttpServletRequest request, ModelAndView mav) {
		HttpSession session = request.getSession(false);
		email = (String) session.getAttribute("email");
		Customer customer = new Customer();
		customer = customerService.getCustomerByEmail(email);
		mav.addObject("customer", customer);
		mav.setViewName("customer/main");
		return mav;
	}
	
	// 회원가입
	@GetMapping("/customer/add_customer")
	public String addCustomerForm() {
		return "customer/add_customer";
	}
	
	@PostMapping("/customer/add_customer")
	public String addCustomer(Customer customer, Model model) {
		System.out.println(customer.getEmail());
		customerService.addCustomer(customer);
		model.addAttribute("customer", customer);
		return "redirect:/";
	}
	
	// 로그인
	@GetMapping("/customer/login")
	public String loginForm() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		Customer customer = customerService.isValidUser(email, passwd);
		
		if(customer == null) {
			System.out.println("x");
			return "customer/add_customer";
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("passwd", passwd);
		session.setAttribute("cid", customer.getCid());
		request.setAttribute("name", customer.getName());
		
		return "redirect:/customer/main";
	}
	
	// 로그아웃
	@GetMapping("/customer/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
}
