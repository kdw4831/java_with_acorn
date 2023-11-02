package test.Main;

import test.myPec.AirPlane;
import test.myPec.Test;

public class MainClass02 {
	public static void main(String[] args) {
		Test t =new Test();
		
		t.doSomething(10, "kim", new AirPlane());
		
		t.send();
		t.send(10);
		t.send("kim");
		t.send(new AirPlane());
	}
}
