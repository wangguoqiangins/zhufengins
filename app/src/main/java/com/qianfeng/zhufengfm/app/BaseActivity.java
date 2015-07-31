package com.qianfeng.zhufengfm.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * 基础的activity
 */
public class BaseActivity extends FragmentActivity {

    private TextView textView;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //TODO 进行公共的，一些控件的内容初始化
        //只要调用了setContentView就可以findviewbyid了
        textView = (TextView) findViewById(R.id.common_header_title);
        if(textView != null){

        textView.setText("设置");
        }
    }

    /**
     * activity设置标题的方法
     * @param title
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        if(textView != null){
            textView.setText(title);
        }
    }

    /**
     * 获取startactivity之后，新的activity进入的动画
     * 默认时从右往左，如果定制不同的动画，重写这个方法即可
     * @return
     */
    protected int getEnterAnimationId(){
        return R.anim.anim_slide;
    }

    protected int getExitAnimationId(){
        return R.anim.anim_dropdown;
    }
    /**
     * 启动activity，并且给启动的activity指定一个动画
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(getEnterAnimationId(),R.anim.anim_dropdown);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.anim_dropdown);
    }
}
