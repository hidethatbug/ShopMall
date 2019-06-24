package com.bawei.shopmall.adapter.circle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.circle.CircleListBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:程金柱
 * Date:2019/6/21 9:46
 * Description：
 */

public class XRecyCircle extends XRecyclerView.Adapter<XRecyCircle.XRecyCircleHandler> {
    private Context context;

    public XRecyCircle(Context context) {
        this.context = context;
    }

    private List<CircleListBean.ResultBean> list;

    public void setList(List<CircleListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyCircleHandler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_item, viewGroup, false);
        return new XRecyCircleHandler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyCircleHandler xRecyCircleHandler, int i) {
        CircleListBean.ResultBean resultBean = list.get(i);
        xRecyCircleHandler.img_circle_item_content.setText(resultBean.getContent());
        xRecyCircleHandler.img_circle_item_nickName.setText(resultBean.getNickName());
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

        Glide.with(context).load(resultBean.getHeadPic()).apply(options).into(xRecyCircleHandler.img_circle_item_headPic);
    }

    @Override
    public int getItemCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    public class XRecyCircleHandler extends XRecyclerView.ViewHolder {
        @BindView(R.id.img_circle_item_content)
        TextView img_circle_item_content;
        @BindView(R.id.img_circle_item_headPic)
        ImageView img_circle_item_headPic;
        @BindView(R.id.img_circle_item_nickName)
        TextView img_circle_item_nickName;

        public XRecyCircleHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
