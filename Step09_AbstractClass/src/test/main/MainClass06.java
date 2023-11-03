package test.main;

//new Weapon을 한 후 ctrl Space를 하면 오버라이드까지자동으로 생성해준다.
import test.myPec.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		
		
		Weapon w1= new Weapon() {
			
			@Override
			public void attack() {					//class? extends Weapon{@Override Public void attack(){}}
				System.out.println("아무나 공격하자");
				
			}
		};
		
		
		useWeapon(w1);
		
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("지겨버 아무나 공격하자");
				
			}
		});
	}
	
	
	//Weapon type의 참조값을 전달 받아서 사용하는 static 메소드 
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}

}
