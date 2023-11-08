package test.myPec;

public class WordFilterException extends RuntimeException {
	//생성자의 인자로 예외 메세지를 전달 받아서
	public WordFilterException(String msg) {
		super(msg); //부모 생성자에 전달하면서 객체가 생성 되도록 한다.
	}

}
