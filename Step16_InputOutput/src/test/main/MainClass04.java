package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
//InputStream 객체를 이용해서 입력!!!
//OutputStream 객체를 이용해서 출력!!!

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창과 연결된 객체의 참조값
		PrintStream ps=System.out;
		//OutputStream도 1byte 처리 스트림이다. (한글 처리 불가)
		OutputStream os=ps; // 공부하기 위해 부모 type으로 변수에 참조값을 넣어두고 사용해보자
		
		try {
			os.write(97);// write할 준비
			os.write(105);
			os.write(114);
			os.write(44032);
			os.flush(); //방출  이 두개가 동시에 되어야한다.
 		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
