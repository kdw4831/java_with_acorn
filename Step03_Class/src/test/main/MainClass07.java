package test.main;

import test.mypac.Member;
import test.mypac.MyUtil;
import test.mypac.Square;

public class MainClass07 {
	public static void main(String[] args) {
		//Member 클래스로 객체를 생성하고 참조값을 mem1 이라는 지역변수에 담기
		Member mem1=new Member();
		// 1번 회원의 정보를 담아 보세요
		mem1.num=1;
		mem1.name="kimgura";
		mem1.addr="노량진";
		
		// Member 클래스로 객체를 생성하고 참조값을 mem2 라는 지역변수에 담기
		Member mem2=new Member();
		
		//2번 회원의 정보를 담아보세요
		mem2.num=2;
		mem2.name="해골";
		mem2.addr="행신동";
		
		
		mem1.showInfo();
		mem2.showInfo();
		
		
		Square s=new Square();
		s.width=10;
		s.height=20;
		
		s.area();
		
		
	}
}
