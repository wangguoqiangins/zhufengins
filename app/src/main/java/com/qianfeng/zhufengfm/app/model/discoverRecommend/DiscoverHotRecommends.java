package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverHotRecommends {
    public int ret;
    public String title;
    public List<DiscoverHotList> list;

    @Override
    public String toString() {
        return "DiscoverHotRecommends{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
