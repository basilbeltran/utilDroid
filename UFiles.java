/**
 * 
 */
package com.quietretreat.util;

import com.quietretreat.WHOOPEE.Global;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author basil
 *
 */
public class UFiles {
    
    /* If the directory does not exists: create-it */
    public static File touchDirectory(String dirname) {
        File f = new File(dirname);
        if (f.exists()) {
            return null;
        } else {
            f.mkdirs();
            return f;
        }
}

    /* If the file does not exists: create-it */
    public static File  touchFile(String filename) {
        File f = new File(filename);
        if (f.exists()) {
            return f;
        } else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return f;
        }
}
    
public static boolean CopyAssetDir(Context ctx, String assetDirName, String destPath) {
    if(Global.DEBUG) Log.i( Utils.getTag(), assetDirName+":"+destPath);
    boolean retVal = true;
    AssetManager assetManager = ctx.getAssets();
    String[] files = null;
    try {
        files = assetManager.list(assetDirName);
    } catch (IOException e) {
        Log.e(Utils.getTag(), e.getMessage());
        e.printStackTrace();
        retVal = false;
    }
    for(int i=0; i<files.length; i++) {
        if(Global.DEBUG) Log.d( Utils.getTag(), assetDirName+Global.FS+files[i]);

        InputStream in = null;
        OutputStream out = null;
        try {
          in = assetManager.open(assetDirName+Global.FS+files[i]);
          out = new FileOutputStream(destPath + files[i]);
          copyStream(in, out);
          in.close();
          in = null;
          out.flush();
          out.close();
          out = null;
        } catch(Exception e) { 
           if( e.getMessage().contains("audio") )  retVal = true;
           else {
               e.printStackTrace();
               retVal=false;
           }
        } //catch    
    }   //for
    return retVal;
 }        

public static boolean copyStream(InputStream is, OutputStream os) {
    boolean retVal = false;
    byte[] buffer = new byte[1024];
    int read;
    try {
        while((read = is.read(buffer)) != -1){
          os.write(buffer, 0, read);
        }
    } catch (IOException e) {
        retVal=false;
        e.printStackTrace();
      }
    return retVal;
}

public static File[] getFiles(String dir) {
    File d= new File(dir);
    return (d.listFiles());     
}

public void writeObject(String[] sA, File file){
try {
      FileOutputStream buf = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(buf);
      
      oos.writeObject(sA);  // Write the String array to a file
      oos.close();
    }catch(Exception x) {
        x.printStackTrace();
     }
}

public void readObject(File file){
    try{
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
      String[] sAI = (String[])ois.readObject();
    
    }catch(Exception x) {
      x.printStackTrace();
      return;
    }
}


}//UFiles

    


