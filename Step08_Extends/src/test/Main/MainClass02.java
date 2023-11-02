package test.Main;

import test.myPec.HandPhone;
import test.myPec.Phone;

/*
 * 	지역변수나 필드 앞에 선언하는 data type은 (참조데이터 type)
 * 
 * 	그 안에 들어있는 참조값의 사용 설명서라고 생각하면 된다.
 * 
 * 	그렇기 때문에 그 지역변수나 필드. 을 찍으면 사용 설명서에 명시된 기능만 사용 할수 있다.
 * 
 * 	java의 모든 객체는 다형성을 가질 수 있다.
 * 
 * 	다형성은 type이 여러개라는 의미이다.
 */

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 구라쌤이 HandPhone 객체는 3가지 type을 가지고 있다고 했는데
		 * 정말 맞을까?
		 */
		
		// HandPhone 객체를 생성해서 나온 참조값을 HandPhone type 지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		// HandPhone 객체를 생성해서 나온 참조값을 Phone type 지역변수 p2에 담기
		Phone p2 = new HandPhone();  //자식클래스로 만든 객체를 부모타입으로 받는다.
		// HandPhone 객체를 생성해서 나온 참조값을 Object type 지역변수 p3에 담기
		Object p3 = new HandPhone();
		
		//객체가 가지고 있는 모든 기능을 다 쓸 수는 없다.
	}
}
