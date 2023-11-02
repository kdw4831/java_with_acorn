package test.mypac;
/*
 * Member 객체 하나에 회원의 번호, 이름, 주소를 담기 위해  member 클래스를 설계 하려고 한다.
 */
public class Member {
		//int type을 담을 필드
		public int num;
		//String type을 담을 필드
		public String name;
		//String type을 담을 필드
		public String addr;
				
		public void showInfo() {
			// int num=100; this.num 하면 필드의 num을 가르키고 그냥 num하면 지역변수의 num을 가르킨다. 
			//this는 나의(바로 이 객체) 참조값을 가르킨다. this. 은 생략 가능하다.
			//this는 본인의 참조값을 가르킨다. 클래스 설계 시점에서 this는 무슨 값인지 알 수 없다
			String info="번호는 " + this.num +" 이고 이름은 "+this.name+"이고 주소는 " + this.addr+"입니다.";
			System.out.println(info);
			
			// this는 Member type이다 
			Member a = this;
		}
}
