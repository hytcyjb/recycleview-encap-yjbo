package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekindaddkind;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.MutipleTypeSupport;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.rcutil.RecyclerViewHolder;

import java.util.List;

/**
 * 多样式的item使用的adapter
 *
 * @author yjbo
 * @time 2017/4/26 18:39
 */
public class MutipleAddAdaper extends RecyclerMoreKindViewAddAdapter<Item> {

    List<Item> mdatas;
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (mdatas.get(position).getType() == 1){
                        return gridManager.getSpanCount();
                    }else  {
                        return 1 ;
                    }
//                    if (mdatas.get(position).getType() == 0){//getItemViewType(position)
//                        return gridManager.getSpanCount();
//                    }else
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    public MutipleAddAdaper(Context context, List<Item> datas) {

        super(context, datas, new MutipleTypeSupport<Item>() {
            @Override
            public int getLayoutId(Item item) {
                if (item.getType() == 1) {//该处1是通过 item 传过来的
                    return R.layout.list_item1;
                } else {
                    return R.layout.list_item;
                }
            }
        });
        mdatas = datas;
    }

    /**
     * 加载更多的时候用到的
     *
     * @author yjbo  @time 2017/4/26 11:50
     */
    public void addMore(List<Item> datas, int add) {

        RecyclerAddMoreKindViewAdapter(datas, new MutipleTypeSupport<Item>() {
            @Override
            public int getLayoutId(Item item) {
                if (item.getType() == 1) {//该处1是通过 item 传过来的
                    return R.layout.list_item1;
                } else {
                    return R.layout.list_item;
                }
            }
        }, 1);

        mdatas = datas;
    }

    public void refreshOne(List<Item> datas, int position) {
        Item item1 = mDatas.get(position);
        item1.setType(10);
        mDatas.remove(position);
        mDatas.add(position, item1);
        notifyItemChanged(position);

        mdatas = mDatas;
    }

    @Override
    protected void bindData(final RecyclerViewHolder holder, final Item item, final int position, final List<Item> mDatas) {
//        setOnItemClick(holder, item, position);
        holder.setVisible(R.id.tv2,false);
        if (item.getTv1().contains("1")) {
            holder.setText(R.id.tv1, item.getTv1())
                    .setImageResource(R.id.img, item.getRes())
                    .setOnClickListener(R.id.img, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContext, item.getTv1() + "--11--" + position, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnClickListener(R.id.tv1, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext, item.getTv1() + "--11--" + position, Toast.LENGTH_SHORT).show();
//                            holder.setText(R.id.tv1, item.getTv1() + "yjbo----11");
                        }
                    });
        } else {
            holder.setText(R.id.tv1, item.getTv1())
                    .setImageResource(R.id.img, item.getRes())
                    .setOnClickListener(R.id.img, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContext, item.getTv1() + "----" + position, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnClickListener(R.id.tv1, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext, item.getTv1() + "--00--" + position, Toast.LENGTH_SHORT).show();
//                            holder.setText(R.id.tv1, item.getTv1() + "yjbo");
                        }
                    });
        }
    }
//    protected abstract void setOnItemClick(RecyclerViewHolder holder, Item item, int position);
}