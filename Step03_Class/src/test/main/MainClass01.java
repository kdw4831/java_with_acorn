package test.main;
 //다른 패키지의 클래스를 사용할 때는 import를 해야한다.
import test.mypac.Car;   //내가 만든 클래스 불러오기

public class MainClass01 {
	public static void main(String[] args) {
		// test.mypac.car 클래스로 객체를 생성하고 생성된 객체의 참조값을 car1이라는 지역변수에 담기
		Car car1= new Car(); 
		car1.drive();
		// 필드에 저장된 값 참조(불러오기)
		String a= car1.name;  //name의 경우는 string 타입이므로 변수 a의 타입을 String으로 지정해야한다.
		// 필드에 값 대입하기 
		car1.name="소나타";
		// 대입한 이후에 필드에 저장된 값 참조(불러오기)
		String b= car1.name;
		
		
	}

}
