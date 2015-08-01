package com.qianfeng.zhufengfm.app.adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.qianfeng.zhufengfm.app.R;
import com.qianfeng.zhufengfm.app.model.discoverRecommend.*;
import com.qianfeng.zhufengfm.app.tasks.ImageLoadTask;

import java.util.List;

/**
 * Created by Administrator on 15-7-30.
 */

/**
 * 发现部分->推荐列表adapter，需要支持多布局的处理
 */
public class DiscoverRecommendAdapter extends BaseAdapter{

    private Context context;//加载布局
    /**
     * 从接口获取的discover recommend内容，完整的推荐
     */
    private DiscoverRecommend recommend;

    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public DiscoverRecommendAdapter (Context context){
        this.context = context;
    }

    public DiscoverRecommendAdapter(Context context, DiscoverRecommend recommend) {
        this.context = context;
        this.recommend = recommend;
    }

    /**
     * 设置实际的数据
     * 需要在主线程调用更新
     * @param recommend
     */
    public void setRecommend(DiscoverRecommend recommend) {
        this.recommend = recommend;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        int ret = 0;

        if(recommend !=null){
            //3是"小编推荐"，“精品听单”，“发现新奇”
            int hotCount = 0;
            DiscoverHotRecommends hotRecommends = recommend.getHotRecommends();
            if(hotRecommends!=null){
                List<DiscoverHotList> hotLists = hotRecommends.list;
                hotCount = hotLists.size();
            }
            ret = 3 + hotCount;
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        Object ret = null;
        switch (position){
            case  0:
                ret = recommend.getEditorRecommendAlbums();
            break;
            case  1:
                ret = recommend.getSpecial();
            break;
            case  2:
                ret = recommend.getDiscoveryColumns();
            break;
            default:
                ret = recommend.getHotRecommends().list.get(position-3);
        }
        return  ret;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        Object item = getItem(position);

        int itemViewType = getItemViewType(position);
        Log.d("getView","position"+position);

        switch (itemViewType) {
            case 0:
                ret = bindEditorRecommendView(item, convertView, parent);
                break;
            case 1:
                ret = bindSpecialColumnView(item, convertView, parent);
                break;
            case 2:
                ret = bindDiscoverColumnsView(item, convertView, parent);
                break;
            case 3:
                ret = bindHotColumnView(item, convertView, parent);
                break;
        }

        return ret;


    }

    private View bindHotColumnView(Object item, View convertView, ViewGroup parent) {
        return null;
    }

    private View bindDiscoverColumnsView(Object item, View convertView, ViewGroup parent) {
        TextView ret = new TextView(context);
        ret.setText("发现新奇");
        return ret;
    }

    private View bindSpecialColumnView(Object item, View convertView, ViewGroup parent) {
        TextView ret = new TextView(context);
        ret.setText("精品听单");
        return ret;
    }

    private View bindEditorRecommendView(Object item, View convertView, ViewGroup parent) {
        View ret = null;
        Log.d("item====",""+item);

        // 加载布局
        if (convertView != null) {
            ret = convertView;
        } else {
            ret = LayoutInflater.from(context)
                    .inflate(R.layout.item_recommend_album, parent, false);
        }

        AlbumRecommendViewHolder holder =
                (AlbumRecommendViewHolder) ret.getTag();

        if (holder == null) {
            holder = new AlbumRecommendViewHolder();
            // TODO 加载View
            holder.txtTitle = (TextView) ret.findViewById(R.id.item_recommend_album_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_recommend_album_more);

            //////////////////////////
            // 设置 更多的点击处理事件

            holder.txtMore.setOnClickListener(onClickListener);

            //////////////////////////

            holder.block0 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block0);
            holder.block1 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block1);
            holder.block2 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block2);

            holder.block0ImageButton =
                    (ImageButton) holder.block0.getChildAt(0);

            holder.block0ImageButton.setOnClickListener(onClickListener);

            holder.block0TextView =
                    (TextView) holder.block0.getChildAt(1);

            holder.block1ImageButton =
                    (ImageButton) holder.block1.getChildAt(0);

            holder.block1ImageButton.setOnClickListener(onClickListener);

            holder.block1TextView =
                    (TextView) holder.block1.getChildAt(1);

            holder.block2ImageButton =
                    (ImageButton) holder.block2.getChildAt(0);
            holder.block2ImageButton.setOnClickListener(onClickListener);

            holder.block2TextView =
                    (TextView) holder.block2.getChildAt(1);

            ret.setTag(holder);
        }

        DiscoverEditorRecommendAlbums albums =
                (DiscoverEditorRecommendAlbums) item;
        Log.d("bindEditorRecommendView",""+albums.toString());
        String title = albums.title;
        holder.txtTitle.setText(title);

        //////////////////////////////////////////

        boolean hasMore = albums.hasMore;
        if (hasMore) {
            holder.txtMore.setVisibility(View.VISIBLE);
        } else {
            holder.txtMore.setVisibility(View.INVISIBLE);
        }

        //////////////////////////////////////////

        List<DiscoverEditorSub> list = albums.list;

        if (list != null) {

            int size = list.size();

            if (size > 3) {
                size = 3;
            }

            for (int i = 0; i < size; i++) {

                DiscoverEditorSub recommendsub = list.get(i);

                // 图片的网址
                String coverLarge = recommendsub.coverLarge;

                String tit = recommendsub.trackTitle;

                ImageView imageView = null;

                switch (i) {
                    case 0:
                        // TODO 需要显示图片
                        holder.block0TextView.setText(tit);
                        imageView = holder.block0ImageButton;
                        break;
                    case 1:
                        // TODO 需要显示图片
                        holder.block1TextView.setText(tit);
                        imageView = holder.block1ImageButton;
                        break;
                    case 2:
                        // TODO 需要显示图片
                        holder.block2TextView.setText(tit);
                        imageView = holder.block2ImageButton;
                        break;
                }

                if (imageView != null && coverLarge != null) {

                    imageView.setImageResource(R.mipmap.ic_launcher);

                    // 设置ImageView的 Tag，在异步任务中，需要检查这个Tag
                    imageView.setTag(coverLarge);

                    ImageLoadTask task = new ImageLoadTask(imageView);

                    // 手机版本的适配
                    if (Build.VERSION.SDK_INT >= 11) {
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
                    } else {
                        task.execute(coverLarge);
                    }
                }

            }

        }

        return ret;
//        TextView ret = new TextView(context);
//        ret.setText("精品听单");
//        return ret;
    }

    private static class AlbumRecommendViewHolder {
        public TextView txtTitle;
        public TextView txtMore;
        public LinearLayout block0;
        public LinearLayout block1;
        public LinearLayout block2;

        //// 每一个 block 的子内容

        public ImageButton block0ImageButton;
        public TextView block0TextView;

        public ImageButton block1ImageButton;
        public TextView block1TextView;

        public ImageButton block2ImageButton;
        public TextView block2TextView;
    }

    private static class HotRecommendViewHolder {
        public TextView txtTitle;
        public TextView txtMore;
        /**
         * 三块图片文字的布局 一共三个
         */
        public ViewGroup[] blocks;
    }
    @Override
    public int getViewTypeCount() {

        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        int ret = 0;
        Object item = getItem(position);
        if(item instanceof DiscoverEditorSub){
            ret = 0;
        }else  if(item instanceof DiscoverSpecial){
            ret = 1;
        }else if(item instanceof  DiscoverRecommendDiscoverycolumns){
            ret = 2;
        }else  if(item instanceof DiscoverHotListSub){
            ret = 3;
        }


        return ret;
    }

}
