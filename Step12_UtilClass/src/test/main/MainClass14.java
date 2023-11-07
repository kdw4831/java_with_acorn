package test.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass14 {
	public static void main(String[] args) {
		//ArrayList 객체에 중복된 데이타를 담은 ㅏㄷ음
		List<Integer> nums=new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(10);
		nums.add(20);
		nums.add(30);
	
		//type확인(ArrayList도 Collection type이다.)
		Collection<Integer> nums2=nums;
		
		//HashSet 객체의 생성자에 arrayList를 전달해서 중복을 제어 할 수 있다.
		Set<Integer> set= new HashSet<>(nums);
		
		//중복 제거 된 Set을 이용해서 ArrayList 객체 새로 생성하기
		List<Integer> result= new ArrayList<Integer>(set);
		
		//오름차순 정렬
		Collections.sort(result);
		//내림차순 
		//Collections.sort(result,Collections.reverseOrder());
	}
}
