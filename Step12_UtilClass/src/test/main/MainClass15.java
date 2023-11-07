package test.main;

import java.util.Random;

/*
 * 반목문 while
 */
public class MainClass15 {
	public static void main(String[] args) {
		
		int count=0;
		
		//무한 반복(무한 루프)
//		while(true) {
//			count++;
//			System.out.println(count);
//		}
		
		//정해진 횟수만큼 반복
//		while(count<10) {
//			System.out.println(count);
//			count++;
//			
//			
//		}
		//랜덤한 숫자를 얻어낼 Random 객체
		Random ran= new Random();
		//특정 조건을 만족할때 까지 반복
		while(true) {
			int ranNum=ran.nextInt(100);
			System.out.println(ranNum);
			if(ranNum==50) {
				break;// 반복문 블럭 탈출
			}
		}
		
		System.out.println("------");
		boolean isRun=true;
		while(isRun) {
			int ranNum=ran.nextInt(100);
			System.out.println(ranNum);
			if(ranNum==50) {
				isRun=false;	// 반복문 블럭 탈출
			}
			
		}
		
	}
}
