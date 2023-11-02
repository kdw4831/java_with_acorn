package test.main;

import test.myPec.MyWeapon;
import test.myPec.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		//useString 메소드 호출하기
		MainClass02.useString("abcd");
		useString("abcd1234");
		
		// 아래의 useWeapon() 메소드를 출력해 보세요
		MainClass02.useWeapon(new MyWeapon());
		useWeapon(new MyWeapon());
		
		
		System.out.println("Main 메소드가 종료 됩니다.");
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		
		
	}
	
	public static void useString(String msg) {
		System.out.println(msg+ " 의 길이:" +msg.length());
		
	}
}
