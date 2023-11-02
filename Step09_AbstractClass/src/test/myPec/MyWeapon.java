package test.myPec;

//추상클래스는 상속받으면 안됨 부모가 가지고 있는 추상메소드를 반드시 오버라이딩을 해야한다
//즉 , 자식클래스를 통해서 생성을 하면 Weapon type의 참조값을 얻을 수 있다!!!!
public class MyWeapon extends Weapon{

	// 부모 클래스의 추상메소드를 반드시(강제로) 오버라이드 해야한다.
	@Override
	public void attack() {
		// 어디를 공격할지는 프로젝트 상황에 맞게 마음대로 공격하면 된다.
		System.out.println("지상 공격을 해요!");
		
	}

}
