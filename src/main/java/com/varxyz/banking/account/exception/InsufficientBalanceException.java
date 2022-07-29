package com.varxyz.banking.account.exception;

public class InsufficientBalanceException extends Exception{
	private double balance;

    public InsufficientBalanceException(String msg, double balance){
           super(msg);
           this.balance = balance;
    }
    
    @Override
    public String getMessage(){
           return "현재 잔고는 "+balance+"원 입니다.";
    }
}
