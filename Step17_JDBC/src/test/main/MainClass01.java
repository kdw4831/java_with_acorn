package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 프로젝트에 마우스 우클릭 =>Build Path=>Configure Build Path
 * =>classpath 선택=>
 */
public class MainClass01 {
	public static void main(String[] args) {
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
		
		//SELECT 작업을 위해 필요한 객체의 참조값을 담을 지역 변수 미리 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//실항할 sql문
			String sql="SELECT empno, ename, job, sal"
					+ " FROM emp"
					+ " ORDER BY empno ASC";
			
		//PreparedStatement 객체의 참조값 얻어오기
		pstmt=conn.prepareStatement(sql);
		//SLECT 문을 실행하고 결과 값을 ResultSet으로 얻어내기
		rs=pstmt.executeQuery();
		
		//반복문 돌면서
		while(rs.next()) {// cursor를 한칸씩 내리면서
			//현재 cursor가 위치한 곳의 숫자나 문자를 추출한다.
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+" | "+ename+" | "+job+" | "+sal);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
