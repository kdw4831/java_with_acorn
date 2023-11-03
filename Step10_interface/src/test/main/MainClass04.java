package test.main;

import test.myPec.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚫어요!");
			}
		});
		
		// 위와 같다 메소드가 하나 밖에 없어서 가능
		useDrill(()->{
			System.out.println("천장에 구명을 뚫어요");
		}); 
	}
	
	public static void useDrill(Drill d) {
		d.hole();
		d.hole();
		d.hole();
	}
}
