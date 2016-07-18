package com.whhqhy.pluginsdk.bean;

import com.whhqhy.pluginimpl.interfaces.IBean;

public class Bean implements IBean{
	
	String mName = "插件中设置的初始化名字";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return mName;
	}

	@Override
	public void setName(String paramString) {
		// TODO Auto-generated method stub
		this.mName = paramString;
	}

}
