package test.myPec;

//가상의 옛날 가정용 전화기 객체를 생성할 설계도라고 가정
public class Phone extends Object{ // 어떤 클래스도 상속받지 않으면 자동으로 extends Object가 된다. ,사실상 생략이지
	// 전화거는 메소드
	public Phone() {
		System.out.println("Phone 생성자 호출됨");
	}
	
	public void call() {
		System.out.println("전화를 걸어요!");
		
	}
}
