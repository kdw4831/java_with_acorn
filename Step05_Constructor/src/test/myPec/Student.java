package test.myPec;

public class Student {
		//new Student()
		// 생성자를 call하는 표현식
		// constuctor 를  call하는 표현식
		// 클래스는 최소 하나의 constructor를 가지고 있다.
		//메소드와 비슷한 형식을 지니고 있지만 리턴타입이 없다 그리고 동시에 클래스명과 동일해야한다. 
		
		//생성자(constructor)
		public Student() {
			//객체를 생성하는 시점에 무언가 준비 작업을 하고 싶으면 여기서 한다.
			System.out.println("Student() 생성자 호출됨");
			
		}
		
		public void study() {
			System.out.println("공부해요!");
		}
	
	
}
