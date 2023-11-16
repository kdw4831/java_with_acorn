package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
	// 필요한 필드 정의하기

	JTextField inputName;
	JTextField inputAddr;
	JTable table;
	//회원정보를 누적 시킬 ArrayList 객체 
	List<MemberDto> list=new ArrayList<MemberDto>(); 
	DefaultTableModel model;
	
	
	public MemberFrame(String title) {
		super(title);
		//JText label
		setLayout(new BorderLayout());
		
		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("주소");
		
		//JTextField
		
		inputName= new JTextField(10);
		inputAddr= new JTextField(10);
		
		//Jbutton
		JButton addBtn=new JButton("추가");
		JButton deleteBtn= new JButton("삭제");
		
		//패널에 UI 배치
		JPanel panel= new JPanel();
		
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		//패널을 프레임 위쪽에 배치
		add(panel,BorderLayout.NORTH);
		
		//버튼에 리스너 등록
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		//버튼에 action command 설정
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		table= new JTable();
		String[] colNames= {"번호","이름","주소"};
		//테이블에 연결할 모델
		model=new DefaultTableModel(colNames,0) {
			//익명클래스를 이용해서 오버라이드
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0) {   // 0번째 칼럼은 수정이 불가 하도록
					return false;// false를 리턴하고 
				}else {// 그 이외의 모든 경우는 수정이 가능하도록
					return true;// true를 리턴한다.
				}
				
			}
			
		};
		//테이블의 값이 수정되었는지 감지할 리스너 등록
		table.addPropertyChangeListener((e)->{
			System.out.println("리스너동작");
			System.out.println(e.getPropertyName());
			System.out.println(table.isEditing());
			/*
			 * property name이 "tableCellEditor"이고
			 * table이 수정중이 아닐때
			 * 현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB에 수정반영하기
			 */
			if(e.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
				int selectIndex=table.getSelectedRow();
				//모델로 부터 현재 인덱스에 있는 table 출력값을 얻어낸다.
				//첫 번째 인자로 row 두번 째 인자로 coulmn을 받아서 좌표를 찾아냄
				int num=(int)model.getValueAt(selectIndex, 0);
				String name=(String)model.getValueAt(selectIndex, 1);
				String addr=(String)model.getValueAt(selectIndex, 2);
				
				//수정할 회원의 정보를 MemberDto 객체에 담고
				MemberDto dto =new MemberDto(num,name, addr);
				//Db에 수정 반영하기
				new MemberDao().update(dto);
				//선택된 포커스 clear
				table.clearSelection();
				
			}
			
		});
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
		//눌러진 버튼의 action command 값을 읽어온다.
		String command= e.getActionCommand();
		//action command 를 이용해서 분기하기
		if(command.equals("add")){
			
			
			String name=inputName.getText();
			String addr=inputAddr.getText();
			//MemberDto 객체에 회원 한명의 정보를 담는다.
			MemberDto dto=new MemberDto();
			
			dto.setName(name);
			dto.setAddr(addr);
			//회원 한명의 정보를 DB에 담는다.
			new MemberDao().insert(dto);
			
		}else if(command.equals("delete")) {
			//JTable 객체의 메소드를 이용해서 어떤 인덱스의 row가 선택되었는지 알아내서 작업하기
			int row=table.getSelectedRow(); 
			System.out.println(row);
			
			// 선택된 row 인덱스에 해당하는 MemberDto 객체는 어떻게 얻어오기?
			//List<MemberDto> dto=new MemberDao().getList();
			//MemberDto selectRow=dto.get(row);
			//int SelectNum=selectRow.getNum();
			//new MemberDao().delete(SelectNum);
			if(row==-1) {
				JOptionPane.showMessageDialog(this,"삭제할 row를 선택해주세요.");
				return;//메소드 여기서 끝내기
			}
			MemberDto dto=list.get(row);
			int num=dto.getNum();
			new MemberDao().delete(num);
			
			
			
		}
		refreshTable();
	}
	//테이블에 회원목록을 다시 출력해주는 메소드
	public void refreshTable() {
		//DB에 저장된 목록을 읽어온다.
		list=new MemberDao().getList();
		//현재 테이블에 출력된 모든 내용을 삭제
		model.setRowCount(0);
		//반복문이 돌면서 테이블 row 추가하기
		for(MemberDto tmp:list) {
			//MemberDto에 담긴 내용을 Object[] 배열에 담은 다음
			Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
		}
	}
	
	//DN에서 List를 읽어와서 필드에 저장하는 메소드
	public void loadFromDB() {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis= new FileInputStream("c:/acorn202310/myFolder/my_members.dat");
			//Object를 읽어들일 수 있는 객체 생성
			ois= new ObjectInputStream(fis);
			//읽어들인 Object를 원래 type으로 casting 해서 필드에 담기
			list=(List<MemberDto>)ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
				if(ois!=null)ois.close();
			}catch(Exception e) {}
		}	
	}

	
	
	
	public static void main(String[] args) {
		JFrame f=new MemberFrame("회원관리");
		  f.setBounds(100, 100, 700, 500);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setVisible(true);
	}

}
