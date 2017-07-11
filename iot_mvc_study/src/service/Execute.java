package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import bean.User;

public class Execute {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("사용하실 서비스번호를 입력해주세요.");
		System.out.println("1. 유저리스트");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원탈퇴");
		
		int command = Integer.parseInt(scan.nextLine());
		if(command==1){
			try {
				UserService us = new UserService();
				ArrayList<HashMap> userInfoList = us.selectUser();
				for (HashMap hm : userInfoList) {
					System.out.println(hm);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command==2){
			User user = new User();
			UserService us = new UserService();
			try {
				us.insertUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command==3){
			User user = new User();
			UserService us = new UserService();
			try {
				us.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("서비스번호를 잘못 입력하셨습니다.");
		}
	}
}
