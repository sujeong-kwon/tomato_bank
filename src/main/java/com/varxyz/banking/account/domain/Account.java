package com.varxyz.banking.account.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.varxyz.banking.account.exception.InsufficientBalanceException;
import com.varxyz.banking.customer.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	protected long aid;
	protected Customer customer;
	protected String accountNum;
	protected char accType;
	protected double balance;
	protected Date regDate;
	
	public Account() {
		super();
	}
	
	public double deposit(double amount) { // 입금
		return balance += amount;
	}
	
	public double withdraw(double amount) throws Exception{
		if(balance - amount < 0) {
			throw new InsufficientBalanceException("에러: 잔고부족", balance);
		}else {
			return balance -= amount;
		}
	};
	
}
