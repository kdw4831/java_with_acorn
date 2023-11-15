package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MainClass10 {

	
	//매개변수에 전달된 회원번호에 해당하는 회원정보를 DB에서 select한 다음 MemberDto객체에 담아서 
	//리턴하는 메소드를 완성시켜보세요
	//만일 num에 해당하는 회원정보가 없으면 null을 리턴하도록 하세요
	public static MemberDto getData(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto dto= null;
		
		try {
			conn= new DBConnect().getConn();
			String sql="SELECT num,name,addr"
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
				//select 된 회원의 이름과 주소 읽어오기
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				
				//num, name, addr 을 MemberDto 객체를 생성해서 담는다
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
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

	public static void main(String[] args) {
		int num=1;
		// 1번 회원의 정보를 얻어와서
		MemberDto dto= getData(num);
		if(dto==null) {//null을 리턴할 가능성이 있기 때문에 대비를 해야한다.
			System.out.println("회원의 정보가 존재하지 않습니다.");
		}else {
			System.out.println(num+"번 회원의 이름은 "+dto.getName()+"이고 주소는 "+dto.getAddr());
		}
		
	}
}