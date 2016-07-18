package com.whhqhy.pluginimpl.interfaces;

import android.content.Context;

public abstract interface IDynamic {
	public abstract void methodWithCallBack(YKCallBack paramYKCallBack);

	public abstract void showPluginWindow(Context paramContext);

	public abstract void startPluginAcitvity(Context context, Class<?> cls);

	public abstract String getStringForResId(Context context);
}