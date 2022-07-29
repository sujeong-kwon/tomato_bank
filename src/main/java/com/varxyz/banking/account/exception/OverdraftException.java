package com.varxyz.banking.account.exception;

public class OverdraftException extends Exception {
    private double overdraftAvail;
    private double balance;
    
    public OverdraftException(String msg, double balance, double overdraftAvail){
           super(msg);
           this.overdraftAvail = overdraftAvail;
    }

    @Override
    public String getMessage(){
           return "사용 가능한 대월액은 "+overdraftAvail+"원 입니다.";
    }
}