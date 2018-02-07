package com.iftest.day1;

public class Functions {
	public  static void main(String [] args){
		
		Demo d=new Demo();
//		无参无返
		d.func1();
//		有参无返
		d.func2(1,2);
//		无参有返
		int sum=d.func3();
		System.out.print(sum);
//	           有参有返
		int sum1 = d.func4(1, 2);
		System.out.print(sum1);
	}
}
