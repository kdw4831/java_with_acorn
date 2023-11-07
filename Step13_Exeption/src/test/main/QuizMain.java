package test.main;

public class QuizMain {
	/*
	 * run 했을 때 콘솔창에 
	 * 1초
	 * 2초
	 * 3초
	 * .
	 * .
	 * 경과 시간이 출력되다가
	 * .
	 * .
	 * 10초
	 * 까지만 출력하고 종료되는 프로그램을 작성해보자
	 */
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((i+1)+"초");
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		
		
		
	}
}
