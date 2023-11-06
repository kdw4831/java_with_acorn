package test.main;

import test.myPec.Apple;
import test.myPec.FruitBox;
import test.myPec.Mellon;
import test.myPec.Orange;

public class MainClass01 {
	public static void main(String[] args) {
		
		//box와 box2에 .을 찍어서 차이점을 확인해 보세요
		FruitBox<Apple> box=new FruitBox<Apple>();
		FruitBox<Orange> box2=new FruitBox<Orange>();
		
		//객체 생성시에 Generic type은 생략 가능하다.
		FruitBox<Mellon> box3= new FruitBox<>();
		
		//Generic 클래스가 Apple로 되어 있는 객체 사용하기
		box.pack(new Apple());  //Apple type을 매개변수에 전달한다.
		Apple f1=box.unPack();  //Apple type이 리턴된다.
		
		//Generic 클래스가 Orange로 되어 있는 객체 사용하기
		box2.pack(new Orange()); //Orange type을 매개 변수에 전달한다.
		Orange f2=box2.unPack(); //Orange type이 리턴된다.
		
	}
}
