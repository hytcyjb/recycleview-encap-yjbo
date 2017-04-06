package com.yy.yjbo.recycleview_encap_yjbo;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.test.gridview.main.GirdViewActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.list.main.ListActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addheadfoot.AddHeadFootActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addheadfootgird.AddHeadFootGirdActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addmuiltitem.AddMuiltItemActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.RecycleMorekindActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.RecyclerMoreKindViewAdapter;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind.RecycleOnekindActivity;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.rcutil.RecyclerViewHolder;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.MutipleTypeSupport;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.commonutil;

import java.util.List;

/**
 * Created by admin on 2017/4/2.
 */

public class MainAdapter  extends RecyclerMoreKindViewAdapter<Item> {
    private Context mcontext;
    public MainAdapter(Context context, List<Item> datas) {

        super(context, datas, new MutipleTypeSupport<Item>() {
            @Override
            public int getLayoutId(Item item) {
                if (item.getType() == 1){//该处1是通过 item 传过来的
                    return R.layout.list_item;
                }else {
                    return R.layout.list_item1;
                }
            }
        });
    this.mcontext = context;
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, final Item item, final int position) {
        holder.setText(R.id.tv1, item.getTv1())
                .setText(R.id.tv2,item.getTv2())
                .setImageResource(R.id.img, item.getRes())
                .setOnClickListener(R.id.img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position == 0){
                            commonutil.skipAct(mcontext, ListActivity.class,item.getTv1());
                        }else if (position == 1){
                            commonutil.skipAct(mcontext, GirdViewActivity.class,item.getTv1());
                        }else if (position == 2){
                            commonutil.skipAct(mcontext, RecycleOnekindActivity.class,item.getTv1());
                        }else if (position == 3){
                            commonutil.skipAct(mcontext, RecycleMorekindActivity.class,item.getTv1());
                        }else if (position == 4){
                            commonutil.skipAct(mcontext, AddHeadFootActivity.class,item.getTv1());
                        }else if (position == 5){
                            commonutil.skipAct(mcontext, AddHeadFootGirdActivity.class,item.getTv1());
                        }else if (position == 6){
                            commonutil.skipAct(mcontext, AddMuiltItemActivity.class,item.getTv1());
                        }
                    }
                })
                .setOnClickListener(R.id.liner_item, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mcontext,"点击了布局==="+position,Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
