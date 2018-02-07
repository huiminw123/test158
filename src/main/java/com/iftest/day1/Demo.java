package com.iftest.day1;

public class Demo {
	public static void main(String [] args){
//		调用无参无返的方法
		func1();
//		调用有参无返的方法
		func2(1,2);
		
//		调用无参有返的方法
		int sum =func3();
		System.out.println(sum);
//		调用有参有返的方法
		int sum1 =func4(1,2);
		System.out.println(sum1);
	}
//	无参无返
//	a=1,b=2,方法名func1,打印输出a和b的和
	public  static void func1(){
		int a=1;
		int b=2;
		int sum=a+b;
		System.out.print(sum);
	}
	
//	有参无返
	public  static void func2(int a,int b){
		int sum=a+b;
		System.out.print(sum);
	}
	
//	无参有返
	public static int func3(){
		int a=1;
		int b=2;
		int sum=a+b;
		return sum;
	}
	
//	有参有返
	public static int func4(int a,int b){
		
		int sum=a+b;
		return sum;
	}
}





