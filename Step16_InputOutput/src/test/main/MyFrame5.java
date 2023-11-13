package test.main;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

public class MyFrame5 extends JFrame {
	
	public MyFrame5(String title) {
		super(title);
		//레이아웃 메니저 설정
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
		
		//Sample 회원 정보
		Vector<Object> row1= new Vector<Object>();
		row1.add(1);
		row1.add("김구라");
		row1.add("노량진");

		Vector<Object> row2= new Vector<Object>();
		row2.add(2);
		row2.add("해골");
		row2.add("행신동");
		
		model.addRow(row1);
		model.addRow(row2);
	}
		
	public static void main(String[] args) {
		MyFrame5 f= new MyFrame5("테이블 테스트");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
