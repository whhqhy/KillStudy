package com.whhqhy.pluginsdk.imp;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

import com.whhqhy.pluginimpl.interfaces.IDynamic;
import com.whhqhy.pluginimpl.interfaces.YKCallBack;
import com.whhqhy.pluginsdk.R;
import com.whhqhy.pluginsdk.bean.Bean;

public class Dynamic implements IDynamic {

	@Override
	public void methodWithCallBack(YKCallBack paramYKCallBack) {
		// TODO Auto-generated method stub
		Bean bean = new Bean();
		bean.setName("PLUGIN_SDK_USER");
		paramYKCallBack.callback(bean);
	}

	@Override
	public void showPluginWindow(Context paramContext) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new Builder(paramContext);
		builder.setMessage("对话框");
		builder.setTitle(R.string.hello_world);
		builder.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		Dialog dialog = builder.create();
		dialog.show();
	}

	@Override
	public void startPluginActivity(Context context, Class<?> cls) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, cls);
		context.startActivity(intent);
	}

	@Override
	public String getStringForResId(Context context) {
		// TODO Auto-generated method stub
		return context.getResources().getString(R.string.hello_world);
	}

}
