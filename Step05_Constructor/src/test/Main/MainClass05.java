package test.Main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		//콘솔창으로 부터 문자열을 읽어들이기 위한 객체 생성
		Scanner scan =new Scanner(System.in);
		System.out.print("문자열 입력:");
		// 콘솔창으로 부터 문자열 읽어드리기
		String str= scan.next();
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
