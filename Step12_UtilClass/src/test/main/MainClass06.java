package test.main;

import test.myPac.Car;

public class MainClass06 {
	public static void main(String[] args) {
		useNums();
		useNums(10);
		useNums(10, 20);
		useNums(10, 20, 30);
		
		
		useStrings();
		useStrings("kim","lee","park");
		
		useCars();
		useCars(new Car("프라이드"), new Car("아반떼"));
	}
	//...은 해당타입의 인자를 자유롭게 전달 할 수 있다, 전달되면 베열에 담긴다.
	//Integer type 여러개를 전달받는 메소드     
	public static void useNums(Integer... nums) {//nums는 Integer[]이다.
		
	}

	//String type 여러개를 전달받는 메소드
	public static void useStrings(String... strs) {//strs는 String[] type이다.
		
	}
	//Car type 여러개를 전달받는 메소드
	public static void useCars(Car... cats) { //cars는 Car[] type이다.
		
	}


}
