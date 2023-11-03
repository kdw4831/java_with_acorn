package test.main;

import test.myPec.MyRemocon;
import test.myPec.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * Interface도 data type의 역할을 할 수 있을까?
		 */
		
		Remocon r1=new MyRemocon();
		r1.up();
		r1.down();
		//Remocon 인터페이스에 정의된 static final 상수 참조
		String result=Remocon.COMPANY; // LG
		
		//변수는 필요시에 값 변경 가능
		int num=10;
		num=20;
		
		//상수는 값 변경 불가
		final int num2=10;
		// num2=20;
		
		final String NICK="김구라";
		// NICK="원숭이" 변경불가
	}
}
