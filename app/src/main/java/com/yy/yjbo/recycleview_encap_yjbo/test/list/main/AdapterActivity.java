package com.yy.yjbo.recycleview_encap_yjbo.test.list.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.yy.yjbo.recycleview_encap_yjbo.R;

import java.util.ArrayList;

/**
 * 参考：http://www.cniao5.com/forum/thread/2ac69d820f0611e790dc00163e0230fa
 * 对listview的标签进行的封装
 * @author yjbo
 * @time 2017/4/1 21:05
 */

public class AdapterActivity extends Activity {

    private SimpleAdapter mAdapter;
    private ListView mListView;
    private ArrayList<Item> Datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    //添加数据
    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Item item = new Item(R.mipmap.ic_launcher_round, " get 新技能" + i, "拣到漂亮妹子 " + i + " 枚，在大街上");
            Datas.add(item);
        }

        mAdapter = new SimpleAdapter(Datas, this);
        mListView.setAdapter(mAdapter);
    }

    protected void initView() {
        mListView = (ListView) findViewById(R.id.swipe_target);
    }


}