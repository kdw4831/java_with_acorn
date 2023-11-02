package test.main;

import test.mypac.Car;   // import하는 법 컨트롤 스페이스

public class MainClass02 {
	public static void main(String[] args) {
		//Car 클래스로 객체를 생성해서 참조값을 car1이라는 Car type 지역변수에 담기
		Car car1=new Car();
		//Car 클래스로 객체를 생성해서 참조값을 car2이라는 Car type 지역변수에 담기
		Car car2=new Car();
		
		//필드에 String type의 참조값에 대입하기
		car1.name="소나타";
		car2.name="그랜저";
		
		//메소드 호출하기
		car1.drive(); //소나타가 달려요
		car2.drive(); // 그랜저가 달려요
		
		// Car car3 =null; car타입의 참조값만 담을 수 있다.  
		// car3=car2; 이렇게 하면 car2의 참조값이 들어간다. 
		// 그래서 한 객체의 참조 값이 여러군데 있을 수 있다.
		
		// 다른 객체 임으로 false 이다.
		boolean result =car1 ==car2; //false 주소값이 다르다.
		
		Car car3 = car2;
		car3.drive(); //그랜저가 달린다.
		// 동일 객체(car2와 car3에 저장된 참조값이 같다.)임으로 true이다.
		boolean result2 = car2 ==car3;
	}
}
