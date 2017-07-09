package test.biz.tj.ch06;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=1)
public class Programmer implements Emp{

	public void work() {
		System.out.println("개발자가 일을 합니다.");
		
	}

}
