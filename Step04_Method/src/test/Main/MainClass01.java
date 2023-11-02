package test.Main;

import test.myPec.AirPlane;
import test.myPec.Test;

public class MainClass01 {
	public static void main(String[] args) {
		
		Test t = new Test();
		
		// return type이 void인 메소드를 호출,  변수에 받을 수가 없드아..
		t.walk();
		
		//return type이 int인 메서드를 호출하고 리턴되는 값을 a 라는 int type 지역변수에 담기
		int a= t.getNumber();    
		
		//return type이 String인 메서드를 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		String b= t.getGreeting();
		
		// return type 이 AirPlane인 메소드를 호출하고 리턴되는 값을 c라는 AirPlane type 지역변수에 담기
		
		AirPlane c= t.getPlane();
		c.fly();
		
		// 위에서 생성한 객체의 setNum() 메소드를 호출해 보세요
			t.setNum(10);
		// 위에서 생성한 객체의 setName() 메소드를 호출해 보세요
			t.setName("김대원");
		// 위에서 생성한 객체의 setPlane() 메소드를 호출해 보세요
			t.setAirPlane(new AirPlane());
		
		
	}
}
