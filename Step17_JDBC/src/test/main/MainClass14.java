package test.main;

import test.dao.MemberDao;
import test.dao.MemberDaotest;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		//10번 회원을 삭제 하려면?
		int num=5;
		
		//MemberDao 객체를 이용해서 삭제하기
		boolean isSucess=new MemberDao().delete(num);
		if(isSucess==true) {
			System.out.println(num+"번 회원을 삭제 했습니다.");
		}else {
			System.out.println("삭제할 회원정보가 존재하지 않습니다.");
		}
		
		
		
		//MemberDao 객체를 이용해서 수정하기
		MemberDto dto=new MemberDto(20,"김대원","암사동");
		int num2=20;
		
		
		boolean isSucess2= new MemberDao().update(null);
		if(isSucess2==true) {
			System.out.println(dto.getNum()+"번 회원을 수정 했습니다.");
		}else {
			System.out.println("삭제할 회원정보가 존재하지 않습니다.");
		}
	}
}
