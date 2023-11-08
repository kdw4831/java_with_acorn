package test.main;

import test.myPec.MyUtil;

public class MainClass05 {
	public static void main(String[] args) {
		//메소드 안에서 발생하는 예외를 직접 처리한 draw() 메소드 호출
		MyUtil.drow();
		
		
		// 메소드 안에서 발생하는 예외를 throws한 draw() 메소드 호출
		// 여기에서 try catch문으로 예외처리를 해야한다.
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
