package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addheadfoot;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.MutipleAdaper;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;

/**
 * recycle添加头文件和尾部文件---网格布局
 *
 * @author yjbo
 * @time 2017/4/2 10:51
 */

public class AddHeadFootGirdActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private MutipleAdaper mMutipleAdaper;
    private WrapRecyclerAdapter mWrapRecyclerAdapter;
    private RecyclerView mRecyclerView;
    private int countTopClick = 0;
    private int countButtomClick = 0;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_onekind);
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

        mMutipleAdaper = new MutipleAdaper(this, Datas);
        mRecyclerView.setAdapter(mMutipleAdaper);

        Toast.makeText(AddHeadFootGirdActivity.this, "5秒之后就添加头,尾文件", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initTopBottom();
                Toast.makeText(AddHeadFootGirdActivity.this, "5秒之后就更新头文件", Toast.LENGTH_SHORT).show();
                updateHRun();
            }
        }, 5 * 1000);

    }
    /**
     *  更新头文件内元素
     * @author yjbo  @time 2017/4/5 14:09
     */
    private void updateHRun() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (headerView != null) {
                    mWrapRecyclerAdapter.updateHeaderView(headerView, "头文件更新了一下啦！！！！");
                }
            }
        }, 5 * 1000);

    }

    private void initTopBottom() {
        mWrapRecyclerAdapter = new WrapRecyclerAdapter(mMutipleAdaper);
        mRecyclerView.setAdapter(mWrapRecyclerAdapter);

        headerView = LayoutInflater.from(this).inflate(R.layout.layout_header, mRecyclerView, false);
        final View footView = LayoutInflater.from(this).inflate(R.layout.layout_footer, mRecyclerView, false);
        mWrapRecyclerAdapter.addHeaderView(headerView);
        mWrapRecyclerAdapter.addFooterView(footView);

        mWrapRecyclerAdapter.updateHeaderView(headerView, "点击可以更新头部！！！！");

        final TextView tv1 = (TextView) headerView.findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTopClick++;
//                System.out.println("点击事件");
                mWrapRecyclerAdapter.updateHeaderView(headerView, "更新头部,第" + countTopClick + "次！！！！");
                if (countTopClick == 10) {
                    Toast.makeText(AddHeadFootGirdActivity.this, "再点击一次就去除头部！！！！", Toast.LENGTH_SHORT).show();
                    mWrapRecyclerAdapter.updateHeaderView(headerView, "再点击一次就去除头部！！！！");
                } else if (countTopClick == 11) {

                    countTopClick = 0;

                    mWrapRecyclerAdapter.removeHeaderView(headerView);
                    Toast.makeText(AddHeadFootGirdActivity.this, "5秒之后就恢复头文件", Toast.LENGTH_SHORT).show();

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mWrapRecyclerAdapter.addHeaderView(headerView);
                            mWrapRecyclerAdapter.updateHeaderView(headerView, "点击可以更新头部！！！！");
                        }
                    }, 5 * 1000);

                }
            }
        });
        final TextView tv2 = (TextView) footView.findViewById(R.id.tv1);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countButtomClick++;
                mWrapRecyclerAdapter.updateFooterView(footView, "更新底部,第" + countButtomClick + "次！！！！");
            }
        });
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });
}