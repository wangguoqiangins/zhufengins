package com.qianfeng.zhufengfm.app.parsers;

import com.qianfeng.zhufengfm.app.model.CategoryTagMenu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/7/28
 * Email: vhly@163.com
 */
public final class DataParser {

    private DataParser(){

    }

    /**
     * 解析 CategoryTagMenuTask 返回的JSON结果
     * @param json JSONObject
     * @return List&lt;CategoryTagMenu&gt;
     */
    public static List<CategoryTagMenu> parseCategoryTagMenuResult(JSONObject json){
        List<CategoryTagMenu> ret = null;
        if (json != null) {
            try {
                int code = json.getInt("ret");

                if(code == 0){

                    JSONObject data = json.getJSONObject("data");

                    int category_count = data.getInt("category_count");

                    if(category_count > 0){

                        JSONArray array = data.getJSONArray("category_list");

                        category_count = array.length();

                        if(category_count > 0){

                            ret = new LinkedList<CategoryTagMenu>();

                            for (int i = 0; i < category_count; i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                CategoryTagMenu menu = new CategoryTagMenu();

                                // 实体类，自己解析自己的数据
                                menu.parseJSON(jsonObject);

                                ret.add(menu);
                            }

                        }

                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

}
