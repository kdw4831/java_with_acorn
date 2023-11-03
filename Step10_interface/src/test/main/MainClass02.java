package test.main;

import test.myPec.MyRemocon;
import test.myPec.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 확인
		MyRemocon r1= new MyRemocon();
		Remocon r2=r1;
		Object r3= r1;	
		
		useRemocon(r1);
		useRemocon(r2);
		//useRemocon(r3); // 호출 불가 모든 object가 리모콘일 수는 없다
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
	
	
}
