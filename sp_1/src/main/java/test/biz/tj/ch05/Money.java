package test.biz.tj.ch05;

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
