package com.whhqhy.hostproject;

import java.io.File;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.whhqhy.pluginimpl.interfaces.IBean;
import com.whhqhy.pluginimpl.interfaces.IDynamic;
import com.whhqhy.pluginimpl.interfaces.YKCallBack;

import dalvik.system.DexClassLoader;

public class MainActivity extends Activity {
	
	private AssetManager mAssetManager; 
	private Resources mResources;
	private Theme mTheme;
	private String apkFileName = "PluginSDK.apk";
	private String dexpath = null;
	private File fileRelease = null;
	private DexClassLoader classLoader = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dexpath = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+apkFileName;
		File file = new File(dexpath);
		Log.e("DEMO", "file "+file.exists());
		fileRelease = getDir("dex", 0);
		
		/*初始化classloader 
         * dexpath dex文件地址 
         * fileRelease 文件释放地址  
         *  父classLoader 
         */  
          
        Log.d("DEMO", (getClassLoader()==ListView.class.getClassLoader())+"");  
        Log.d("DEMO",ListView.class.getClassLoader()+"");  
        Log.d("DEMO", Context.class.getClassLoader()+"");  
        Log.d("DEMO", Context.class.getClassLoader().getSystemClassLoader()+"");  
        Log.d("DEMO",Activity.class.getClassLoader()+"");  
        Log.d("DEMO", (Context.class.getClassLoader().getSystemClassLoader() == ClassLoader.getSystemClassLoader())+"");  
        Log.d("DEMO",ClassLoader.getSystemClassLoader()+"");  

		classLoader = new DexClassLoader(dexpath, fileRelease.getAbsolutePath(),null,getClassLoader());
		
		Button btn_1 = (Button)findViewById(R.id.btn_1);
		Button btn_2 = (Button)findViewById(R.id.btn_2);
		Button btn_3 = (Button)findViewById(R.id.btn_3);
		Button btn_4 = (Button)findViewById(R.id.btn_4);
		Button btn_5 = (Button)findViewById(R.id.btn_5);
		Button btn_6 = (Button)findViewById(R.id.btn_6);
		
		btn_1.setOnClickListener(new View.OnClickListener() {//普通调用  反射的方式
			@Override
			public void onClick(View arg0) {
				Class mLoadClassBean;
				try {
					mLoadClassBean = classLoader.loadClass("com.whhqhy.pluginsdk.bean.Bean");
					Object beanObject = mLoadClassBean.newInstance();
					Log.d("DEMO", "ClassLoader:"+mLoadClassBean.getClassLoader());
					Log.d("DEMO", "ClassLoader:"+mLoadClassBean.getClassLoader().getParent());
					Method getNameMethod = mLoadClassBean.getMethod("getName");
					getNameMethod.setAccessible(true);
					String name = (String) getNameMethod.invoke(beanObject);
					Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				} 
			}
		});
		btn_2.setOnClickListener(new View.OnClickListener() {//带参数调用
			@Override
			public void onClick(View arg0) {
				Class mLoadClassBean;
				try {
					mLoadClassBean = classLoader.loadClass("com.whhqhy.pluginsdk.bean.Bean");
					Object beanObject = mLoadClassBean.newInstance();
					//接口形式调用
					Log.d("DEMO", beanObject.getClass().getClassLoader()+"");
					Log.d("DEMO",IBean.class.getClassLoader()+"");
					Log.d("DEMO",ClassLoader.getSystemClassLoader()+"");
			        IBean bean = (IBean)beanObject;
			        bean.setName("宿主程序设置的新名字");
			        Toast.makeText(MainActivity.this, bean.getName(), Toast.LENGTH_SHORT).show();
				}catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				}
	           
			}
		});
		btn_3.setOnClickListener(new View.OnClickListener() {//带回调函数的调用
			@Override
			public void onClick(View arg0) {
				Class mLoadClassDynamic;
				try {
					mLoadClassDynamic = classLoader.loadClass("com.whhqhy.pluginsdk.imp.Dynamic");
					 Object dynamicObject = mLoadClassDynamic.newInstance();
					  //接口形式调用
		            IDynamic dynamic = (IDynamic)dynamicObject;
		            //回调函数调用
		            YKCallBack callback = new YKCallBack() {//回调接口的定义
		            	public void callback(IBean arg0) {
		            		Toast.makeText(MainActivity.this, arg0.getName(), Toast.LENGTH_SHORT).show();
		            	};
					};
		            dynamic.methodWithCallBack(callback);
				} catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				}
	           
			}
		});
		btn_4.setOnClickListener(new View.OnClickListener() {//带资源文件的调用
			@Override
			public void onClick(View arg0) {
				loadResources();
				Class mLoadClassDynamic;
				try {
					mLoadClassDynamic = classLoader.loadClass("com.whhqhy.pluginsdk.imp.Dynamic");
					Object dynamicObject = mLoadClassDynamic.newInstance();
					//接口形式调用
		            IDynamic dynamic = (IDynamic)dynamicObject;
		            dynamic.showPluginWindow(MainActivity.this);
				} catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				}
			}
		});
		btn_5.setOnClickListener(new View.OnClickListener() {//带资源文件的调用
			@Override
			public void onClick(View arg0) {
				loadResources();
				Class mLoadClassDynamic;
				try {
					mLoadClassDynamic = classLoader.loadClass("com.whhqhy.pluginsdk.imp.Dynamic");
					Object dynamicObject = mLoadClassDynamic.newInstance();
					//接口形式调用
		            IDynamic dynamic = (IDynamic)dynamicObject;
		            dynamic.startPluginActivity(MainActivity.this,
		            		classLoader.loadClass("com.plugindemo.MainActivity"));
				} catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				}
			}
		});
		btn_6.setOnClickListener(new View.OnClickListener() {//带资源文件的调用
			@Override
			public void onClick(View arg0) {
				loadResources();
				Class mLoadClassDynamic;
				try {
					mLoadClassDynamic = classLoader.loadClass("com.whhqhy.pluginsdk.imp.Dynamic");
					Object dynamicObject = mLoadClassDynamic.newInstance();
					//接口形式调用
		            IDynamic dynamic = (IDynamic)dynamicObject;
		            String content = dynamic.getStringForResId(MainActivity.this);
		            Toast.makeText(getApplicationContext(), content+"", Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Log.e("DEMO", "msg:"+e.getMessage());
				}
			}
		});
		
	}

	 protected void loadResources() {
	        try {
	            AssetManager assetManager = AssetManager.class.newInstance();
	            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
	            addAssetPath.invoke(assetManager, dexpath);
	            mAssetManager = assetManager;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Resources superRes = super.getResources();
	        superRes.getDisplayMetrics();
	        superRes.getConfiguration();
	        mResources = new Resources(mAssetManager, superRes.getDisplayMetrics(),superRes.getConfiguration());
	        mTheme = mResources.newTheme();
	        mTheme.setTo(super.getTheme());
	    }
	
	@Override
    public AssetManager getAssets() {
        return mAssetManager == null ? super.getAssets() : mAssetManager;
    }

    @Override
    public Resources getResources() {
        return mResources == null ? super.getResources() : mResources;
    }

    @Override
    public Theme getTheme() {
        return mTheme == null ? super.getTheme() : mTheme;
    }
}
