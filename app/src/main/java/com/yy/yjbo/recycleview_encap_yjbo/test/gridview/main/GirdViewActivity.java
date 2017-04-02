package com.yy.yjbo.recycleview_encap_yjbo.test.gridview.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.yy.yjbo.recycleview_encap_yjbo.R;
import com.yy.yjbo.recycleview_encap_yjbo.test.util.Item;

import java.util.ArrayList;

/**
 * 网格参考：http://www.cniao5.com/forum/thread/2ac69d820f0611e790dc00163e0230fa
 * 分割线参考：http://www.2cto.com/kf/201602/489367.html
 * 对GridView标签进行封装
 * @author yjbo
 * @time 2017/4/1 21:11
 */

public class GirdViewActivity extends AppCompatActivity {

    private GridViewAdapter mAdapter;
    private GridView mListView;
    private ArrayList<Item> Datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        initView();
        initData();
        setTitle(""+this.getIntent().getStringExtra("title"));
    }


    //添加数据
    protected void initData() {

        Datas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Item item = new Item(R.mipmap.ic_launcher_round, " get 新技能" + i, "拣到漂亮妹子 " + i + " 枚，在大街上");
            Datas.add(item);
        }

        mAdapter = new GridViewAdapter(Datas, this);
        mListView.setAdapter(mAdapter);
    }

    protected void initView() {
        mListView = (GridView) findViewById(R.id.swipe_target_2);
    }


}