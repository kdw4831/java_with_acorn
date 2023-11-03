package test.main;

import test.myPec.Weapon;

public class MainClass05 {
	//main 메서드에서 사용하려고 static붙임
	//내부클래스(inner Class)
	static class SeaWeapon extends Weapon{

		@Override
		public void attack() {
			System.out.println("바다에 있는 적들을 공격하세요");
			
		}
		
	}
	
	public static void main(String[] args) {
		//바다를 공격하는 무기를 만들어서 사용하고 싶다
		Weapon w1= new SeaWeapon();
		w1.prepare();
		w1.attack();
		
		// 우주를공격하는 무기를 만들어서 이용하고 싶다.
		class SpaceWeapon extends Weapon{

			@Override
			public void attack() {
				System.out.println("우주에 있는 적들을 공격해요!");
			}
		}
		Weapon w2= new SpaceWeapon();
		w2.prepare();
		w2.prepare();
	}

}
