package com.varxyz.banking.account.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account{
	private double overdraftAmount;
}
