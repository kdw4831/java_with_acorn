package test.main;

import java.util.HashMap;
import java.util.Map;

import test.myPac.Car;

/*
 * 	java에서 어떤 데이터를 key : value의 쌍으로 관리 하고 싶으면
 * 	HashMap 객체를 사용한다.
 * 	key의 generic도 마음대로 지정할 수 있지만 보통 String type으로 한다.
 *	value의 generic은 그때 그때 다르지만 value가 여러가지 type이면
 *	Object로 지정한다. 
 *
 */

public class MainClass09 {
	public static void main(String[] args) {
		//HashMap 객체 생성해서 참조값을 Map 인터페이스 type 지역변수에 담기
		Map<String, Object> map1= new HashMap<String, Object>();
		map1.put("num", 1); //Integer type 담기
		map1.put("name", "김구라");// String type 담기
		map1.put("isMan", true);// boolean type 담기
		map1.put("car", new Car("소나타"));// Car type 담기
		
		/*
		 * value의 generic 클래스가 Object로 지정 되어 있기 때문에
		 * 리턴되는 Object type을 원래 type으로 casting 해야 한다.
		 * 캐스팅한다고 해서 참조값이 바뀌지 않는다.
		 */
		int num= (int)map1.get("num");
		String name= (String)map1.get("name");
		boolean isMan=(boolean)map1.get("isMan");
		Car car=(Car)map1.get("car");
		
		// 동일한 key 값으로 다시 담으면 수정
		map1.put("name", "에이콘");
		// 특정 key 값으로 담긴 내용을 삭제, 성공하면 true, 실패하면 false 리턴
		map1.remove("isMan");
		// 모두 삭제
		map1.clear();
		
	}
}
