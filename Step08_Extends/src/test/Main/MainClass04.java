package test.Main;

import test.myPec.HandPhone;
import test.myPec.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 Object type p3라는 지역변수에 담아 보세요
		Object p3= new HandPhone();
		
		// casting 연산자를 이용해서 대입연산자의 우측을 Phone type으로 인식 되도록 한다.
		Phone p2= (Phone)p3;
		// casting 연산자를 이용해서 대입연산자의 우측을 HandPhone type으로 인식 되도록 한다.
		HandPhone p1 = (HandPhone)p3;
		
		
		
	}
}
