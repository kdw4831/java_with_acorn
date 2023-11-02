package test.main;

public class MainClass06 {
	// static 메소드에서 사용하는 필드는 static 필드로 만들어야 사용할 수 있다.
	static int num=999;
	
	public static void main(String[] args) {
		//main() 메소드와 num 이라는 필드는 동일한 클래스의 멤버이기 때문에 Mainclass06.은 생략가능
		int result = num+1;  // MainClass06.num;
		
		//main() 메소드와 test()메소드는  동일한 클래스의 멤버이기 때문에 Mainclass06.은 생략가능
		test();    //MainClass06.test();
	}
	
	//static 메소드에서 사용되는 메소드는 satic 메소드로 만들어야 사용할 수 있다.
	public static void test() {
		
	}
}
