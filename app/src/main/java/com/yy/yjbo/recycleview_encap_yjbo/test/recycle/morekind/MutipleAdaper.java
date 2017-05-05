package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.flowTag.FlowLayout;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.flowTag.TagAdapter;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.flowTag.TagFlowLayout;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.rcutil.RecyclerViewHolder;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.MutipleTypeSupport;

import java.util.List;
/**
 * 多样式的item使用的adapter
 * @author yjbo
 * @time 2017/4/2 15:23
 */
public class MutipleAdaper extends RecyclerMoreKindViewAdapter<Item> {

    public MutipleAdaper(Context context, List<Item> datas) {

        super(context, datas, new MutipleTypeSupport<Item>() {
            @Override
            public int getLayoutId(Item item) {
                if (item.getType() == 1){//该处1是通过 item 传过来的
                    return R.layout.list_item;
                }else if (item.getType() == 2){
                    return R.layout.list_tagflowlayout;
                }else {
                    return R.layout.list_item1;
                }
            }
        });

    }
    /**
     * 加载更多的时候用到的
     * @author yjbo  @time 2017/4/6 11:50
     */
    public void addMore(List<Item> datas,int add) {

        RecyclerAddMoreKindViewAdapter(datas, new MutipleTypeSupport<Item>() {
            @Override
            public int getLayoutId(Item item) {
                if (item.getType() == 1){//该处1是通过 item 传过来的
                    return R.layout.list_item;
                }else if (item.getType() == 2){
                    return R.layout.list_tagflowlayout;
                }else {
                    return R.layout.list_item1;
                }
            }
        },1);
    }
    public void refreshOne(List<Item> datas,int position) {
        Item item1 = mDatas.get(position);
        item1.setTv1("yjbo在操作");
        mDatas.remove(position);
        mDatas.add(position,item1);
        notifyItemChanged(position);
    }
    @Override
    protected void bindData(final RecyclerViewHolder holder, final Item item, final int position, final List<Item> mDatas) {
//        setOnItemClick(holder, item, position);
        if (item.getType() == 0) {
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
                        holder.setText(R.id.tv1,item.getTv1()+"yjbo----11");
                        }
                    });
        }else  if (item.getType() == 2)  {
            final TagFlowLayout mFlowLayout = holder.getView(R.id.id_flowlayout);
            String[] array = mContext.getResources().getStringArray(R.array.tag_flow);
            final LayoutInflater mInflater;
            mInflater = LayoutInflater.from(mContext);
            mFlowLayout.setAdapter(new TagAdapter<String>(array) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) mInflater.inflate(R.layout.layout_tag_flow,
                            mFlowLayout, false);
                    tv.setText(s);
                    return tv;
                }
            });
            mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    Toast.makeText(mContext,"你点击了第"+position+"个",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }else  {
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
                        holder.setText(R.id.tv1,item.getTv1()+"yjbo");
                        }
                    });
        }
    }
//    protected abstract void setOnItemClick(RecyclerViewHolder holder, Item item, int position);
}