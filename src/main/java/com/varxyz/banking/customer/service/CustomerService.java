package com.varxyz.banking.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.customer.dao.CustomerDao;
import com.varxyz.banking.customer.domain.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer isValidUser(String email, String passwd) {
		return customerDao.findCustomerByIdPw(email, passwd);
	}

	public Customer getCustomerByEmail(String email) {
		return customerDao.findCustomerByEmail(email);
	}	
}
