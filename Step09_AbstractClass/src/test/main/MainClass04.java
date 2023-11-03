package test.main;

public class MainClass04 {
	// static 메소드 안에서 사용하려면 static 예약어가 필요! 내부클래스에 한해서
	public static class Gura{
		public void say() {
			System.out.println("안녕 나는 구라야!");
		}
	}
	
	public static void main(String[] args) {
		Gura g=new Gura(); 
		g.say();
		
		class Cat{
			public void say() {
				System.out.println("야옹~");
			}
		}
		
		Cat c= new Cat();
		c.say();
	}

}
