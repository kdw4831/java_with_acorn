package test.myPec;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
	public static void sendMessage(String msg) {
		//금지된 단어목록
		List<String> list = new ArrayList<String>();
		list.add("바보");
		list.add("똥깨");
		list.add("멍청이");
		
		//전송할 문자열에 금지어가 있는지 확인하기
		// charSequence 타입은 String으로 받는다
		
		for(int i=0; i<list.size(); i++) {
			String tmp=list.get(i);
			if(msg.contains(tmp)) {
				//예외 발생시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
		}
		
		for(String tmp:list) {
			if(msg.contains(tmp)) {
				//예외 발생시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
		}
		list.forEach(tmp->{
			if(msg.contains(tmp)) {
				//예외 발생시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
			
		});
		
		System.out.println(msg+"를 전송했습니다. ");
	}
	
	// 5초가 걸리는 가상의 그림을 그리는 메소드
	public static void drow() {
		System.out.println("5초 동안 그림을 그려요...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("그림 완성!");
	}
	
	//5초가 걸리는 가상의 전송을 하는 메소드
	public static void send() throws InterruptedException {
		System.out.println("5초 동안 전송을 해요...");
		Thread.sleep(5000);;
		
		System.out.println("전송완료");
		
	}
}
