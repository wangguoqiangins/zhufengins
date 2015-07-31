package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * "albumId": 344497,
 "coverLarge": "http://fdfs.xmcdn.com/group6/M02/35/45/wKgDhFTg4w_SDkc9AAT-fXngGBY184_mobile_large.jpg",
 "title": "黑先生在麦田咖啡馆",
 "tags": "民谣,80后,文艺",
 "tracks": 117,
 "playsCounts": 917714,
 "isFinished": 0,
 "trackId": 7898099,
 "trackTitle": "几米：音乐与绘本的美好邂逅"
 */
public class DiscoverEditorSub {
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
        return "DiscoverEditorSub{" +
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
