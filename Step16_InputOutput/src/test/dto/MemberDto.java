package test.dto;

import java.io.Serializable;
//MemberDto 객체가 ObjectOutputStream을 통해서 출력이 되려면 Serializable 인터페이스가 구현되어 있어야한다.
public class MemberDto implements Serializable{
	//필드
	private int num;
	private String name;
	private String addr;

	//디폴트 생성자
	public MemberDto() {
		
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

	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
}
