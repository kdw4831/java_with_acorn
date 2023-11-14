package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MainClass08 {
	//회원정보를 수정하는 메소드
	public static void update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="UPDATE member"
					+ " SET name=?, addr=? "
					+ " WHERE num=?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
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
		//수정할 회원의 정보라고 가정
		int num=1;
		String name="이정호";
		String addr="독산동";
		//수정할 회원의 정보를 MemberDto 객체에 담고
		
		//MemberDto dto=new MemberDto();
		//dto.setNum(num);
		//dto.setName(name);
		//dto.setAddr(addr);
		MemberDto dto=new MemberDto(num,name,addr);
		update(dto);
		
	}
}
