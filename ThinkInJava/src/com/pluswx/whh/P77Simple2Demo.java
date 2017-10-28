package com.pluswx.whh;


public class P77Simple2Demo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("定义初始化"+new Rose().var1);
		System.out.println("构造器初始化"+new Rose().var2);

	}

}

class Rose{
	String var1 = "hello";
	String var2;
	public Rose() {
		super();
		var2 = "world!";
	}
	
	
}
