package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind.RecyclerViewAdapter;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind.RecyclerViewHolder;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.MutipleTypeSupport;

import java.util.List;

public class MutipleAdaper extends RecyclerMoreKindViewAdapter<Item> {

    public MutipleAdaper(Context context, List<Item> datas) {

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

    }

    @Override
    protected void bindData(RecyclerViewHolder holder, final Item item, int position) {
        holder.setText(R.id.tv1, item.getTv1())
                .setImageResource(R.id.img, item.getRes())
                .setOnClickListener(R.id.img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, item.getTv1(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}