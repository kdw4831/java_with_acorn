package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		//sample 데이터 (영어사전 역할)
		Map<String, Object> dic = new HashMap<String, Object>();
		
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		
		/*
		 * [콘솔창 실행 결과 1]
		 * 
		 * 검색할 단어를 입력하세요:house
		 * 
		 * house의 뜻은 집입니다.
		 * 
		 * [콘솔창 실행 결과 2]
		 * 
		 * 검색할 단어를 입력하세요: gura
		 * 
		 * gura는 목록에 없습니다.
		 */
		
		Scanner sc= new Scanner(System.in);
		System.out.print("검색할 단어를 입력하세요: ");
		//문자열 입력 받기
		String word=sc.nextLine();
		//입력한 key 값을 이용해서 단어의 뜻을 찾는다.
		String Word=(String)dic.get(word);
		
		// (String)dic.get(word);를 했을 때 dic 안에 word의 키가 없다면 값은 null이 출력된다.
		if(Word==null) {
			String result= String.format("%s는 목록에 없습니다.", word);
			System.out.println(result);
		}else {
			String result2=String.format("%s의 뜻은 %s입니다.", word, Word);
			System.out.println(result2);
		}
		
		//두번째 방법 만일 값의 key 값이 존재하면
		if(dic.containsKey(word)) {
			System.out.println(word+"의 뜻은 "+Word+"입니다.");
		}else {
			System.out.println(word+"는 목록에 없습니다.");
		}
	}
}
