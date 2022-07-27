package com.varxyz.banking.account.domain;

import java.sql.Timestamp;
import java.util.Date;

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
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accType;
	private double balance;
	private Date regDate;
	
	public Account() {
		super();
	}
	
}
