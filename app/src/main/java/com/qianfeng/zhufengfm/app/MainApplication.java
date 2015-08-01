package com.qianfeng.zhufengfm.app;

import android.app.Application;
import com.qianfeng.zhufengfm.app.cache.FileCache;

/**
 * Created by Administrator on 15-8-1.
 */
public class MainApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FileCache.createInstance(getApplicationContext());
    }
}
