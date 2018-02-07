package com.iftest.day2;

public class ClassTest extends ExtendsB implements InterfaceA,InterfaceB{
	public static void main(String[] args){
		ExtendsB eb = new ExtendsB();
		eb.func2();
		
		ClassTest ct = new ClassTest();
		ct.func2();
		ct.func3();
		
		InterfaceA ia = new ClassTest();
		ia.func5();
	}

	public void func5() {
		// TODO Auto-generated method stub
		System.out.println("from func5");
	}

	public void func6() {
		// TODO Auto-generated method stub
		System.out.println("from func6");
	}

	public int func7() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int func8(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
