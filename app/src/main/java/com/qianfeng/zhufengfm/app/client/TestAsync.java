package com.qianfeng.zhufengfm.app.client;

import android.os.AsyncTask;
import android.widget.TextView;
import com.qianfeng.zhufengfm.app.model.discoverRecommend.DiscoverRecommend;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 15-7-30.
 */
public class TestAsync extends AsyncTask<String,Void,String>{
    TextView textView;
    DiscoverRecommend recommend ;


    public TestAsync(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {
        byte [] arr = null;
        arr = HttpUtil.doGet(params[0]);
        String result = new String(arr);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        recommend = new DiscoverRecommend();
        try {
            JSONObject jsonObject = new JSONObject(s);
            recommend.parseJSON(jsonObject);

            textView.setText(recommend.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
