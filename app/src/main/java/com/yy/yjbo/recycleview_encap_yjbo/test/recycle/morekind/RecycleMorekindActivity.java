package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind.RecyclerAdapterDemo;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考：http://www.cniao5.com/forum/thread/f5906bb6122f11e7b98900163e0230fa
 * recycleview的多种类型的界面
 *
 * @author yjbo
 * @time 2017/4/1 23:12
 */
public class RecycleMorekindActivity extends Activity {
//    private SimpleAdapter mAdapter;
    private ArrayList<Item> Datas;
    private MutipleAdaper mMutipleAdaper;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_onekind);
        initView();
        initData();
    }
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //添加布局管理器--列表
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        //添加布局管理器--网格
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }


    //填充数据
    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                Datas.add(new Item(R.mipmap.ic_launcher_round,"我 get 新技能 " + i,0));//根据 Item 类 最后一个参数确定填充数据的不同
            }else {
                Datas.add(new Item(R.mipmap.ic_launcher_round,"你 get 新技能 " + i,1));
            }
        }
        mMutipleAdaper = new MutipleAdaper(this,Datas);
        mRecyclerView.setAdapter(mMutipleAdaper);
    }

}