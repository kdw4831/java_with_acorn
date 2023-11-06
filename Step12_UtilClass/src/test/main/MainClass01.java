package test.main;

import java.util.ArrayList;

/*
 * java에서 배열은 크기를 조절할 수 없는 고정 배열이다.
 * 
 * 따라서 동적으로 item을 추가하고 삭제하고 하는 작업을 하려면 일반배열은 사용할 수 없다.
 * 
 * 그래서 해당 작업을 하려면 ArrayList 객체를 사용하면 된다.
 * 
 */

public class MainClass01 {
	public static void main(String[] args) {
		// String type을 순서대로 저장할 수 있는 ArrayList 객체를 생성하고 참조값을 names에 담기
		ArrayList<String> names=new ArrayList<String>();  //제너릭을 지정하지 않으면 object type으로 자동지정이 가능하다.
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
	
		// 0 번방의 아이템을 불러와서 item이라는 변수에 담아보세요
			String item = names.get(0);
		// 1 번방의 아이템을 삭제 하려면?
			names.remove(1);
		// 0 번방의 "에이콘"을 넣고(끼워넣기) 싶으면?
			names.add(0,"에이콘");
			names.set(0, "에이콘");
		// 저장된 아이템의 갯수(size)를 size라는 지역 변수에 담아 보세요
			int size=names.size();
			
		// 저장된 모든 아이템 전체 삭제
			names.clear(); 
			names.removeAll(names);
		
	}
}
