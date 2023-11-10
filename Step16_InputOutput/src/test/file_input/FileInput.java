package test.file_input;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FileInput extends JFrame implements ActionListener {
	
	//필드
	JTextField inputMsg;
	JButton sendBtn;
	String Msg=null;
	//생성자
	public FileInput(String title) {
		super(title);
		setBounds(100,100,500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		inputMsg=new JTextField(20);
		sendBtn=new JButton("파일 저장");
		
		add(inputMsg);
		add(sendBtn);
		
		sendBtn.addActionListener(this);
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String Msg=inputMsg.getText();
		
		//파일을 만들거나 이미만들어진 파일에 대해서 작업할 객체 생성
		File f= new File("C:\\acorn202310\\myFolder\\diary.txt");
		
		try {
			if(!f.exists()) {
				f.createNewFile();
				System.out.println("diary.txt 파일을 만들었습니다");
			}
			
			FileWriter fw=new FileWriter(f, true);
			
			fw.write(Msg);
			fw.write("\r\n");
			fw.flush();
			fw.close(); 
			System.out.println("diary.txt 파일에 문자열을 기록했습니다.");
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		FileInput fi=new FileInput("파일에 입력하기");
		fi.setVisible(true);
	}
	
}
