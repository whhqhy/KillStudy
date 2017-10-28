package com.pluswx.whh;

import static com.pluswx.whh.Print.*;

public class P140Simple17Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frog().swim();
		new Frog().walk();
		PrintInit("hello world!");
	}

}

class Amphibian{
	public Amphibian(){
		System.out.println("Amphibian()");
	}
	
	private void swim(){
		System.out.println("两栖动物会游泳");
	}
	
	void walk(){
		System.out.println("两栖动物会陆地行走");
	}
}

class Frog extends Amphibian{

	void swim() {
		// TODO Auto-generated method stub
		System.out.println("青蛙会swim");
	}
	
	
	
}
