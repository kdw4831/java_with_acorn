package test.mypac;

public class Rect {
	//사각형이 폭과 높이를 저장할 필드
	public int width;
	public int height;
	
	
	//면적을 출력하는 메소드
	public void printArea() {
		//면적을 계산해서 
		int area= width*height;
		//출력하기
		System.out.println("면적은 : "+area);
	}
}
