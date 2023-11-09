package test.Quiz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalcFrame extends JFrame implements ActionListener{
	//필드
	JTextField tf_num1,tf_num2;
	JLabel la2;
	
	//생성자
	public CalcFrame(String title) {
		super(title);
		
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 2개
		tf_num1=new JTextField(10);
		tf_num2=new JTextField(10);
		
		//JButton 4 개
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multiBtn=new JButton("*");
		JButton divideBtn=new JButton("/");
		
		//JLabel 2 개
		JLabel la1=new JLabel("=");
		la2=new JLabel("0");
		
		// UI 를 프레임에 배치 
		add(tf_num1);
		add(plusBtn);
		add(minusBtn);
		add(multiBtn);
		add(divideBtn);
		add(tf_num2);
		add(la1);
		add(la2);
		
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		
		// 버튼에 custom action command 설정하기
		plusBtn.setActionCommand("plus");
		minusBtn.setActionCommand("minus");
		multiBtn.setActionCommand("multi");
		divideBtn.setActionCommand("divide");
	}
	
	public static void main(String[] args) {
		CalcFrame f=new CalcFrame("계산기");
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼이 눌러졌는지 확인하기 위해 눌러진 버튼의 액션 command 값을 읽어온다.
		String cmd=e.getActionCommand();
		
		
		
		//입력한 문자열 읽어오기
		String strNum1=tf_num1.getText();
		String strNum2=tf_num2.getText();
		try {
			//입력한 문자열을 실수(double)로 변경하기
			double num1=Double.parseDouble(strNum1);
			double num2=Double.parseDouble(strNum2);
			
			//연산의 결과값을 담을 변수를 미리 선언하고 초기값 대입하기(왜 미리 선언 해야하나?를 알아야함)
			//왜? 조건문 안에서 지역변수로 만들어지면 조건문 밖에서 결과 값을 출력할 수 없다
			//동시에 초기값을 지정해야한다 안하면 아무값도 없는 상태로 출력될때 오류나기 때문에 컴파일에서 오류발생
			double result=0; 
			
			if(cmd.equals("plus")) {
				result=num1+num2;
			}else if(cmd.equals("minus")) {
				result=num1-num2;
			}else if(cmd.equals("multi")) {
				result=num1*num2;
			}else if(cmd.equals("divide")) {
				//만일 0으로 나눌려면 
				if(num2==0) {
					JOptionPane.showMessageDialog(this, "0으로 나눌수는 없어요!");
					return; //메소드를 여기서 끝내라!  void가 있으면 리턴하면 됨
				}
				result=num1/num2;
			}
			
			Double.toString(result);
			
			la2.setText(Double.toString(result));
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(this, "숫자 형식으로 입력해주세요");
		}
		
		
				
		
		
	}
	
}
