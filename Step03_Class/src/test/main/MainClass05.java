package test.main;

import java.io.PrintStream;

/*
 * System.out.println();
 * 에 대한 분석
 * 
 */
public class MainClass05 {
	public static void main(String[] args) {
		 //system 클래스에는 out이라는 static 필드가 존재하고
		//거기에는 콘솔창과 연결된 printStream type 객체의 참조값이 들어있다.
		PrintStream a=System.out; // static 필드 참조
		a.println("안녕하세요");
		
		//System 클래스의 static 메소드 호출
		//long type을 리턴함  1970년 1월 1일 0시 기준으로 169633913515초 만큼 흘렀다.
		long time=System.currentTimeMillis();
	}
}
