package test.Main;

import test.myPec.AndroidPhone;

public class MainClass05 {
	public static void main(String[] agrs) {
		//AndroidPhone 객체를 생성해서 참조값을 AndroidPhone type p1이라는 지역변수에 담기
		AndroidPhone p1=new AndroidPhone();
		p1.call();
		p1.mobilePhone();
		p1.takePicture();
		p1.doInternet();
		
	}
}
