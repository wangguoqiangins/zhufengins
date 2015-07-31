package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * "id": 1,
 "orderNum": 2,
 "title": "听友圈子",
 "subtitle": "给你获得一种超能力的机会，你选择什么超能力？",
 "coverPath": "http://fdfs.xmcdn.com/group9/M07/1C/8C/wKgDYlV3rd2zGc9PAAAgRAu1VLU052.png",
 "contentType": "xzone",
 "url": "",
 "sharePic": "",
 "enableShare": false,
 "contentUpdatedAt": 0
 */
public class DiscoverRecommendDisSub {
    public int id;
    public int orderNum;
    public String title;
    public String subtitle;
    public String coverPath;
    public String contentType;
    public String url;
    public String sharePic;
    public boolean enableShare;
    public int contentUpdatedAt;

    @Override
    public String toString() {
        return "DiscoverRecommendDisSub{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", contentType='" + contentType + '\'' +
                ", url='" + url + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", enableShare=" + enableShare +
                ", contentUpdatedAt=" + contentUpdatedAt +
                '}';
    }
}
