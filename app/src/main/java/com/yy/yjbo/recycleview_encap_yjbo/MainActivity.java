package com.yy.yjbo.recycleview_encap_yjbo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekind.MutipleAdaper;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.DividerGridItemDecorationCopy;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.DividerItemDecorationApi;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;

/**
 * 封装adapter参考：http://www.cniao5.com/forum/thread/2ac69d820f0611e790dc00163e0230fa
 * 分割线：参考：https://github.com/hytcyjb/recycleview-yjbo.git
 * 封装list,griview,recycleview
 * @author yjbo
 * @time 2017/4/1 14:27
 * @mail 1457521527@qq.com
 */
public class MainActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private MainAdapter mMutipleAdaper;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_onekind);
        initView();
        initData();
        setTitle("对recycleview的adapter进行封装");
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecorationApi(this,DividerItemDecoration.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecorationCopy(this,0,0));
        //添加布局管理器--列表
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        //添加布局管理器--网格
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }


    //填充数据
    protected void initData() {
        Datas = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(R.array.main_activity);
        for (int i = 0; i < stringArray.length; i++) {
            Datas.add(new Item(R.mipmap.ic_launcher_round, stringArray[i], "点击图标可以跳转",1));
        }
        mMutipleAdaper = new MainAdapter(this, Datas);
        mRecyclerView.setAdapter(mMutipleAdaper);
    }
}
