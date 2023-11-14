package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.Util.DBConnect;

public class MainClass07 {
	
	//메소드의 매개변수에 전달된 정보를 DB 에 저장하는 메소드
	public static void insert(MemberDto dto) { //MemberDto 객체에는 회원의 이름과 주소가 들어 있다고 가정 
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 추가했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
	
	
	public static void main(String[] args) {
		//추가할 회원의 정보라고 가정.  번호는 시퀀스로 넣기
		String name="김구라";
		String addr="노량진";
		//추가할 회원의 정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//insert() 메소드를 호출하면서 매개변수에 전달하면 회원정보가 추가된다.
		insert(dto);
	}
}