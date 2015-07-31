package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * "albumId": 343042,
 "coverLarge": "http://fdfs.xmcdn.com/group6/M0A/E0/7E/wKgDhFUc5qbjBmDbAAAps8N-LbI468_mobile_large.jpg",
 "title": "重点关注",
 "tags": "东广新闻台",
 "tracks": 572,
 "playsCounts": 100781,
 "isFinished": 0,
 "trackId": 7991015,
 "trackTitle": "“电梯吃人”事故,谁来负责？"
 */
public class DiscoverHotListSub {
    public int albumId;
    public String coverLarge;
    public String title;
    public String tags;
    public int tracks;
    public int playsCounts;
    public int isFinished;
    public int trackId;
    public String trackTitle;

    @Override
    public String toString() {
        return "DiscoverHotListSub{" +
                "albumId=" + albumId +
                ", coverLarge='" + coverLarge + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", tracks=" + tracks +
                ", playsCounts=" + playsCounts +
                ", isFinished=" + isFinished +
                ", trackId=" + trackId +
                ", trackTitle='" + trackTitle + '\'' +
                '}';
    }
}
