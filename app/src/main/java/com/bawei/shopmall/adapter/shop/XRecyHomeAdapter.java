package com.bawei.shopmall.adapter.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shopmall.R;
import com.bawei.shopmall.bean.shop.HomeBannerBean;
import com.bawei.shopmall.bean.shop.HomeListBean;
import com.bawei.shopmall.layout.ImageNum;
import com.bawei.shopmall.layout.LayoutNum;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:程金柱
 * Date:2019/6/18 14:59
 * Description：
 */

public class XRecyHomeAdapter extends XRecyclerView.Adapter {
    private Context context;

    public XRecyHomeAdapter(Context context) {
        this.context = context;
    }

    private List<HomeBannerBean.Result> banner;

    public void setBanner(List<HomeBannerBean.Result> banner) {
        this.banner = banner;
        notifyDataSetChanged();
    }

    private HomeListBean.ResultBean list;

    public void setList(HomeListBean.ResultBean list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private int bannernum = 0;
    private int rxxpnum = 1;
    private int mlssnum = 2;
    private int pzshnum = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new BannerHandler(from.inflate(LayoutNum.HOME_BANNER, viewGroup, false));
            case 1:
                return new RxxpHandler(from.inflate(LayoutNum.HOME_RXXP, viewGroup, false));
            case 2:
                return new MlssHandler(from.inflate(LayoutNum.HOME_MLSS, viewGroup, false));
            case 3:
                return new PzshHandler(from.inflate(LayoutNum.HOME_PZSH, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:

                ((BannerHandler) viewHolder).xbanner_home.setBannerData(banner);
                ((BannerHandler) viewHolder).xbanner_home.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner xbanner, Object model, View view, int position) {
                        Glide.with(context).load(banner.get(position).imageUrl).error(ImageNum.IMAGE_ERROR)
                               .into((ImageView) view);
                    }
                });
                ((BannerHandler) viewHolder).xbanner_home.setIsClipChildrenMode(true);
                ((BannerHandler) viewHolder).xbanner_home.setAutoPlayAble(true);
                ((BannerHandler) viewHolder).xbanner_home.setAutoPalyTime(3000);

                ((BannerHandler) viewHolder).xbanner_home.startAutoPlay();
                break;
            case 1:
                HomeListBean.ResultBean.RxxpBean rxxp = list.getRxxp();
                ((RxxpHandler) viewHolder).rxxp_title.setText(rxxp.getName());
                    ((RxxpHandler) viewHolder).recy_rxxp.setLayoutManager(new LinearLayoutManager(context));
                    ((RxxpHandler) viewHolder).recy_rxxp.setAdapter(new HomeRxxpAdapter(context, list.getRxxp().getCommodityList()));

                break;
            case 2:

                    HomeListBean.ResultBean.MlssBean mlss = list.getMlss();
                    ((MlssHandler) viewHolder).mlss_title.setText(mlss.getName());
                    ((MlssHandler) viewHolder).recy_mlss.setLayoutManager(new LinearLayoutManager(context));
                    HomeMlssAdapter homeMlssAdapter = new HomeMlssAdapter(context, mlss.getCommodityList());
                    ((MlssHandler) viewHolder).recy_mlss.setAdapter(homeMlssAdapter);

                break;
            case 3:

                    HomeListBean.ResultBean.PzshBean pzsh = list.getPzsh();
                    ((PzshHandler) viewHolder).pzsh_title.setText(pzsh.getName());
                    ((PzshHandler) viewHolder).recy_pzsh.setLayoutManager(new GridLayoutManager(context,2));
                    HomePzshAdapter homePzshAdapter = new HomePzshAdapter(context, pzsh.getCommodityList());
                    ((PzshHandler) viewHolder).recy_pzsh.setAdapter(homePzshAdapter);
            break;

        }
    }

    @Override
    public int getItemCount() {

if (list!=null){
    return 4;
}else {
    return 1;
}


    }

    /**
     * list上的排列顺序
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return bannernum;
            case 1:
                return rxxpnum;
            case 2:
                return mlssnum;
            case 3:
                return pzshnum;
        }
        return super.getItemViewType(position);
    }


    /**
     * 首页banner的适配器
     */
    public class BannerHandler extends XRecyclerView.ViewHolder {
        @BindView(R.id.xbanner_home)
        XBanner xbanner_home;

        public BannerHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


    public class RxxpHandler extends XRecyclerView.ViewHolder {
        @BindView(R.id.rxxp_title)
        TextView rxxp_title;
        @BindView(R.id.recy_rxxp)
        RecyclerView recy_rxxp;
        public RxxpHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class MlssHandler extends XRecyclerView.ViewHolder {
        @BindView(R.id.mlss_title)
        TextView mlss_title;
        @BindView(R.id.recy_mlss)
        RecyclerView recy_mlss;
        public MlssHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class PzshHandler extends XRecyclerView.ViewHolder {
        @BindView(R.id.pzsh_title)
        TextView pzsh_title;
        @BindView(R.id.recy_pzsh)
        RecyclerView recy_pzsh;
        public PzshHandler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
