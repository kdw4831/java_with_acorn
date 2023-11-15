package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.Util.DBConnect;
import test.dto.MemberDto;

public class MainClass10test {

	
	//매개변수에 전달된 회원번호에 해당하는 회원정보를 DB에서 select한 다음 MemberDto객체에 담아서 
	//리턴하는 메소드를 완성시켜보세요
	//만일 num에 해당하는 회원정보가 없으면 null을 리턴하도록 하세요
	public static MemberDto getData(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto dto= new MemberDto();
		int dbNum=0;
		try {
			conn= new DBConnect().getConn();
			String sql="SELECT num,name,addr"
					+" FROM member"
					+" WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			//primary key를 이용해서 불러오니까 하나만 dto객체에 넣는다고 생각하자
			while(rs.next()) {
				dbNum=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				
				
				dto.setNum(dbNum);
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

		if(num!=dbNum) {
			return null;
		}
		
		return dto;
	}

	public static void main(String[] args) {
		int num=2;
		// 1번 회원의 정보를 얻어와서
		MemberDto dto= getData(num);
		if(getData(num)==null) {
			System.out.println("회원의 정보가 존재하지 않습니다.");
		}else {
			System.out.println(num+"번 회원의 이름은 "+dto.getName()+"이고 주소는 "+dto.getAddr());
		}
		
	}
}