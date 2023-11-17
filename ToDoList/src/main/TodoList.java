package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.TodoListDao;
import dto.TodoListDto;


public class TodoList extends JFrame implements ActionListener {
   //필드
   JTextField inputTodo;
   JTable table;
   List<TodoListDto> list=new ArrayList<TodoListDto>(); 
   DefaultTableModel model;
   JButton completeBtn;
   JPanel panel1;
   JPanel panel2;
   boolean columnIndex;
   boolean checked;
   
   public TodoList(String title) {
      super(title);
      //JText label
      setLayout(new BorderLayout());
      JLabel label1= new JLabel("<html>오늘의 할일<br></html>");
      
      
      JFrame f=new JFrame();
      //JTextField
      inputTodo= new JTextField(50);
      
      //Jbutton
      JButton addBtn=new JButton("add");
      JButton deleteBtn= new JButton("complete delete");
      
      
      //패널에 UI 배치 
      JPanel panel1= new JPanel();
      
      
      
      JPanel panel2= new JPanel();
      panel2.add(label1);
      panel2.add(inputTodo);
      panel2.add(addBtn);
      
      add(panel1,BorderLayout.LINE_START);
        add(panel2,BorderLayout.NORTH);
        
        JPanel panel3= new JPanel();
        panel3.add(deleteBtn);
        add(panel3,BorderLayout.SOUTH);
      
      
      
      
      //버튼에 리스너 등록
      addBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      //버튼에 action command 설정
      addBtn.setActionCommand("add");
      deleteBtn.setActionCommand("delete");
   
      
      
      //JTable
      table= new JTable();
      
      
      // "번호","오늘 할일","완료" 컬럼명을 가진 테이블 생성
      String[] colNames = {"번호", "오늘 할일", "완료여부"};

      // 테이블에 연결할 모델
      model = new DefaultTableModel(colNames, 0) {
          @Override
          public Class<?> getColumnClass(int columnIndex) {
              //번호(int),할일(String),완료(Boolean)
              switch (columnIndex) {
                  case 0:
                      return Integer.class;
                  case 1:
                      return String.class;
                  case 2:
                      return Boolean.class; // 완료 컬럼에 체크박스(Boolean) 추가
                  default:
                      return super.getColumnClass(columnIndex);
              }
          }
      };

      // 모델을 테이블에 연결
      table.setModel(model);
      
      
      //스크롤이 가능 하도록 테이블을 JScrollPane에 감싼다.
      JScrollPane scroll= new JScrollPane(table);
      //JScrollPane을 프레임의 가운데 배치하기
      add(scroll,BorderLayout.CENTER);
    
      
      refreshTable();
         
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      //눌러진 버튼의 action command 값을 읽어온다.
      String command= e.getActionCommand();
      
     
      if(command.equals("add")) {
    	  if(list.isEmpty()) {
    		 new TodoListDao().seqdrop();
             new TodoListDao().seqcreate();
              
           }
        	  
           
    	  
         String todo=inputTodo.getText();
         //MemberDto 객체에 회원 한명의 정보를 담는다.
         TodoListDto dto=new TodoListDto();
         dto.setTodo(todo);
         //회원 한명의 정보를 DB에 담는다.
         new TodoListDao().insert(dto);
         
      }else if(command.equals("delete")) {
         
         
         for(int i=0; i<model.getRowCount();i++) {
            checked=(boolean)model.getValueAt(i, 2);
            if(checked) {
               TodoListDto dto=list.get(i);
               int num=dto.getNum();
               new TodoListDao().delete(num);
            }
         }
      
     
         
      
      }
      refreshTable();
   }
   //테이블에 회원목록을 다시 출력해주는 메소드
   public void refreshTable() {
      
      
      //DB에 저장된 목록을 읽어온다.
      list=new TodoListDao().getList();
      
      
      //현재 테이블에 출력된 모든 내용을 삭제
      model.setRowCount(0);
      //반복문이 돌면서 테이블 row 추가하기
      for(TodoListDto tmp:list) {
         
         //MemberDto에 담긴 내용을 Object[] 배열에 담은 다음
         Object[] row= {tmp.getNum(), tmp.getTodo(),columnIndex};
         model.addRow(row);
      }
   }
   
   
   
   public static void main(String[] args) {
      JFrame f=new TodoList("TodoList");
       f.setBounds(100, 100, 800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
        
   } 

   
}