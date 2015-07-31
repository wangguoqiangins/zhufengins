package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverSpecial {
    public int ret;
    public String title;
    public boolean hasMore;
    public List<DiscoverSpecialList> list;

    @Override
    public String toString() {
        return "DiscoverSpecial{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
