package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass09 {
   public static void main(String[] args) {
	   //필요한 객체의 참조값을 담을 변수를 미리 만들기
	   FileInputStream fis=null;
	   FileOutputStream fos=null;
	   
	   //때로는 변수는 미리 만들고 나중에 참조값을 넣어야 할때가 있다.
	   
      try {
         //파일에서 byte를 읽어 들일때 사용하는 객체
         fis= new FileInputStream("c:/acorn202310/myFolder/1.jpg");
         //byte를 파일에 출력할 때 사용하는 객체    역슬래쉬는 두번해줘야된다. \n 이런 것 때문에 그런듯 
         fos=new FileOutputStream("C:\\acorn202310\\myFolder\\copied.jpg");
         
         //byte 알갱이를 읽어낼 배열을 미리 준비하기
         byte[] buffer= new byte[1024]; // byte -128~128까지의 값이 있다
         
         //반복문이 돌면서
         while(true) {
        	 //byte[] 배열을 전달해서 byte 알갱이를 한번에 1024 개씩 읽어드린다.
        	 int readedCount=fis.read(buffer); // 읽어드린 갯수가 리턴된다.
        	 System.out.println(readedCount+"byte를 읽었습니다.");
        	 if(readedCount == -1) break;// 더이상 읽을 데이터가 없다면 반복문 탈출
        	 
        	 //byte[] 배열에 저장된 byte 알갱이를 0번 인덱스로 부터 읽은 갯수만큼만 출력하기
        	 fos.write(buffer,0,readedCount);
        	 fos.flush();
         }
         System.out.println("파일을 카피했습니다.");
         
         
         
      }catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      //finnally  필수적으로 실행된다.
      }finally {
    	 //마무리작업
    	//마무리 작업
          try {
        	//null을  체크하면서 close하기
			if(fos!=null)fos.close();
			if(fis!=null)fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
          
      }
      
      
   }
}