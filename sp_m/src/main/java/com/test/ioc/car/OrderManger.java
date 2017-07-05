package com.test.ioc.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManger {
	
	@Autowired
	@Qualifier("hyundai")
	private Maker mk;
	
	@Autowired
	@Qualifier("samsung")
	private Maker mk2;
	
	@Autowired
	private Money money;
	
//	public OrderManger(){
//
//	}
	
	
	public void order(){
		money.setAmt(1000);
		Car car = mk.sell(money);
		Car car2 = mk2.sell(money);
	}
	
}
