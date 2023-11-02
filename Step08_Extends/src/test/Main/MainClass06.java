package test.Main;

import test.myPec.AndroidPhone;
import test.myPec.HandPhone;

public class MainClass06 {
	public static void main(String[] args) {
		// 자식에게 사준 일반 핸드폰(인터넷이 안됨)
		HandPhone p1= new HandPhone();
		
		// 엄마! 나도 AndroidPhone 갖고 싶어!!!
		AndroidPhone p2=(AndroidPhone)p1; //runtime시에 ClassCastException 발생!
		
		//진짜 엄마 짱이다~~
		//나 이제 인터넷 한다.
		p2.doInternet();
		
	}
}
