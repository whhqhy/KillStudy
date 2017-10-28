package com.pluswx.whh;

import static com.pluswx.whh.Print.*;

public class P147Simple23Demo  extends Insect{
	private int k = prints("Beetle.k initialized");
	
	public P147Simple23Demo() {
		PrintInit("k = "+k);
		PrintInit("j = "+j);
	}
	
	private static int x2 = prints("static Beetle.x2 initialzed");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintInit("Beetle constructor");
		P147Simple23Demo p = new P147Simple23Demo();
		PrintInit("--------------");
		P147Simple23Demo p2 = new P147Simple23Demo();
	}

}

class Insect{
	private int i = 9;
	protected int j;
	
	Insect(){
		PrintInit("i = " + i + ", j = "+j);
		j = 39;
	}
	
	private static int x1 = prints("static Insect.x1 initalized"); 
	
	static int prints(String s){
		PrintInit(s);
		return 47;
	}
}
