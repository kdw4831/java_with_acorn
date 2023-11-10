package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainClass08 {
   public static void main(String[] args) {
      
      try {
         //파일에서 byte를 읽어 들일때 사용하는 객체
         FileInputStream fis= new FileInputStream("c:/acorn202310/myFolder/1.jpg");
         //byte를 파일에 출력할 때 사용하는 객체    역슬래쉬는 두번해줘야된다. \n 이런 것 때문에 그런듯 
         FileOutputStream fos=new FileOutputStream("C:\\acorn202310\\myFolder\\copied.jpg");
         
         //반복문이 돌면서
         while(true) {
            // 1byte를 읽어 들여서
            int readedByte =fis.read();
            System.out.println(readedByte);
            //만일 더이상 일을 byte가 없다면 반복문 탈출
            if(readedByte== -1)break;
            // 읽어 들인 1byte를 출력
            fos.write(readedByte);
            fos.flush();
         }
         System.out.println("파일을 카피했습니다.");
         //마무리 작업
         fos.close();
         fis.close();
         
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
}