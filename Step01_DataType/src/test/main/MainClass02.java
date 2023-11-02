package test.main;

public class MainClass02 {
	
	public static void main(String[] args) {
		
		//1.콘솔창에 "main 메소드가 시작되었습니다."를 출력해보세요.
			System.out.println("main 메소드가 시작되었습니다.");
		
		//2.국어점수 95를 kor이라는 변수에 담아보세요.
			int kor=95;
		
		//3.영어점수 100을 eng라는 변수에 담아보세요.
			int eng=100;
			
		//4. 국어 점수와 영어점수의 평균을 구해서(연산자 활용) avg라는 변수에 담아 보세요.
	    // avg1은 실수타입이지만 오른쪽 같은 경우에는 정수타입이기때문에 오른쪽 정수가 avg1에 대입된 것
			double avg1=(kor+eng)/2; 
			double avg2=(kor+eng)/2d;
			float avg=(kor+eng)/2f;// 여기는 소수점으로 잘 나온다.
		//5. 콘솔창에 avg 변수안에 담긴 내용을 출력해 보세요
			System.out.println(avg);
	}

}
