package Caculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JTextField number1;
	JTextField number2;
	JLabel label;
	
	public MyFrame(String title) {
		super(title); // 부모 생성자에 프레임의 제목 전달하기
		
		setBounds(100, 100, 1000, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		
		//문자열을 한줄 입력 받을수 있는 JTextField 객체 생성
		number1=new JTextField(10);
		JButton AddBtn=new JButton("+");
		JButton SubBtn=new JButton("-");
		JButton MulBtn=new JButton("*");
		JButton DivBtn=new JButton("/");
		number2=new JTextField(10);
		label=new JLabel("=");
		try {
				
			AddBtn.addActionListener(this);
			SubBtn.addActionListener(this);
			MulBtn.addActionListener(this);
			DivBtn.addActionListener(this);
			
		}catch(Exception e1) {
			String msg= "정수를 입력해주세요";
			JOptionPane.showMessageDialog(this, msg);
		}
		
		
		add(number1);
		add(AddBtn);
		add(SubBtn);
		add(MulBtn);
		add(DivBtn);
		add(number2);
		add(label);
		
	}
	
	
	
	public static void main(String[] args) {
		MyFrame f =new MyFrame("사칙연산 계산기");
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		String stringNum1=number1.getText();
		String stringNum2=number2.getText();
		Integer num1=Integer.parseInt(stringNum1);
		Integer num2=Integer.parseInt(stringNum2);
		
		
		if(command=="+") {
			String result=Integer.toString(num1+num2);
			label.setText("= "+ result);
		}else if(command=="-") {
			String result=Integer.toString(num1-num2);
			label.setText("= "+ result);
		}else if(command=="*") {
			String result=Integer.toString(num1*num2);
			label.setText("= "+ result);
		}else if(command=="/") {
			String result=Integer.toString(num1/num2);
			label.setText("= "+ result);
		}
	
		
		

		
	}

}
