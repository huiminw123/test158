package com.iftest.day2;

public class StringTest {
	public static void main(String[] args){
		String str="abcdef";
		char c=str.charAt(4);
		System.out.println(c);
		
		int length = str.length();
		System.out.println(length);
		
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
		for(int i=str.length()-1;i>=0;i--){
			System.out.println(str.charAt(i));
		}
		if(str.equals("abcdef")){
			System.out.println("equals");
		}else{
			System.out.println("not equals");
		}
		String str1=" abc def ";
		System.out.println(str1.length());
		System.out.println(str1);
		System.out.println(str1.trim().length());
		System.out.println(str1.trim());
		isParlindrome("789");
	}
	public static void isParlindrome(String str){
		//回文字符
		String reversed="";
//		for(int i = str.length()-1;i >=0;i--){
//			reversed = reversed + str.charAt(i);
//			System.out.println(reversed);
//		}
		StringBuffer sb=new StringBuffer(str);
		reversed = sb.reverse().toString();
		if(str.equals(reversed)){
			System.out.println(str + "是回文字符串");
		}else{
			System.out.println(str + "不是回文字符串");
		}
		
	}
}
