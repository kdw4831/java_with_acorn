package test.myPac;
/*
 * Dto => Data TransFer Object의 약자이다.
 * 
 * [작성 규칙]
 * 
 * 1. 디폴트 생성자가 반드시 있어야한다.
 * 2. 필드는 접근지정자가 private
 * 3. 필드는 접근 메소드 setter,getter 메소드가 있어야한다. 
 */
public class MemberDto {
	private int num;
	private String name;
	private String addr;
	
	public MemberDto() {}

	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	

	

}
