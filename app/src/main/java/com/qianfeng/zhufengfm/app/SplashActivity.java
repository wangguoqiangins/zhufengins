package com.qianfeng.zhufengfm.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import com.qianfeng.zhufengfm.app.model.CategoryTagMenu;
import com.qianfeng.zhufengfm.app.parsers.DataParser;
import com.qianfeng.zhufengfm.app.tasks.TaskCallback;
import com.qianfeng.zhufengfm.app.tasks.TaskResult;
import com.qianfeng.zhufengfm.app.tasks.impl.CategoryTagMenuTask;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 启动扉页，程序入口点
 */
public class SplashActivity extends FragmentActivity implements TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 启动扉页没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // 启动扉页，进行网络检查与网络请求，下载数据
        // 最终显示主界面

        CategoryTagMenuTask task =
                new CategoryTagMenuTask(this);
        task.execute();

    }

    @Override
    public void onTaskFinished(TaskResult result) {
       if(result != null){

           int taskId = result.taskId;

           Object data = result.data;

           if (taskId == TaskConstants.TASK_CATEGORY_TAG_MENU){
               // TODO 获取 category_tag_menu的数据

               if(data != null){
                   if(data instanceof JSONObject){
                       JSONObject json = (JSONObject) data;

                       Log.d("SplashActivity", "json " + json.toString());

                       List<CategoryTagMenu> categoryTagMenuList =
                               DataParser.parseCategoryTagMenuResult(json);

                       // TODO 存储CategoryTagMenu

                   }
               }

               // TODO 处理之后，判断教程的启动
           }

       }
    }
}
