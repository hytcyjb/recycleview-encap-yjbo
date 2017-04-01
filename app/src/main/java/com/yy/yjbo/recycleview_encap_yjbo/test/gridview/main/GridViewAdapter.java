package com.yy.yjbo.recycleview_encap_yjbo.test.gridview.main;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.list.main.Item;
import com.yy.yjbo.recycleview_encap_yjbo.test.list.util.BaseAdapter;
import com.yy.yjbo.recycleview_encap_yjbo.test.list.util.BaseViewHolder;

import java.util.List;

public class GridViewAdapter extends BaseAdapter<Item> {

    public GridViewAdapter(List datas, Context context) {
        super(datas, context, R.layout.girdview_item);
    }

    @Override
    public void bindData(BaseViewHolder holder, final Item item) {

        holder.setText(R.id.tv1, item.getTv1())
                .setText(R.id.tv2, item.getTv2())
                .setImageResource(R.id.img, item.getRes())
                .setOnClickListener(R.id.img, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, item.getTv2(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}