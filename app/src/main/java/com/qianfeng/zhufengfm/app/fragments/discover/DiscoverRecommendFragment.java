package com.qianfeng.zhufengfm.app.fragments.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.qianfeng.zhufengfm.app.R;
import com.qianfeng.zhufengfm.app.SettingsActivity;
import com.qianfeng.zhufengfm.app.TestActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/29
 * Email: vhly@163.com
 */
public class DiscoverRecommendFragment extends Fragment implements AdapterView.OnItemClickListener {

    public DiscoverRecommendFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discover_recommend, container, false);
        ListView listView = (ListView) ret.findViewById(R.id.discover_recommend_list);


        List<String> list = new LinkedList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("java..."+i);
        }
        if(listView!=null){
            //TODO 设置实际数据的adapter
            ////////
            //添加头部
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.mipmap.ic_launcher);
            listView.addHeaderView(imageView);//在setAdapter之前添加跟随滚动的header
            ImageView imageView1 = new ImageView(getActivity());
            imageView1.setImageResource(R.mipmap.ic_action_search);
            listView.addHeaderView(imageView1);
            //添加底部视图
            TextView btn = new TextView(getActivity());
            btn.setText("点击加载更多");
            listView.addFooterView(btn);
            ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1
            ,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);


        }

        return ret;

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
}
