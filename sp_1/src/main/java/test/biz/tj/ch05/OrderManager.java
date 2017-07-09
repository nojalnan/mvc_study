package test.biz.tj.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	@Autowired
	@Qualifier("hyundai,hyundai1")
	private CarMaker cm;
	
	@Autowired
	private Money money;
	
	public OrderManager(){}
	
	public void order(){
		money.setAmt(1000);
		Car car = cm.sell(money);
	}

}
