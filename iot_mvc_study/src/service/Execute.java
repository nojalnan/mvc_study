package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bean.User;
import service.implement.UserServiceImpl;

public class Execute {

	public int getServiceNum() {
		Scanner scan = new Scanner(System.in);
		try {
			String str = scan.nextLine();
			int serviceNum = Integer.parseInt(str);
			if (serviceNum == 1) {
				return serviceNum;
			} else if (serviceNum == 2) {
				return serviceNum;
			} else if (serviceNum == 3) {
				return serviceNum;
			} else {
				System.out.println("해당하는 서비스항목의 번호를 입력해주세요.");
				return getServiceNum();
			}

		} catch (Exception e) {
			System.out.println("해당하는 서비스항목의 번호를 입력해주세요.");
			return getServiceNum();
		}
	}

	public static void main(String[] args) {
		User user = new User();
		Execute ex = new Execute();

		System.out.println("사용하실 서비스번호를 입력해주세요.");
		System.out.println("1. 유저리스트");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원탈퇴");

		user.setCommand(ex.getServiceNum());

		if (user.getCommand() == 1) {
			try {
				UserService us = new UserServiceImpl();
				ArrayList<HashMap> userInfoList = us.selectUser();
				for (HashMap hm : userInfoList) {
					System.out.println(hm);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (user.getCommand() == 2) {
			UserService us = new UserServiceImpl();
			try {
				us.insertUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UserService us = new UserServiceImpl();
			try {
				us.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
