package me.samlss.broccoli.util;

import android.util.Log;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description util of log for this library.
 */
public class LogUtil {
    private final static String TAG = "Cradle";

    private LogUtil(){
        throw new UnsupportedOperationException("Can not be instantiated.");
    }

    public static final void logI(String string){
        Log.i(TAG, string);
    }

    public static final void logE(String string){
        Log.e(TAG, string);
    }
}
