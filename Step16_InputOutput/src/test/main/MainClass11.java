package test.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import test.dto.MemberDto;

public class MainClass11 {
	public static void main(String[] args) {
		//members.dat 파일에 저장된 MemberDto 객체를 읽어와서 회원 번호, 이름 , 주소를 콘솔에 출력해보세요
		FileInputStream fis =null;
		ObjectInputStream ois=null;
		try {
			fis= new FileInputStream("c:/acorn202310/MyFolder/members.dat");
			ois=new ObjectInputStream(fis);
			
			//읽어낸 Object를 원래 type인 MemberDto type으로 캐스팅 한다
			MemberDto dto=(MemberDto)ois.readObject();
			String info=String.format("%d %s %s",dto.getNum(),dto.getName(),dto.getAddr() );
			System.out.println(info);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(fis!=null) fis.close();
				if(ois!=null) ois.close();
			}catch(Exception e1) {}
			
		}
	}
}
