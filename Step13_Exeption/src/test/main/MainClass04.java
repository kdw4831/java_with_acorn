package test.main;

public class MainClass04 {
	// 메인 이 부분을 스레드?? 라고 부른다.
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		try {
			//실행의 흐름이 5초 동안 잡혀있는것 즉 쓰레드를 재워버림 
			//스레드를 일정시간 지연시키기 
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료됩니다.");
	}
}
