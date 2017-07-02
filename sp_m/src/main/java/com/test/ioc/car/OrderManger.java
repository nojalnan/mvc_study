package com.test.ioc.car;

public class OrderManger {

	private Maker mk;
	
	private Maker mk2;
	
//	private Money money;
	
	public OrderManger(){

	}
	
	
	public void order(){
		Money money = new Money();
		money.setAmt(1000);
		Car car = mk.sell(money);
		Car car2 = mk2.sell(money);
	}
	
	public void setMaker(Maker maker) {
		this.mk = maker;
	}
	public void setMaker2(Maker maker2) {
		this.mk2 = maker2;
	}
}
