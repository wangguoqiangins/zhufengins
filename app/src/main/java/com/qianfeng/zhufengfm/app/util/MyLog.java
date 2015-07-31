package com.qianfeng.zhufengfm.app.util;

/**
 * Created by Administrator on 15-7-31.
 */

import android.util.Log;

/**
 * 封装Android Log 工具，能够增加日志的开关
 */
public final class MyLog {
    private static final boolean DEBUG = true;
    private static final boolean INFO = true;

    private MyLog(){

    }
    public static void d(String tag,String msg){
        if(DEBUG){
        Log.d(tag, msg);
        }
    }
    public static void i(String tag,String msg){
        if(INFO){
            Log.d(tag, msg);
        }
    }
}
