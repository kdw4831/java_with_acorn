package test.myPec;

public class Member {
	//필드
	public int num;
	public String name;
	public String addr;

	
	//default 생성자로 존재 but 하나의 생성자를 선언하면
	//디폴트 생성자는 사라지기에 한번 더 선언해준 것
	public Member(){
		
	} 
	//int, String, String type을 전달 받는 생성자
	//매개변수는 지역변수이다.
	public Member(int num, String name, String addr){
		this.num  = num;
		this.name = name;
		this.addr = addr;
		
	} 
	
	
	//메소드
	public void printInfo() {
		System.out.println("번호:"+num+"이름:"+name+"주소:"+addr);
	}

}
