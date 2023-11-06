package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 *  Scanner 객체를 이용해서 이름을 반복문 돌면서 3명의 이름을 입력 받아서
		 *  
		 *  ArrayList 객체에 순서대로 저장하고 
		 *  
		 *  다 저장된 이후에 
		 *  
		 *  반복문 돌면서 ArrayList에 저장된 이름을 순서대로 콘솔창에 출력해 보세요
		 */
		
		Scanner sc= new Scanner(System.in);
		
		List<String> nameList =new ArrayList<>();
//		String name1=sc.nextLine();
//		String name2=sc.nextLine();
//		String name3=sc.nextLine();
//		
//		names.add(name1);
//		names.add(name2);
//		names.add(name3);
		
		// 반복문 돌면서 3명의 이름을 받아서 ArrayList 객체에 누적시키기
		for(int i=0; i<3; i++) {
			System.out.println("이름 입력: ");
			String name=sc.nextLine();
			nameList.add(name);
		}
		
		System.out.println("첫 번째 방법");
		
		for(int i=0; i<nameList.size(); i++) {
			System.out.println(nameList.get(i));
		}
		
		
		
		
		// 2번
		System.out.println("두 번째 방법");
		Consumer<String> con = new Consumer<>(){
			@Override
			public void accept(String t) {
				System.out.println(t);	
			}
		};
		nameList.forEach(con);
		
	
		
		//3번
		System.out.println("세 번째 방법");
		nameList.forEach(new Consumer<String>(){

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
			
		});
		
		
		//4번
		System.out.println("네 번째 방법");
		nameList.forEach((t)->{
			System.out.println(t);
		});
		
	}
}
