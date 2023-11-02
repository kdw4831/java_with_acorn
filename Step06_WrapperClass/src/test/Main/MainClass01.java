package test.Main;
/*
 * [기본 data type의 참조 data type]
 * 
 * byte   : Byte
 * short  : Short
 * int    : Integer
 * long   : Long
 * 
 * float  : Float
 * double : Double
 * 
 * char   : Character
 * boolean: Boolean
 * 
 * - 때로는 기본데이터 type의 참조데이터 type이 필요할 때가 있다.
 * - 기본데이터 type을 객체에 포장(boxing)하는 형태이다.
 * - boxing과 unboxing은 자동으로 되기 때문에 프로그래머가 신경을 쓸 필요는 없다.
 * 
 */
public class MainClass01 {
	public static void main(String[] args) {
		// 기본 데이터 type 지역변수 num1
		int num1=10;
		// 참조 데이터 type 지역변수 num2
		//Integer num2 = new Integer(10); //이렇게 안해도 됨  (참조데이터타입 처럼 쓴다고 해서 굳이 new를 할 필요는 없네)
		Integer num2=10;
		
		//참조 데이터 type 이지만 기본 데이터 type 처럼 사용할 수 있다.
		int result1 = num2+1;
		int result2 = num1+num2;
		Integer result3 = num1+num2; 
		//정수 10을 문자열 "10"으로 변환해서 리턴해주는 메소드도 사용가능
		String result=num2.toString();
		//숫자모양을 가지고 있는 문자열을 숫자로 리턴
		int result4=Integer.parseInt("999");
		
	}
}
