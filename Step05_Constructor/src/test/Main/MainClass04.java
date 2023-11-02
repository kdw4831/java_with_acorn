package test.Main;
//java.util 패키지의 Random 클래스 import
import java.util.Random;  //자바에서 제공하는 클래스로 객체 생성

public class MainClass04 {
	public static void main(String[] args) {
		//객체 생성후 참조값을 Random type 지역변수 ran에 담기
		Random ran = new Random();
		// 정수 범위 내에서 랜덤한 정수 하나 얻어내기
		int ranNum = ran.nextInt();
		System.out.println(ranNum);
		// 0 이상 10미만 범위내에서 랜덤한 정수 하나 얻어내기 (0~9) 사이의 랜덤한 정수 얻어내기
		int ranNum2=ran.nextInt(10);// 서양인들 기준으로 10 하면 0이상 10미만범위로 생각 ~이상 ~미만 이렇게 
		System.out.println(ranNum2);
		
	}
}
