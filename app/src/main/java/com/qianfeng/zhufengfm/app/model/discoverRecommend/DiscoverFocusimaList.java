package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 *  "id": 3597,
 "shortTitle": "中国每天2亿人乘电梯，安全吗？",
 "longTitle": "中国每天2亿人乘电梯，安全吗？",
 "pic": "http://fdfs.xmcdn.com/group15/M06/52/77/wKgDaFW16vfD9nFSAAHBRSk6xm4459_android_large.jpg",
 "type": 2,
 "uid": 30495264,
 "albumId": 2814299,
 "isShare": false,
 "is_External_url": false
 */
public class DiscoverFocusimaList {
    public int id;
    public String shortTitle;
    public String longTitle;
    public String pic;
    public int type;
    public long uid;
    public int albumId;
    public boolean isShare;
    public boolean is_External_url;
    public int specialId;
    public int subType;
    public int trackId;
    public String url;

    public DiscoverFocusimaList() {
    }

    @Override
    public String toString() {
        return "DiscoverFocusimaList{" +
                "id=" + id +
                ", shortTitle='" + shortTitle + '\'' +
                ", longTitle='" + longTitle + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                ", uid=" + uid +
                ", albumId=" + albumId +
                ", isShare=" + isShare +
                ", is_External_url=" + is_External_url +
                ", specialId=" + specialId +
                ", subType=" + subType +
                ", trackId=" + trackId +
                ", url='" + url + '\'' +
                '}';
    }
}
