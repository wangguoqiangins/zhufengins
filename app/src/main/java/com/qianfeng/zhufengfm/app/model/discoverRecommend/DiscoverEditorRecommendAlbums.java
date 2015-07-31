package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverEditorRecommendAlbums {
    public int ret;
    public String title;
    public boolean hasMore;
    public List<DiscoverEditorSub> list;

    @Override
    public String toString() {
        return "DiscoverEditorRecommendAlbums{" +
                "ret=" + ret +
                ", title='" + title + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
