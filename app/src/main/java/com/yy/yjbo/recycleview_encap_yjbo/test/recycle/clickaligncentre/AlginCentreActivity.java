package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.clickaligncentre;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addheadfoot.WrapRecyclerAdapter;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.MutipleAdaper;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 * 作者：yjbo
 * 创建时间：2017/7/10
 * 邮箱：hytcyjbo@163.com
 */
public class AlginCentreActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_aligncentre);
        initView();
        initData();
        setTitle("" + this.getIntent().getStringExtra("title"));
    }

    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                Datas.add(new Item(R.mipmap.ic_launcher_round, "我 get 新技能 " + i, 0));
            } else {
                Datas.add(new Item(R.mipmap.ic_launcher_round, "你 get 新技能 " + i, 1));
            }
        }
        Datas.add(new Item(R.mipmap.ic_launcher_round, "你 get 新技能 " + 30, 2));
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, Datas);
        mRecyclerView.setAdapter(galleryAdapter);

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MoveToPosition(linearLayoutManager, 30);
//            }
//        }, 100);

    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public class GalleryAdapter extends
            RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
        private LayoutInflater mInflater;
        private ArrayList<Item> mDatas;

        public GalleryAdapter(Context context, ArrayList<Item> datats) {
            mInflater = LayoutInflater.from(context);
            mDatas = datats;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View arg0) {
                super(arg0);
            }

            ImageView mImg;
            TextView mTxt;
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = mInflater.inflate(R.layout.list_item2,
                    viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.mImg = (ImageView) view
                    .findViewById(R.id.img);
            viewHolder.mTxt = (TextView) view
                    .findViewById(R.id.tv1);
            return viewHolder;
        }

        /**
         * 设置值
         */
        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
//            viewHolder.mImg.setImageResource(mDatas.get(i));
            viewHolder.mTxt.setText(i + "");
            viewHolder.mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("yjbo", "onClick: "+i);
                    int moveX = mDatas.size() >= i ? i - 2 : i + 1;
//                    int moveX = i ;
                    MoveToPosition(linearLayoutManager, moveX);
                }
            });
        }

    }

    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager 设置RecyclerView对应的manager
     * @param n       要跳转的位置
     */
    public  void MoveToPosition(LinearLayoutManager manager, int n) {
        Toast.makeText(getApplicationContext(),"==="+n,Toast.LENGTH_SHORT).show();
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(true);
    }

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });
}