package com.test.ioc;

public class OrderManger {
	private Maker maker;
	
	public OrderManger(){
//		생성자 의존주입
//		this.maker = new Hyundai();
	}
	
	public void order(){
		Car car = maker.sell(new Money(100));
	}
	
	public void setMaker(Maker maker) {
		this.maker = maker;
	}
}
