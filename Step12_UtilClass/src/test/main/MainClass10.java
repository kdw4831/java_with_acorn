package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass10 {
	/*
	 * 세명의 회원정보(번호, 이름, 주소)를  HashMap 객체에 각각 담아서
	 * 
	 * ArrayList 객체에 누적 시켜 보세요.
	 * 
	 * 반복문 돌면서 ArrayList 객체에 누적된 회원정보를 콘솔창에 순서대로 출력해 보세요
	 * 
	 * (HashMap 객체 3개 , ArrayList 객체 1개가 생성이 되어야 합니다.)
	 * 
	 * ArrayList 객체 안에 HashMap을 담을 예정이니
	 * 
	 * List<HashMap<String, Object>> type이 필요합니다.
	 */
	public static void main(String[] args) {
		Map<String,Object> map1= new HashMap<String,Object>();
		map1.put("num", 1);
		map1.put("name","김구라");
		map1.put("addr", "노량진");
		
		Map<String,Object> map2= new HashMap<String,Object>();
		map2.put("num", 2);
		map2.put("name","해골");
		map2.put("addr", "행신동");
		
		Map<String,Object> map3= new HashMap<String,Object>();
		map3.put("num", 3);
		map3.put("name","원숭이");
		map3.put("addr", "동물원");
		
		// List의 generic type은 Map이다.
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		
		//순서대로 ArrayList타입의 list에 담기
		list.add((Map<String, Object>) map1);
		list.add((Map<String, Object>) map2);
		list.add((Map<String, Object>) map3);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			//list.get(i).get("num") 그냥 for문은 이런식으로 들어가네
		}
		
		for(Map<String, Object> tmp :list) {
			String result=String.format("번호:%d 이름:%s 주소:%s", 
					(int)tmp.get("num"), (String)tmp.get("name"), (String)tmp.get("addr"));
			System.out.println(result);
			
			

		}
	}

}
