package com.test.ioc.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("working")
public class Working {	
	Emp emp;
	
	@Autowired
	public Working(@Qualifier(value="programmer")Emp emp){
		this.emp = emp;
	}
	
//	@Autowired
	public void setEmp(@Qualifier(value="designer")Emp emp) {
		this.emp = emp;
	}
	
	void work() {
		emp.gotoOffice();
		System.out.println("일을 합니다...");
		emp.getoffWork();
	}
}
