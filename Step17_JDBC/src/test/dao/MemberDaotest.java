package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MemberDaotest {
	//회원 한명의 정보를 DB에 저장하는 메소드
	public void insert(MemberDto dto) {
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.NEXTVAL,?,?)";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			rs = pstmt.executeQuery();

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
	}
	
	//회원 한명의 정보를 수정하는 메소드
	public void update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql = "UPDATE member"
					+ " SET name=?,addr=?"
					+ " WHERE num=?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}

	}
	
	//회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isSucess=false;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql="DELETE FROM member"
					  + " where num=?";
			//미완성의 sql문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql문을 완성시키기(?에 값 바인딩하기)
			pstmt.setInt(1, num);
			
			
			
			//sql문 실행하기
			int count=pstmt.executeUpdate();//이 메소드는 변화된 row의 개수를 리턴해준다.
			
			//횟수에 따라
			if(count>0) {
				isSucess=true;
			}else {
				isSucess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				
			}catch(Exception e ) {}
			
		}
		return isSucess;
		
	}
	
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto dto= null;
		
		try {
			conn= new DBConnect().getConn();
			String sql="SELECT num,name,addr AS my_address"
					+ " FROM member"
					+ " WHERE num=?";
			
			pstmt=conn.prepareStatement(sql);
			//쿼리문을 실행하기 전에 바인딩을 해야한다.
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			//만일 select 된 row가 존재 한다면
			// rs.next()가 읽어들일게 없으면 try문은 벗어나고 catch문으로 가지? 자동으로 null이 출력되는거다.
			//primary key를 이용해서 불러오니까 하나만 dto객체에 넣는다고 생각하자
			if(rs.next()) {
				//num, name, addr 을 MemberDto 객체를 생성해서 담는다
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				//칼럼 명에 별칭이 있으면 별칭으로 가지고 오면된다.
				dto.setAddr(rs.getString("my_address"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e ) {}
			
		}

		return dto;
	}
	
	
	//회원 전체의 목록을 번호에 대해서 내림차순 정렬해서 리턴하는 메소드
	public List<MemberDto> getList(){
		  // DB에서 SELECT 하기 위해서 필요한 객체를 담을 지역변수 미리 만들기
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      // ArrayList 회원정보를 누적 시킬 ArrayList 객체를 미리 생성한다.
	      List<MemberDto> list=new ArrayList();
	      try {
	         
	         //미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
	         conn=new DBConnect().getConn();
	         //실행할 sql문 미리 준비ㅣ
	         String sql="select *from member order by num desc";
	         //sql문을 대신 실행해줄 PrepareStatement 객체의 참조값 얻어오기
	         pstmt=conn.prepareStatement(sql);
	         //만일 sql문이 미완성이라면 (? 가 있다면 ) 여기서 ?의 값을 바인딩해준다.
	         
	         
	         rs=pstmt.executeQuery();
	         //반복문 돌면서
	         while(rs.next()) { //cursor  다음 line에 select 된 row가 있다면	
	         
	        	MemberDto dto= new MemberDto();
	            dto.setNum(rs.getInt("num"));
	            dto.setName(rs.getString("name"));
	            dto.setAddr(rs.getString("addr"));
	            //Arraylist 객체에 누적 시키기
	            list.add(dto);
	            
	         }
	        
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         
	      }finally {
	         try {
	        	if(rs!=null)rs.close();
	            if(pstmt!=null)pstmt.close();
	            if(conn!=null)conn.close();
	         }catch(Exception e) {}
	      }
	      //회원 목록이 담겨있는 객체의 참조값을 리턴해 준다.
	      // 내가 계속 오류였던 이유는  return이 try문 안에 있어서 였다.
	      //예외 상황이 왔을 땐 아무것도 리턴할 수 없으니까..
	      return list; 
	}
	
}

