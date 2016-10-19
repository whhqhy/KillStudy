package com.worldhaoren.dexloader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	MyTest test;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		test = new MyTest();
	}
	
	public void btnClick(View v){
		test.PrintLog(this);
	}
}
