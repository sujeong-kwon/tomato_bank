package com.varxyz.banking.account.domain;

import com.varxyz.banking.account.exception.InsufficientBalanceException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account{
	private double interestRate;

	public double withdraw(double amount) throws InsufficientBalanceException { // 출금
		if(balance - amount < 0) {
			// 잔고 부족시 예외발생
			throw new InsufficientBalanceException("에러: 잔고부족", balance);
		}else {
			return balance -= amount;
		}
	}
	
	
}
