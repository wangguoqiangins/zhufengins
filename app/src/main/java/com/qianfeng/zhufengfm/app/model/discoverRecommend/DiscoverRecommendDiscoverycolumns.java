package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverRecommendDiscoverycolumns {
    /**
     *
     */
    public int ret;
    public String title;
    public List<DiscoverRecommendDisSub> list;
    public int locationInHotRecommend;

    @Override
    public String toString() {
        return "DiscoverRecommendDiscoverycolumns{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", list=" + list +
                ", locationInHotRecommend=" + locationInHotRecommend +
                '}';
    }
}
