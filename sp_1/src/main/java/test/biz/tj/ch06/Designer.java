package test.biz.tj.ch06;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=2)
public class Designer implements Emp{

	public void work() {
		System.out.println("디자이너가 일을 합니다.");
		
	}

}
