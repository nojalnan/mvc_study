package test.biz.tj.ch08;


public class Working {
	Emp emp;

	public Working(Emp emp){
		this.emp = emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	void work() {
		emp.gotoOffice();
		System.out.println("일을 합니다...");
		emp.getoffWork();
	}
	
	public static void main(String[] args){
		Working w = new Working(new Programmer());
		w.setEmp(new Designer());
		w.work();
	}
}
