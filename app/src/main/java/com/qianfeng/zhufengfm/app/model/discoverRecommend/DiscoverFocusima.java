package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import com.qianfeng.zhufengfm.app.model.discoverHotList.DiscoverHotSubMain;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverFocusima {
    public int ret;
    public List<DiscoverFocusimaList> list;
//    public List<DiscoverHotSubMain> list;
    public String title;
    @Override
    public String toString() {
        return "DiscoverFocusima{" +
                "ret=" + ret +
                ", listMain=" + list +
                ", title='" + title + '\'' +
                '}';
    }
}
