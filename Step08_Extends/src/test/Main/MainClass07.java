package test.Main;

import java.util.Scanner;

import test.myPec.Phone;

/*
 *  java에서 사용되는 모든 data는 Object type 변수나 필드에 담을 수 있다.
 */

public class MainClass07 {
	public static void main(String[] args) {
		//기본 data type은 Wrapper Class type으로 간주되어서 담긴다.
		Object a=10; //Integer
		Object b = true;// Boolean
		Object c = 'a';// Character
		
		// 모든 참조 data type은 당연히 Object type도 된다.
		
		Object d = "abcd";
		Object e = new Phone();
		Object f = new Scanner(System.in);
		
		//Object 배열은 어떤 type 이던지 다 담을 수 있다. 무적 Object ?
		Object[] objs= new Object[5];
		
		objs[0] = 10;
		objs[1] = true;
		objs[2] = "kim";
		objs[3] = new Phone();
		objs[4] = new Scanner(System.in);
		
		//지역변수 e에 저장된 참조값을 이용해서 전화를 걸어보세요
		Phone p1= (Phone)e;
		p1.call();
		
		//objs 배열의 3 번방에 있는 참조값을 이용해서 전화를 걸어보세요
		Phone p2=(Phone)objs[3];
		p2.call();
		
		//이걸 더 줄이면?
		((Phone)objs[3]).call();
		
		
//		Object o=objs[3];
//		Phone p2=(Phone)o;
//		p2.call();
// 		처음 연습은 변수에 대입하는 습관을 길러야겠다. 
		
		
		
		
		
		
	}
}
