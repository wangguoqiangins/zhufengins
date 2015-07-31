package com.qianfeng.zhufengfm.app.tasks.impl;

import com.qianfeng.zhufengfm.app.Constants;
import com.qianfeng.zhufengfm.app.client.ClientDiscoverAPI;
import com.qianfeng.zhufengfm.app.tasks.BaseTask;
import com.qianfeng.zhufengfm.app.tasks.TaskCallback;
import com.qianfeng.zhufengfm.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 15-7-31.
 */
public class DiscoverRecommendTask extends BaseTask{
    public DiscoverRecommendTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();

        ret.taskId = Constants.TASK_DISCOVER_RECOMMEND;

        // 调API
        String str = ClientDiscoverAPI.getDiscoverRecommend();

        try {
            ret.data = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ret;

    }
}
