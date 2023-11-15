package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		//1번 회원의 정보를 얻어내려면?
		int num=1;
		
		//MemberDao 객체의 .getData(번호) 메소드를 이용하면 된다.
		MemberDao dao =new MemberDao();
		MemberDto dto=dao.getData(num);
		
		System.out.println(num+"번 회원의 이름은 "+dto.getName()+"이고 주소는 "+dto.getAddr());
	}
}
