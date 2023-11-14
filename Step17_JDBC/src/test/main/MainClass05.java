package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass05 {
	public static void main(String[] args) {
		//추가할 회원의 정보라고 가정, 번호는 시퀀스로 넣기
		String name="김구라";
		String addr="노량진";
		
		//DB 연결객체를 담을 지역 변수 만들기
		Connection conn=null;
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url,"scott","tiger");
			//예외가 발생하지 않고 여기가지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//sql 문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt=null;
		try {
			
			//실행할 미완성의 sql문
			String sql="INSERT INTO member"
					+ " (num,name,addr)"
					+ " values(member_seq.nextval,?,?)";
			//미완성의 sql문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql문을 완성시키기(?에 값 바인딩하기)
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 추가했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
