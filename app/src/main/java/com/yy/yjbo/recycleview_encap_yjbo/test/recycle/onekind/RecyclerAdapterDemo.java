package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.rcutil.RecyclerViewHolder;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.List;

public class RecyclerAdapterDemo extends RecyclerViewAdapter<Item> {

    public RecyclerAdapterDemo(Context context, List<Item> datas) {
        super(context, R.layout.girdview_item, datas);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, final Item item, int position) {

        holder.setText(R.id.tv1, item.getTv1())
                .setOnClickListener(R.id.liner_item, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, item.getTv1(), Toast.LENGTH_SHORT).show();
                    }
                }).setOnLongClickListener(R.id.liner_item, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "长按：" + item.getTv1(), Toast.LENGTH_SHORT).show();
                return true;//true 表示不响应点击事件 false 长按事件结束还会响应点击事件
            }
        });

        //加载网络图片
        holder.setImagePath(R.id.img, new RecyclerViewHolder.ImageLoder("http://tomcat.apache.org/images/tomcat.png") {
            @Override
            public void loadImage(ImageView imageView, String path) {
                Glide.with(mContext)
                        .load(path)
                        .placeholder(R.mipmap.ic_launcher_round) // 同样也可以是drawble
                        .error(R.mipmap.ic_launcher)// 当不能加载时载入
                        .into(imageView);
            }
        });
    }
}