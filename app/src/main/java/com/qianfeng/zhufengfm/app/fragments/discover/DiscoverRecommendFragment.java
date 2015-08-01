package com.qianfeng.zhufengfm.app.fragments.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.qianfeng.zhufengfm.app.Constants;
import com.qianfeng.zhufengfm.app.R;
import com.qianfeng.zhufengfm.app.SettingsActivity;
import com.qianfeng.zhufengfm.app.TestActivity;
import com.qianfeng.zhufengfm.app.adapters.DiscoverRecommendAdapter;
import com.qianfeng.zhufengfm.app.model.discoverRecommend.DiscoverRecommend;
import com.qianfeng.zhufengfm.app.parsers.DataParser;
import com.qianfeng.zhufengfm.app.tasks.TaskCallback;
import com.qianfeng.zhufengfm.app.tasks.TaskResult;
import com.qianfeng.zhufengfm.app.tasks.impl.DiscoverRecommendTask;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */
public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback {

    private DiscoverRecommendAdapter adapter;

    public DiscoverRecommendFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discover_recommend, container, false);
        ListView listView = (ListView) ret.findViewById(R.id.discover_recommend_list);

        if (listView != null) {

            // TODO 设置实际数据的 Adapter
            /////
            adapter = new DiscoverRecommendAdapter(getActivity());
            listView.setAdapter(adapter);
        }

        return ret;

    }

    @Override
    public void onResume() {
        super.onResume();

        DiscoverRecommendTask task =
                new DiscoverRecommendTask(this);
        task.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(),SettingsActivity.class);
        startActivity(intent);
//        int headerViewsCount = 0;
//        if(parent instanceof ListView){
//            ListView listView = (ListView) parent;
//            headerViewsCount = listView.getHeaderViewsCount();
//            int footerViewsCount = listView.getFooterViewsCount();
//            position -= headerViewsCount;
//            if(footerViewsCount>0){
//                if(position>=30){
//                    //点的不是数据，
//                }else {
//
//                }
//            }else {
//                //点到数据上了
//            }
//
//        }
        FragmentActivity activity = getActivity();
        Toast.makeText(activity,"点击"+position+"viewscount",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {

            int taskId = result.taskId;

            Object data = result.data;

            if(taskId == Constants.TASK_DISCOVER_RECOMMEND){

                if (data != null) {
                    if (data instanceof JSONObject){
                        JSONObject json = (JSONObject) data;
                        DiscoverRecommend recommend = new DiscoverRecommend();
                        try {
                            recommend.parseJSON(json);
                            adapter.setRecommend(recommend);
                            Log.d("====ins","000000");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }

            }

        }
    }
}
