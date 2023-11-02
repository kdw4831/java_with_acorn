package test.Main;

import test.auto.Engine;
import test.auto.SportsCar;

public class MainClass09 {
	public static void main(String[] args) {
		//SportsCar 객체를 생성해서 참조값을 car1이라는 지역변수에 담아 보세요.
		SportsCar car1=new SportsCar(new Engine());
		//위에서 생성한 객체의 .drive() . openDrive() 메소드를 각각 호출해보세요
		car1.drive();
		car1.openDrive();
		
		SportsCar car2 = new SportsCar(null);
		car2.drive();
		car2.openDrive();
	}
}

