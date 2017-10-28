package com.example.customview1;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        
        if(widthMode == MeasureSpec.EXACTLY){
        	width = widthSize;
        }else{
        	width = 200;
        	if(widthMode == MeasureSpec.AT_MOST){
        		width = Math.min(width, widthSize);
        	}
        }
        
        if(heightMode == MeasureSpec.EXACTLY){
        	height = heightSize;
        }else{
        	height = 100;
        	if(heightMode == MeasureSpec.AT_MOST){
        		height = Math.min(height, heightSize);
        	}
        }
        
		setMeasuredDimension(width, height);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}
	
	
	
	
	

}
