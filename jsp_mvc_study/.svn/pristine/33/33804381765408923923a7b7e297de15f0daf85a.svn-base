package exam;

import java.util.ArrayList;
import java.util.List;

import bean.User;

public class Exam {

	public static void main(String[]args){
		List<User> list = new ArrayList<User>();
		for(int i=0;i<3;i++){
			User u = new User();
			u.setAdmin(i);
			u.setAge(i+20);
			u.setUserName("홍길동"+ i);
			list.add(u);
		}
		for(User u : list){
			System.out.println(u.getUserName());
		}
		
	}
}
