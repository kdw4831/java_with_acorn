package test.main;

/*
 * run을 했을 때 콘솔창에 경과 시간이 출력되는 프로그래밍을 해보세요
 * 0분 1초
 * 0분 2초
 * 0분 4초
 * 
 * 0분 59초
 * 
 * 1분 0초
 * 1분 1초
 */
public class QuizMain2 {
	public static void main(String[] args) {
//		for(int i=0; i<1000; i++) {
//			int minute=i;
//			for(int j=0;j<60; j++) {
//				int sec=j;
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(minute+"분"+sec+"초");
//			}
//			
//					
//		}
		
		// 분과 초를 저장할 변수 2개가 필요하다
		int min=0;
		int sec=0;
		
		// 시간이 계속 진행이 되어야 하기 때문에 무한 루프가 필요하다.
		while(true) {

			//runtime exception을 상속 받지 않해서 생기는 예외처리 필수야
			// 스레드를 1초 지연시키기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec++;// 1초씩 증가한다.
			
			//sec이 만일 60이면 0으로 바꿔야 한다.
			
			if(sec==60) {
				sec=0;
				min++;//60초이니 분도 1증가
			}
			 System.out.println(min+"분"+sec+"초");
			 
			
			
			
			
		}
		
	}
}
