package test.biz.tj.ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	@Autowired
	@Qualifier("hyundai")
	private CarMaker cm;
	
	@Autowired
	private Money money;
	
	public OrderManager(){}
	
	public void order(){
		money.setAmt(1000);
		Car car = cm.sell(money);
	}

}
