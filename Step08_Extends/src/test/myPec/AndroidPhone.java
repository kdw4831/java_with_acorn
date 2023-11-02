package test.myPec;

public class AndroidPhone extends HandPhone {
	//생성자
	public AndroidPhone() {
		System.out.println("AndroidPhone 생성자 호출됨");
	}
	
	//메소드
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	
	// 아래의 @Override는 해당 메소드가 재정의 되어있다고 단순히 표시하는 용도이며 특별한 기능을 가지고 있지 않다.
	@Override
	public void takePicture() {
		System.out.println("1000만 화소의 사진을 찍어요!");
	}
}
