package com.iftest.day2;

public class ExceptionTest {
	public static void main(String[] args){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
