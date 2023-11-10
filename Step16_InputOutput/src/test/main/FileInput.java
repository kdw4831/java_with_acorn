package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
		setLayout(new BorderLayout());
		
		
		
		inputMsg=new JTextField(20);
		sendBtn=new JButton("파일 저장");
		
		//UI를 감쌀 패널
		JPanel p1 =new JPanel();
		//패널에 UI를 배치하고
		p1.add(inputMsg);
		p1.add(sendBtn);
		//패널을 프레임에 남쪽에 추가
		this.add(p1,BorderLayout.SOUTH);
		p1.setBackground(Color.YELLOW);
		
		//여러줄의 문자열을 출력하거나 입력할 수 있는 JTextArea
		JTextArea ta= new JTextArea();
		add(ta,BorderLayout.CENTER);
		
		JButton readBtn= new JButton("읽어오기");
		p1.add(readBtn);
		readBtn.addActionListener((e)->{
			// JTextArea
			ta.setText("");
			
			FileReader fr=null;
			BufferedReader br=null;
			try {
				//파일에서 문자열을 읽어 들일 객체
				fr= new FileReader("c:/acorn202310/myFolder/diary.txt");
				//문자열을 좀 더 편하게 읽어들이기 위해 FileReader를 Buffered Reader로 포장하기
				br =new BufferedReader(fr);
				while(true) {
					//문자열을 한줄씩 읽어낸다.
					String line=br.readLine();
					//만일 더이상 읽을 문자열이 없다면
					if(line==null)break;
					ta.append(line);
					ta.append("\r\n");
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		FileInput fi=new FileInput("메모프레임");
		fi.setVisible(true);
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
	
}
