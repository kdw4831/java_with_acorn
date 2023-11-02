package test.auto;




// extends Car 이걸 붙이면 에러가 난다. 왜? 엔진객체의 참조값이 필요해 
//원래는 
public class SportsCar extends Car {
	
	//Engine 객체를 전달받는 생성자
	public SportsCar(Engine engine) {
		/*
		 * super()는 부모 생성자(Car 클래스의 생성자)를 의미한다.
		   부모 생성자에 필요한 값을 자식 생성자에게 받아서 전달해야한다. 
		   super()코드 실행전에 다른 코드가 있으면 안된다.
		 */
		super(engine); 
		
	}
	//메소드 부모클래스는 사물함에 포함되어있어서 this .으로 불러다 쓸 수 있다
	public void openDrive() {
		if(this.engine==null) {
			System.out.println("Engine이 없어서 달리수가 없어요!");
			return; //메소드를 여기서 리턴시키기(종료시키기)
		}
		System.out.println("뚜껑을 열고 달려요!");
		
	}
	
}
