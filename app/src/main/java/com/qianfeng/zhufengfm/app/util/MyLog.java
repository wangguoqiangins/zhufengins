package com.qianfeng.zhufengfm.app.util;

/**
 * Created by Administrator on 15-7-31.
 */

import android.util.Log;
import com.qianfeng.zhufengfm.app.BuildConfig;

/**
 * 封装Android Log 工具，能够增加日志的开关
 */
public final class MyLog {
    /**
     * 日志的开关，在release（发布软件包）的时候，关闭日志
     */
    private static final boolean DEBUG = true;
    private static final boolean INFO = true;
    public static final boolean ON = BuildConfig.DEBUG;
    private MyLog(){

    }
    public static void d(String tag,String msg){
        if(ON){
            if(DEBUG){
                Log.d(tag, msg);
            }
        }
    }
    public static void i(String tag,String msg){
        if(ON){
            if(INFO){
                Log.d(tag, msg);
            }
        }
    }
}
