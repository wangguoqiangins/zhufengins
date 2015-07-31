package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

import java.util.List;

/**
 * "title": "听新闻",
 "contentType": "album",
 "isFinished": false,
 "categoryId": 1,
 "count": 822,
 "hasMore": true,
 "list": [
 */
public class DiscoverHotList {
    public String title;
    public String contentType;
    public boolean isFinished;
    public int categoryId;
    public int count;
    public boolean hasMore;
    public List<DiscoverHotListSub> list;

    @Override
    public String toString() {
        return "DiscoverHotList{" +
                "title='" + title + '\'' +
                ", contentType='" + contentType + '\'' +
                ", isFinished=" + isFinished +
                ", categoryId=" + categoryId +
                ", count=" + count +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
