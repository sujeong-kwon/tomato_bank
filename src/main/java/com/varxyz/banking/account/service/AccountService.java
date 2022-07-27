package com.varxyz.banking.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.account.dao.AccountDao;
import com.varxyz.banking.account.domain.Account;
import com.varxyz.banking.customer.domain.Customer;
@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
}
