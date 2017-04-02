package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.addheadfoot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.MutipleAdaper;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;
/**
 * recycle添加头文件和尾部文件
 * @author yjbo
 * @time 2017/4/2 10:51
 */

public class AddHeadFootActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private MutipleAdaper mMutipleAdaper;
    private WrapRecyclerAdapter mWrapRecyclerAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_onekind);
        initView();
        initData();
        setTitle(""+this.getIntent().getStringExtra("title"));
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
        mWrapRecyclerAdapter = new WrapRecyclerAdapter(mMutipleAdaper);
        mRecyclerView.setAdapter(mWrapRecyclerAdapter);

        View headerView = LayoutInflater.from(this).inflate(R.layout.layout_header, mRecyclerView, false);
        View footView = LayoutInflater.from(this).inflate(R.layout.layout_footer, mRecyclerView, false);
        mWrapRecyclerAdapter.addHeaderView(headerView);
        mWrapRecyclerAdapter.addFooterView(footView);
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

}