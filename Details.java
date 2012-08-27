package com.quietretreat.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import java.lang.reflect.Field;

import com.quietretreat.WHOOPEE.Global;
//TODO change this to a static mapped array
//TODO refactor using StringBuilder
public class Details {	
	

private Details() {}

public static String showAll(Activity a){
	showSystem(a);
	showApp(a);
	showActivity(a);
	return "";
}

public static void showSystem(Activity a){
 try{   

  	Log.i(Utils.getTag(), "System has " +"\n "+
    		//"PM =  " + android.content.pm.ApplicationInfo(). +"\n "+
    		"RootDir = " + Environment.getRootDirectory().getAbsolutePath()+"\n "+
  		"DataDir = " + Environment.getDataDirectory().getAbsolutePath()+"\n "+
    		"EsdDir = " + Environment.getExternalStorageDirectory().getAbsolutePath()+"\n "+
    		"EsdState = " + Environment.getExternalStorageState()+"\n "+
    		"CachDir = " + Environment.getDownloadCacheDirectory().getAbsolutePath()		

  	   );
     }catch (Exception e){ Log.d(Global.TAG, e.getMessage()+"\n" +e.toString());}
}

public static void showApp(Activity a){
 try{     
  	Log.i(Utils.getTag(), "App has " +"\n "+
		"AppCodePath =  " + a.getApplication().getPackageCodePath()+"\n "+  
		"processName =  " + a.getApplicationInfo().processName +"\n "+  
	      "packageName =  " + a.getApplicationInfo().packageName +"\n "+   
		"uid =  " + a.getApplicationInfo().uid  
	   
    );
 }catch (Exception e){ Log.d(Global.TAG, e.getMessage()+"\n" +e.toString());}
}

public static void showActivity(Activity a){
  try{     
      	Log.i(Utils.getTag(), "Activity has " +"\n "+
    		"title =  " + a. getTitle()  +"\n "+
    		"localName =  " + a.getLocalClassName()  +"\n "+
    		"TaskId =  " + a.getTaskId() +"\n "+
    		"FilesDirAP =  " + a.getFilesDir().getAbsolutePath() +"\n "+
    		"Assets =  " + Utils.printArray(a.getResources().getAssets().list("audio")) +"\n "+ 
    		"Resources =  " + a.getResources().toString() +"\n "+ 
    		"SystemR =  " + Resources.getSystem().toString()   +"\n "+  
    		"Configuration =  " + a.getResources().getConfiguration().toString() +"\n "+
    		"DBs =  " + Utils.printArray(a.databaseList())  +"\n "+
    		"Files =  " + Utils.printArray(a.fileList())     
    	   );
  }catch (Exception e){ Log.d(Global.TAG, e.getMessage()+"\n" +e.toString());}
 }



}//the very end
