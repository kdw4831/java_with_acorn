package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		//모든 회원의 목록 얻어오기
		List<MemberDto> list=new MemberDao().getList();
		list.forEach((item)->{
			//item의 type은 뭘까요?
			String info=String.format("번호 : %d, 이름 : %s, 주소 : %s",
					item.getNum(),item.getName(),item.getAddr());
			System.out.println(info);
		});
	}
}
