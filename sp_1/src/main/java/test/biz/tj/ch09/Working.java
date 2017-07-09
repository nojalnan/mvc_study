package test.biz.tj.ch09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Working {
	Emp emp;

	@Autowired
	public Working(@Qualifier(value="programmer")Emp emp){
		this.emp = emp;
	}
	
	public Working(){}
	
	@Autowired
	public void setEmp(@Qualifier(value="designer")Emp emp){
		this.emp = emp;
	}
	
	void work() {
		emp.gotoOffice();
		System.out.println("일을 합니다...");
		emp.getoffWork();
	}
	
//	public static void main(String[] args){
//		Emp designer = new Designer();
//		Working w = new Working(designer);
//		w.work();
////		w.setEmp(programmer);
////		w.work();
//	}
}
