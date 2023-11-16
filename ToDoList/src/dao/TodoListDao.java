package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.TodoListDto;

import util.DBConnect;



public class TodoListDao {
	
	// 할일을 디비에 추가하는 메소드
	public boolean insert(TodoListDto dto) {
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql = "INSERT INTO todolist"
					+ " (num, todo)"
					+ " VALUES(todolist_seq.NEXTVAL, ?)";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			
			pstmt.setString(1, dto.getTodo());
			//sql 문 실행하기
			rowCount=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false; 
		}
	}
	
	
	// 할일을 수정하는 메소드
	public boolean update(TodoListDto dto) {
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql = "UPDATE todolist"
					+ " SET todo=?"
					+ " WHERE num=?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setInt(2, dto.getNum());
			pstmt.setString(1, dto.getTodo());
			
			
			//sql 문 실행하기
			rowCount=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {
			}
		}
		if(rowCount>0) {
			return true; //수정성공
		}else {
			return false; //수정실패
		
		}
	
	}
	
	
	//할일을 삭제하는 메소드
	public boolean delete(int num) {
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql ="DELETE FROM todolist"
					+ " WHERE num=?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			
			pstmt.setInt(1, num);
			//sql 문 실행하기
			rowCount=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false; 
		}
	}
	
	//회원 전체의 목록을 번호에 대해서 내림차순 정렬해서 리턴하는 메소드
	public List<TodoListDto> getList(){
		//회원 목록을 담을 ArrayList 객체를 미리 생성해서 참조값 얻어내기 
		List<TodoListDto> list=new ArrayList<>();
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "SELECT num, todo"
					+ " FROM todolist"
					+ " ORDER BY num ASC";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			rs = pstmt.executeQuery();
			//반복문 돌면서 
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				//MemberDto 객체에 회원 한명의 정보를 담고 
				TodoListDto dto=new TodoListDto();
				dto.setNum(rs.getInt("num"));
				dto.setTodo(rs.getString("todo"));
				
				//List 에 누적 시키기
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	
	
	
	
}
