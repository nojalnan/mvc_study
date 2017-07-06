package test.biz.tj.ch13;

public class Son extends Father{
	String father2 = new String("son2");
	String fahter3;
	Son(){
		fahter3 = super.father2;
	}

	public static void main(String[] args){
		Son s = new Son();
		System.out.println(s.father1);
		System.out.println(s.father2);
		System.out.println(s.fahter3);
	}
}
