package test.main;

public class MainClass01 {
	
	//int => int type
	//int[] => int 배열 type
	
	// int[] type은 기본 data type일까? 참조 data type일까? 참조이다.
	//객체는 클래스로 만든다 그런데 배열은 클래스가 존재하지 않는다. 예외 적용 
	
	public static void main(String[] args) {
		// int type 5개를 저장하고 있는 배열 객체 생성해서 참조값을 nums라는 지역 변수에 담기
		int[] nums = {10,20,30,40,50};
		System.out.println(nums[0]);
		
		//double type 5개를 저장하고 있는 배열 객체를 생성해서 참조값을 nums2라는 지역변수에 담아 보세요
		double[] nums2= {10.1,20.2,30.3,40.4,50.5};
		
		//boolean type 5개를 저장하고 있는 배열
		boolean[] truth= {true,false,false,true,true};
		
		//String type(참조데이터 type) 5개를 저장하고 있는 배열
		String[] name= {"김구라","해골","원숭이","주뎅이","덩어리"};
		
		// 배열 객체의 복사본 얻어내기
		int[] result=nums.clone();      
		int[] result2=nums; //참조값 복사  //의미가 다르지?
		
		// 배열의 크기 얻어내기
		int size =nums.length;
		
		//배열은 순서가 있는 데이터이다. 특정 index의 item 참조하는 방법
		int first = nums[0];
		int second= nums[1];
		int third = nums[2];
		//자바에서는 고정배열이다 늘리거나 줄이는게 안되서 그게 가능하게 하는 객체가 있다.
		
		
	
	}
	
}
