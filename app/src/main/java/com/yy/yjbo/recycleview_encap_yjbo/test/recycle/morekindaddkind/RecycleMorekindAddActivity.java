package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekindaddkind;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;

/**
 * 参考：http://www.cniao5.com/forum/thread/f5906bb6122f11e7b98900163e0230fa
 * recycleview的多种类型的界面点击页面添加占据一整行的item
 *
 * @author yjbo
 * @time 2017/4/26 18:38
 */
public class RecycleMorekindAddActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private MutipleAddAdaper mMutipleAdaper;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_onekind);
        initView();
        initData();
        setTitle(""+this.getIntent().getStringExtra("title"));
    }
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //添加布局管理器--列表
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //添加布局管理器--网格
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }


    //填充数据
    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            if (i % 2 == 0) {
                Datas.add(new Item(R.mipmap.ic_launcher_round,"" + i,i));//根据 Item 类 最后一个参数确定填充数据的不同
            }else {
                Datas.add(new Item(R.mipmap.ic_launcher_round,"" + i,1));
            }
        }
        mMutipleAdaper = new MutipleAddAdaper(this,Datas);
        mRecyclerView.setAdapter(mMutipleAdaper);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMutipleAdaper.refreshOne(Datas, 2);
            }
        },1000);
    }
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });
}