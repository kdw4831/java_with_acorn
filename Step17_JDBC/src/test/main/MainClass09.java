package test.main;

import java.util.List;

import test.dto.MemberDto;

public class MainClass09 {
	//전체 회원의 목록을 리턴하는 메소드
	public static List<MemberDto> getList(){
		
		return null;
	}
	
	//run했을 때 실행의 흐름이 시작되는 main 메소드
	public static void main(String[] args) {
		//메소드를 이용해서 회원 목록 얻어내기
		List<MemberDto> list=getList();
		//얻어낸 회원목록 사용하기
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getName()+"|"+tmp.getAddr());
		}
	}
}
