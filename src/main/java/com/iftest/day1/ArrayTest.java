package com.iftest.day1;

public class ArrayTest {
	public static void main(String [] args){
	int[] array={1,4,5,6,7,8};
	//输出数组中的7
	System.out.println(array[4]);
	//输出数组正序
	for(int i=0;i<array.length;i++){//length不是方法
		System.out.println(array[i]);
	}
	//输出数组的倒序
	for(int i=array.length-1;i >= 0;i--){
	System.out.println(array[i]);
	}
	
	for(int i:array){
		System.out.println(i);
	} 
	
	}
}
