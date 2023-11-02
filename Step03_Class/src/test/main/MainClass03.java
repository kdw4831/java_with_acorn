package test.main;

import test.mypac.Car;

public class MainClass03 {
	public static void main(String[] args) {
		// car 객체를 생성해서 사용하지 않고 버림
		new Car();
		
		// Car 객체를 생성해서 1번 사용하고 버림(객체를 1회용으로 사용)
		new Car().drive(); //null이 달린다.원래 클래스에는 아무것도 넣지 않고 선언만 했기 때문

		// Car 객체를 생성해서 나온 참조값을 c1이라는 car type 지역변수에 담아 놓고
		Car c1=new Car();
		// 필요할 때 마다 c1에 . 찍어서 여러번 사용할 수 있다.
		
		c1.drive();     // 자바스크립트는 함수를 호출했을 시에 최소한 undefined라도 리턴이 된다.
		c1.drive();		// 그러나 자바의 경우에는 값이 리턴되지 않을 수도 있다.
		
	
	}
}
