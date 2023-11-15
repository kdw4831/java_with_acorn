package test.main;

import test.dao.MemberDao;
import test.dao.MemberDaotest;
import test.dto.MemberDto;

public class MainClass11 {
	public static void main(String[] args) {
		//회원 한명의 정보를 추가 하려면?
		String name="원숭이";
		String addr="상도동";
		
		//위의 정보를 MemberDto 객체에 담고
		MemberDto dto= new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		MemberDao dao= new MemberDao();
		dao.insert(dto);
		
		System.out.println("회원정보를 추가했습니다.");
	}
}
