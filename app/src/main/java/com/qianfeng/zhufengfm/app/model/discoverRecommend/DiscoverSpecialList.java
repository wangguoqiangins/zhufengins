package com.qianfeng.zhufengfm.app.model.discoverRecommend;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * "columnType": 1,
 "specialId": 348,
 "title": "5个如雷贯耳的脱口秀，高智商必听！",
 "subtitle": "人生不应该只有眼前的苟且，还有诗和远方！\r\n生活从来就不应该只有简单的吃饭穿衣，安身立命，人生除了温饱，还应该有另一个精神的高度，最终决定这个高度的，一定是眼界和见识，以及你碰到一个什么样的人生导师",
 "footnote": "5张专辑",
 "coverPath": "http://fdfs.xmcdn.com/group14/M04/4E/68/wKgDY1WyIl_jgde2AAG79hZ3Ml4209_mobile_small.jpg",
 "contentType": "1"
 */
public class DiscoverSpecialList {
    public int columnType;
    public int specialId;
    public String title;
    public String subtitle;
    public String footnote;
    public String coverPath;
    public int contentType;

    @Override
    public String toString() {
        return "DiscoverSpecialList{" +
                "columnType=" + columnType +
                ", specialId=" + specialId +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", footnote='" + footnote + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", contentType=" + contentType +
                '}';
    }
}
