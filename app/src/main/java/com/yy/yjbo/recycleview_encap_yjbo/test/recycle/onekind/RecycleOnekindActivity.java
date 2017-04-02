package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.onekind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;

/**
 * 参考：http://www.cniao5.com/forum/thread/107b6b5210fe11e790dc00163e0230fa
 * recycleview的单种类型的界面
 *
 * @author yjbo
 * @time 2017/4/1 23:10
 */
public class RecycleOnekindActivity extends AppCompatActivity {
    private ArrayList<Item> Datas;
    private RecyclerAdapterDemo mAdapterDemo;
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
//        //添加布局管理器--列表
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //添加布局管理器--网格
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }

    //添加数据
    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Item item = new Item(R.mipmap.ic_launcher_round, " get 新技能" + i, "拣到漂亮妹子 " + i + " 枚，在大街上");
            Datas.add(item);
        }
        mAdapterDemo = new RecyclerAdapterDemo(this, Datas);
        mRecyclerView.setAdapter(mAdapterDemo);
    }


}