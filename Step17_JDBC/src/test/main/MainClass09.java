package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MainClass09 {
   
   //전체 회원의 목록을 리턴하는 메소드
   public static List<MemberDto> getList(){
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
         String sql="select *from member order by num asc";
         //sql문을 대신 실행해줄 PrepareStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //만일 sql문이 미완성이라면 (? 가 있다면 ) 여기서 ?의 값을 바인딩해준다.
         
         
         rs=pstmt.executeQuery();
         //반복문 돌면서
         while(rs.next()) { //cursor  다음 line에 select 된 row가 있다면
        	//cursor가 위치한 곳에서 num, name, addr 칼럼의 정보를 얻어낸다.
        	int num=rs.getInt("num");
        	String name=rs.getString("name");
        	String addr=rs.getString("addr");
        	 
        	MemberDto dto= new MemberDto();
            dto.setNum(num);
            dto.setName(name);
            dto.setAddr(addr);
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
      return list;  // 내가 계속 오류였던 이유는  return이 try문 안에 있어서 였다. 예외 상황이 왔을 땐 아무것도 리턴할 수 없으니까..
      
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