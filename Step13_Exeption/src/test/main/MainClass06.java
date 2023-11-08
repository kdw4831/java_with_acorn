package test.main;

import java.util.Scanner;

import test.myPec.MyUtil;
import test.myPec.WordFilterException;

public class MainClass06 {
	public static void main(String[] args) {
		//문자열을 받을 객체
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("전송할 문자열 입력:");
				String inputMsg=scan.nextLine();
				
				//MyUtil 클래스의 static 메소드를 이용해서 전송하기
				MyUtil.sendMessage(inputMsg);  //JVM이 처리하고 App 종료 
				// 이메소드 안에서 조건부로 WordFilterException이 생긴다.
				
			}catch(WordFilterException wfe) {
				// 예외 페이지를 콜솔창에 출력
				System.out.println(wfe.getMessage());
			}
		
			
		}
	}
}
