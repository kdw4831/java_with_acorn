package test.main;
/*
 * mainClass 9 10 11을 참고해서 풀어보거라
 * JTable에 회원정보 추가, 목록보기 2가지 기능을 구현해 보세요.
 * 
 * 회원 한명의 정보는 번호, 이름, 주소로 구성되어 있으므로 MemberDto 객체를 담으면 됩니다.
 * 
 * 회원 여러명의 정보는 List<MemberDto> 객체에 누적되게 해서 
 * ObjectOutputStream 객체를 이용해서 my_members.dat 파일에 영구 저장되게 해보세요.
 * 
 * 프레임을 새로 시작할 때마다 ObjectInputStream을 이용해서 
 * my_members.dat 파일에 저장된 내용이 JTable에 모두 출력되도록 하세요.
 * 
 * (다 구현하신분은 원하신다면 연구해서 수정,삭제기능도 구현해보세요) 
 * 회원 정보가 추가될 때 마다 새롭게 리스트에 덮히게
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

public class MyFrameQuiz extends JFrame {
   //필드
   JTextField info_num;
   JTextField info_name;
   JTextField info_addr;
   List<MemberDto> infoList;
   MemberDto dtoWrite ;
   MemberDto dtoRead;
   
 
   
   public MyFrameQuiz(String title) {
      super(title);

      setBounds(100, 100, 700, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //BorderLayout으로 설정
      setLayout(new BorderLayout());
      
      //표 형식으로 출력할 JTable
      JTable table = new JTable();
      //테이블의 칼럼명을 미리 배열로 준비한다.
      String[] colNames= {"번호","이름", "주소"};
      DefaultTableModel model= new DefaultTableModel(colNames,0);
      //모델을 테이블에 연결한다
      table.setModel(model);
      
      //테이블을 스크롤 패널로 감싸고
      JScrollPane scroll=new JScrollPane(table);
      
      //스크롤 패널을 프레임의 가운데에 배치하기
      add(scroll,BorderLayout.CENTER);
      
      
      info_num= new JTextField(5);
      info_name= new JTextField(5);
      info_addr= new JTextField(5);
      JLabel label_num=new JLabel("번호");
      JLabel label_name=new JLabel("이름");
      JLabel label_addr=new JLabel("주소");
      
      JButton addbtn=new JButton("회원 정보 추가");
      
      JPanel p1= new JPanel();
      
      p1.add(label_num);
      p1.add(info_num);
      p1.add(label_name);
      p1.add(info_name);
      p1.add(label_addr);
      p1.add(info_addr);
      p1.add(addbtn);
      this.add(p1, BorderLayout.SOUTH);
      p1.setBackground(Color.YELLOW);
   
     
    
      
      infoList= new ArrayList<MemberDto>();
      addbtn.addActionListener((e)->{
         String info_Num= info_num.getText();
         String info_Name= info_name.getText();
         String info_Addr= info_addr.getText();
         //필요한 객체의 참조값을 담을 지역 변수를 미리 만들기
         FileOutputStream fos=null;
         ObjectOutputStream oos=null;
         
         FileInputStream fis=null;
         ObjectInputStream ois=null;
         
         
         
         dtoWrite = new MemberDto(Integer.parseInt(info_Num),info_Name,info_Addr);
         infoList.add(dtoWrite);
         
         try {
            
            //쓰기
            fos= new FileOutputStream("c:/acorn202310/MyFolder/my_members.dat");
            oos= new ObjectOutputStream(fos);
            
            //읽어드리기
            fis= new FileInputStream("c:/acorn202310/MyFolder/my_members.dat");
            ois=new ObjectInputStream(fis);
            
            oos.writeObject(infoList);
            
            for(MemberDto tmp:infoList) {
              

               dtoRead=(MemberDto)ois.readObject();
               String info=String.format("%d %s %s",dtoRead.getNum(),dtoRead.getName(),dtoRead.getAddr() );
               System.out.println(info);
               
               
            }
            
            Vector<Object> row= new Vector<Object>();
            
            row.add(dtoRead.getNum());
            row.add(dtoRead.getName());
            row.add(dtoRead.getAddr());
            model.addRow(row);
          
            
         }catch(Exception e1) {
            e1.printStackTrace();
            
         }finally {
            try {
               if(oos!=null)oos.close();
               if(fos!=null)fos.close();
               
               if(fis!=null) fis.close();
               if(ois!=null) ois.close();
            }catch(Exception e2) {}
         }
         
      });
      
   }

   
   
   public static void main(String[] args) {
      MyFrameQuiz f=new MyFrameQuiz("회원정보 추가 목록");
      f.setVisible(true);
      
      
      
      
      
      
      
      
      
      
   }
}





