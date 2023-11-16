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
	
	public TodoList(String title) {
		super(title);
		//JText label
		setLayout(new FlowLayout());
		JLabel label1= new JLabel("오늘의 할일 ");
		
		
		//JTextField
		inputTodo= new JTextField(50);
		
		//Jbutton
		JButton addBtn=new JButton("add");
		completeBtn=new JButton("완료");
		
		
		//패널에 UI 배치 
		JPanel panel1= new JPanel();
		panel1.add(label1);
		add(panel1,BorderLayout.NORTH);
		
		JPanel panel2= new JPanel();
		panel2.add(inputTodo);
		panel2.add(addBtn);
		add(panel2,BorderLayout.NORTH);
		
		
		//버튼에 리스너 등록
		addBtn.addActionListener(this);
	
		//버튼에 action command 설정
		

		
		
		
		//JTable
		table= new JTable();
		
		String[] colNames= {"번호","오늘 할일","완료"};
		
		
		//테이블에 연결할 모델
		model=new DefaultTableModel(colNames,0);
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollPane에 감싼다.
		JScrollPane scroll= new JScrollPane(table);
		//JScrollPane을 프레임의 가운데 배치하기
		add(scroll,BorderLayout.CENTER);
		refreshTable();
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		String todo=inputTodo.getText();
		
		//MemberDto 객체에 회원 한명의 정보를 담는다.
		TodoListDto dto=new TodoListDto();
		dto.setTodo(todo);
		
		//회원 한명의 정보를 DB에 담는다.
		new TodoListDao().insert(dto);
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
			Object[] row= {tmp.getNum(), tmp.getTodo(),add(completeBtn)};
			model.addRow(row);
		}
	}
	
	
	
	public static void main(String[] args) {
		JFrame f=new TodoList("TodoList");
	    f.setBounds(100, 100, 700, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	} 

	
}
