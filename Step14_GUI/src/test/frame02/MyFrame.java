package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	// 생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 프레임2");
		//setBounds(x,y,width,height) 창의 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		// 이프레임(MyFrame)의 x 버튼 (close 버튼)을 눌럿을 때 프로세스도 같이 종료 되도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		//FlowLayout 매니저 사용해보기
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn1= new JButton("버튼");
		add(btn1); //프레임에 버튼 추가 하기
		
		JButton btn2= new JButton("버튼2");
		add(btn2); //프레임에 버튼 추가하기
		
		JButton btn3= new JButton("버튼3");
		add(btn3); //프레임에 버튼 추가하기
		
		// 프레임을 화면상에 실제 보이게 하기(false 하면 화면에 보이지 않는다)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 생성
		new MyFrame();
		System.out.println("main 메소드가 종료됩니다.");
	}
}
