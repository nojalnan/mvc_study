package com.test.ioc;

import org.springframework.stereotype.Component;

@Component("money")
public class Money {
	private int amt;
	public Money(){}
	public Money(int amt){
		this.amt = amt;
	}
	
	public int getAmt(){
		return this.amt;
	}
	
	public void setAmt(int amt){
		this.amt = amt;
	}
}
