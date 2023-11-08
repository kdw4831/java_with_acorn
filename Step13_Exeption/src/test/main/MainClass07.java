package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass07 {
	
	public static void main(String[] args) {
		/*
		 * 현재 존재하거나 혹은 존재하지 않는 파일이나 폴더를 제어 할 수 있는 file 객체를 생성해서 
		 * 참조값을 f라는 지역변수에 넣기
		 */
		File f=new File("c:/acorn202310/myFolder/memo.txt");
		
		//File 객체의 메소드를 활용해서
		//실제 memo.txt 파일이 존재하지 않으면 파일을 만들고 
		//존재하면 memo.txt 파일을 삭제하도록 프로그래밍 해보세요
		
		
		//내가 한거
//		if(f.exists()==false){
//			try {
//				f.createNewFile();
//				System.out.println("txt파일 생성");
//			}catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("txt파일 생성 실패");
//			}
//		}else {
//			f.delete();
//			System.out.println("txt파일 삭제");
//		}
		
		try {
			if(f.exists()) {
				f.delete();
				System.out.println("txt파일 삭제");
			}else {
				f.createNewFile();
				System.out.println("txt파일 생성");
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인 메소드가 종료됩니다.");
		
		
		
	}

}
