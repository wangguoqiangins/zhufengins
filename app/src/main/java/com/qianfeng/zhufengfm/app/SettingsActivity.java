package com.qianfeng.zhufengfm.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.qianfeng.zhufengfm.app.client.HttpUtil;
import com.qianfeng.zhufengfm.app.client.TestAsync;
import com.qianfeng.zhufengfm.app.model.discoverRecommend.DiscoverRecommend;
import com.qianfeng.zhufengfm.app.tasks.TaskCallback;
import com.qianfeng.zhufengfm.app.tasks.TaskResult;
import com.qianfeng.zhufengfm.app.tasks.impl.DiscoverRecommendTask;
import org.json.JSONException;
import org.json.JSONObject;


public class SettingsActivity extends BaseActivity implements TaskCallback {
        private byte [] arr = new byte[1024] ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView textView = (TextView) findViewById(R.id.set_text);
        String path = "http://mobile.ximalaya.com/mobile/discovery/v1/recommends?channel=and-f6&device=android&includeActivity=true&includeSpecial=true&scale=2&version=4.1.7.1";

        setTitle("设置1");
        //new TestAsync(textView).execute(path);
        new DiscoverRecommendTask(this).execute();
    }


    @Override
    public void onTaskFinished(TaskResult result) {
        int id = result.taskId;
        Object data = result.data;
        if(id == Constants.TASK_DISCOVER_RECOMMEND){
            if(data instanceof JSONObject){
                JSONObject json = (JSONObject) data;
                DiscoverRecommend recommend = new DiscoverRecommend();
                try {
                    recommend.parseJSON(json);
//                    Log.d("recommend===",recommend.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
