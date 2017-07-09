package test.biz.tj.ch09;

public class Exam {

	String str ="str";
	
	public Exam(String str){
		this.str = str; 
	}
	
	public static void main(String[] args){
		Exam e = new Exam("abc");
		System.out.println(e.str);
	}
}
