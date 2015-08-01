package com.qianfeng.zhufengfm.app.model.discoverRecommend;

import android.util.Log;
import com.qianfeng.zhufengfm.app.model.discoverHotList.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */
public class DiscoverRecommend {
    private int ret;
    private DiscoverRecommendDiscoverycolumns discoveryColumns;
    private DiscoverEditorRecommendAlbums editorRecommendAlbums;
    private DiscoverHotRecommends hotRecommends;
    private DiscoverFocusima focusima;
    private String msg;
    private DiscoverSpecial special;

    public DiscoverRecommend() {
    }

    public int getRet() {
        return ret;
    }

    public DiscoverRecommendDiscoverycolumns getDiscoveryColumns() {
        return discoveryColumns;
    }

    public DiscoverEditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public DiscoverHotRecommends getHotRecommends() {
        return hotRecommends;
    }

    public DiscoverFocusima getFocusima() {
        return focusima;
    }

    public String getMsg() {
        return msg;
    }

    public DiscoverSpecial getSpecial() {
        return special;
    }

    public void parseJSON(JSONObject json) throws JSONException {
        if (json != null) {
            Log.d("json",json.toString());
            ret = Integer.parseInt(json.getString("ret"));
            //解析第二个参数 ：discoveryColumns
            discoveryColumns = new DiscoverRecommendDiscoverycolumns();
            List<DiscoverRecommendDisSub> list1 = new LinkedList<DiscoverRecommendDisSub>();
            JSONObject disObj = json.getJSONObject("discoveryColumns");
            discoveryColumns.ret = Integer.parseInt(disObj.getString("ret"));
            discoveryColumns.title = disObj.getString("title");
            JSONArray disList1 = disObj.getJSONArray("list");
            for (int i = 0; i < disList1.length(); i++) {
                JSONObject subjson = disList1.getJSONObject(i);
                DiscoverRecommendDisSub sub1 = new DiscoverRecommendDisSub();
                sub1.id = Integer.parseInt(subjson.getString("id"));
                sub1.orderNum = subjson.getInt("orderNum");
                sub1.title = subjson.getString("title");
                sub1.subtitle = subjson.getString("subtitle");
                sub1.coverPath = subjson.getString("coverPath");
                sub1.contentType = subjson.getString("contentType");
                sub1.url = subjson.getString("url");
                sub1.sharePic = subjson.getString("sharePic");
                sub1.enableShare = subjson.getBoolean("enableShare");
                sub1.contentUpdatedAt = subjson.getInt("contentUpdatedAt");
                list1.add(sub1);
                discoveryColumns.list = list1;
            }
            discoveryColumns.locationInHotRecommend = disObj.getInt("locationInHotRecommend");
            //解析第三个参数 ：editorRecommendAlbums
            JSONObject editobj = json.getJSONObject("editorRecommendAlbums");
            List<DiscoverEditorSub> listedit = new LinkedList<DiscoverEditorSub>();
            editorRecommendAlbums = new DiscoverEditorRecommendAlbums();
            editorRecommendAlbums.ret = editobj.getInt("ret");
            editorRecommendAlbums.title = editobj.getString("title");
            editorRecommendAlbums.hasMore = editobj.getBoolean("hasMore");
            JSONArray editarry = editobj.getJSONArray("list");
            for (int i = 0; i < editarry.length(); i++) {
                JSONObject editsub = editarry.getJSONObject(i);
                DiscoverEditorSub sub2 = new DiscoverEditorSub();
                sub2.albumId = editsub.getInt("albumId");
                sub2.coverLarge = editsub.getString("coverLarge");
                sub2.title = editsub.getString("title");
                sub2.tags = editsub.getString("tags");
                sub2.tracks = editsub.getInt("tracks");
                sub2.playsCounts = editsub.getInt("playsCounts");
                sub2.isFinished = editsub.getInt("isFinished");
                sub2.trackId = editsub.getInt("trackId");
                sub2.trackTitle = editsub.getString("trackTitle");
                listedit.add(sub2);
                editorRecommendAlbums.list = listedit;
                Log.d("editorRecommendAlbums",editorRecommendAlbums.toString());
            }
            //解析第四个参数 ：hotRecommends
            JSONObject hotobj = json.getJSONObject("hotRecommends");
            DiscoverHotList hotList = new DiscoverHotList();
            List<DiscoverHotList> listHot = new LinkedList<DiscoverHotList>();//第一个list
            hotRecommends = new DiscoverHotRecommends();
            hotRecommends.ret = hotobj.getInt("ret");

            hotRecommends.title = hotobj.getString("title");
            JSONArray hotarry1 = hotobj.getJSONArray("list");
            for (int i = 0; i < hotarry1.length(); i++) {
                JSONObject hot = hotarry1.getJSONObject(i);
                hotList.title = hot.getString("title");
                hotList.contentType = hot.getString("contentType");
                hotList.isFinished = hot.getBoolean("isFinished");
                hotList.categoryId = hot.getInt("categoryId");
                hotList.count = hot.getInt("count");
                hotList.hasMore = hot.getBoolean("hasMore");

                DiscoverHotListSub sublist = new DiscoverHotListSub();
                List<DiscoverHotListSub> listSub = new LinkedList<DiscoverHotListSub>();
                JSONArray hotarry2 = hot.getJSONArray("list");
                for (int j = 0; j < hotarry2.length(); j++) {
                    JSONObject hotsubobj = hotarry2.getJSONObject(j);
                    sublist.albumId = hotsubobj.getInt("albumId");
                    sublist.coverLarge = hotsubobj.getString("coverLarge");
                    sublist.title = hotsubobj.getString("title");
                    sublist.tags = hotsubobj.getString("tags");
                    sublist.tracks = hotsubobj.getInt("tracks");
                    sublist.playsCounts = hotsubobj.getInt("playsCounts");
                    sublist.isFinished = hotsubobj.getInt("isFinished");
                    sublist.trackId = hotsubobj.getInt("trackId");
                    sublist.trackTitle = hotsubobj.getString("trackTitle");
                    listSub.add(sublist);
                    hotList.list = listSub;
                }
                listHot.add(hotList);
            }
            hotRecommends.list = listHot;
            //解析第五个参数 ：focusImages
            JSONObject focobj = json.getJSONObject("focusImages");
            focusima = new DiscoverFocusima();
            focusima.ret = focobj.getInt("ret");
            JSONArray focary = focobj.getJSONArray("list");
            //以下这个是新的list集合
//            List<DiscoverHotSubMain> listMain = new LinkedList<DiscoverHotSubMain>();
//            //添加list集合元素
//            listMain.add(new DiscoverHotSubMain());
//            listMain.add(new DiscoverHotSubMain0());
//            listMain.add(new DiscoverMainSub1());
//            listMain.add(new DiscoverMainSub2());
//            listMain.add(new DiscoverMainSub3());
//            listMain.add(new DiscoverMainSub4());
//            listMain.add(new DiscoverMainSub5());
//            for (int i = 0; i < focary.length(); i++) {
//                JSONObject focobjsub = focary.getJSONObject(i);
//                for (int j = 0; j < listMain.size(); j++) {
//                    listMain.get(j).id = focobjsub.getInt("id");
//                    listMain.get(j).shortTitle = focobjsub.getString("shortTitle");
//                    listMain.get(j).longTitle = focobjsub.getString("longTitle");
//                    listMain.get(j).pic = focobjsub.getString("pic");
//                    listMain.get(j).type = focobjsub.getInt("type");
//                    listMain.get(j).isShare = focobjsub.getBoolean("isShare");
//                    listMain.get(j).is_External_url = focobjsub.getBoolean("is_External_url");
//                }
//                ((DiscoverHotSubMain0)listMain.get(1)).uid = focobjsub.getLong("uid");
//                ((DiscoverHotSubMain0)listMain.get(1)).albumId = focobjsub.getInt("albumId");
//                ((DiscoverMainSub1)listMain.get(2)).specialId = focobjsub.getInt("specialId");
//                ((DiscoverMainSub1)listMain.get(2)).subType = focobjsub.getInt("subType");
//                ((DiscoverMainSub2)listMain.get(3)).trackId = focobjsub.getInt("trackId");
//                ((DiscoverMainSub2)listMain.get(3)).uid = focobjsub.getInt("uid");
//                ((DiscoverMainSub3)listMain.get(4)).trackId = focobjsub.getInt("trackId");
//                ((DiscoverMainSub3)listMain.get(4)).uid= focobjsub.getInt("uid");
//                ((DiscoverMainSub4)listMain.get(5)).trackId = focobjsub.getInt("trackId");
//                ((DiscoverMainSub4)listMain.get(5)).uid = focobjsub.getInt("uid");
//                ((DiscoverMainSub5)listMain.get(6)).url = focobjsub.getString("url");
//            }

            //以下这个list集合是focusima的元素
            List<DiscoverFocusimaList> focusimaLists = new LinkedList<DiscoverFocusimaList>();

            for (int i = 0; i < focary.length(); i++) {
                JSONObject focobjsub = focary.getJSONObject(i);
                Log.d("focobjsub=======",""+focobjsub.toString());
                DiscoverFocusimaList focu = new DiscoverFocusimaList();


                focu.id = focobjsub.getInt("id");
                focu.shortTitle = focobjsub.getString("shortTitle");
                focu.longTitle = focobjsub.getString("longTitle");
                focu.pic = focobjsub.getString("pic");
                Log.d("pic====",focu.pic);
                focu.type = focobjsub.getInt("type");
                focu.uid = focobjsub.optLong("uid");
                focu.albumId = focobjsub.optInt("albumId");
                focu.isShare = focobjsub.getBoolean("isShare");
                focu.is_External_url = focobjsub.getBoolean("is_External_url");

                focusimaLists.add(focu);
            }

            focusima.list = focusimaLists;
            focusima.title = focobj.getString("title");
            //第六个参数 ：msg
            msg = json.getString("msg");
            //解析第七个参数 ：specialColumn
            JSONObject speobj = json.getJSONObject("specialColumn");
            special = new DiscoverSpecial();
            special.ret = speobj.getInt("ret");
            special.title = speobj.getString("title");
            special.hasMore = speobj.getBoolean("hasMore");
            JSONArray spearry = speobj.getJSONArray("list");
            List<DiscoverSpecialList> spel = new LinkedList<DiscoverSpecialList>();
            for (int i = 0; i < spearry.length(); i++) {
                JSONObject spesubobj = spearry.getJSONObject(i);
                DiscoverSpecialList spelsub = new DiscoverSpecialList();
                spelsub.columnType = spesubobj.getInt("columnType");
                spelsub.specialId = spesubobj.getInt("specialId");
                spelsub.title = spesubobj.getString("title");
                spelsub.subtitle = spesubobj.getString("subtitle");
                spelsub.footnote = spesubobj.getString("footnote");
                spelsub.coverPath = spesubobj.getString("coverPath");
                spelsub.contentType = spesubobj.getInt("contentType");
                spel.add(spelsub);
            }
            special.list = spel;
        }
    }

    @Override
    public String toString() {
        return "DiscoverRecommend{" +
                "ret=" + ret +
                ", discoveryColumns=" + discoveryColumns +
                ", editorRecommendAlbums=" + editorRecommendAlbums +
                ", hotRecommends=" + hotRecommends +
                ", focusima=" + focusima +
                ", msg='" + msg + '\'' +
                ", special=" + special +
                '}';
    }
}
