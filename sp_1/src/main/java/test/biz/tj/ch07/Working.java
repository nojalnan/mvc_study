package test.biz.tj.ch07;

public class Working {
	Emp emp;

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	void work() {
		emp.gotoOffice();
		System.out.println("일을 합니다...");
		emp.getoffWork();
	}
}
