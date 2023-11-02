package test.myPec;
/*
 * Weapon 클래스를 만드는 개발자는 유틸리티 개발자 혹은 프레임워크 개발자 혹은 여러분의 회사 팀장이라고 생각하면된다.
 * 
 * 이 클래스를 팀원이 상속 받아서 사용하게 된다.
 * 
 * 특정 메소드는 상속받은 후 재정의(override)해서 사용하도록 미완성인 상태(추상메소드)로 제공한다.
 * 
 * 팀원은 추상메소드를 재정의 해서 자기 상황에 맞게끔 구현하면 된다.
 */

// 미완성된 추상메소드를 멤버로 가지고 있는 클래스는 abstract 예약어를 붙여서 정의 해야 한다.
public abstract class Weapon {

	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비합니다.");
	}
	//공격을 하는 메소드의 모양만 정의하고 실제 구현은 하지 않기
	//미완성된 추상메소드를 만들때는 abstract 예약어가 필요하다.
	public abstract void attack();
}
