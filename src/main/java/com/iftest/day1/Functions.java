package com.iftest.day1;

public class Functions {
	public  static void main(String [] args){
		
		Demo d=new Demo();
//		�޲��޷�
		d.func1();
//		�в��޷�
		d.func2(1,2);
//		�޲��з�
		int sum=d.func3();
		System.out.print(sum);
//	           �в��з�
		int sum1 = d.func4(1, 2);
		System.out.print(sum1);
	}
}
