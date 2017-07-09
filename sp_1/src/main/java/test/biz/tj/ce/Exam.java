package test.biz.tj.ce;

public class Exam {

	public static void main(String[] args){
		InterfaceExam1 ie = new ExamImpl();
		ie.call();
	}
}
