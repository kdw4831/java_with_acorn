package test.Main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass08 {
	public static void main(String[] args) {
		//car 객체를 생성해서 참조값을 car1이라는 지역 변수에 담아 보세요
		Car car1=new Car(new Engine());
		
		//car1에 . 찍어서 drive() 메소드를 출력해보세요
		car1.drive();
		
		Car car2=new Car(null); //안에다가 null을 하면 안쓰겠다는 의미.
		car2.drive(); 
	}
}
