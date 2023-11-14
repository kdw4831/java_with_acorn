package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MainClass09 {
	//전체 회원의 목록을 리턴하는 메소드
	public static List<MemberDto> getList(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 가져왔습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		
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
