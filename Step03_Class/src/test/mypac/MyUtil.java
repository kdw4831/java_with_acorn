package test.mypac;

public class MyUtil {
	// static field
	public static String version="1.0.0";
	
	// static method
	//만약에 static 영역에 선언을 하면 new를 하지 않고 그냥 쓸 수 있다.
	public static void send() {
		System.out.println("전송합니다.");
	}
}
