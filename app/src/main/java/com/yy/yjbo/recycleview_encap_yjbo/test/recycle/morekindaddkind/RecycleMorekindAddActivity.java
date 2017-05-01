package com.yy.yjbo.recycleview_encap_yjbo.test.recycle.morekindaddkind;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private LinearLayout titleLayout;
    private TextView txt_Title;
    private GridLayoutManager gridLayoutManager;
    private int lastFirstVisibleItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_morekind_add);
        initView();
        initData();
        setTitle("" + this.getIntent().getStringExtra("title"));
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target_onekind);
        txt_Title = (TextView) findViewById(R.id.txt_Title);
        titleLayout = (LinearLayout) findViewById(R.id.title_layout);

        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //添加布局管理器--列表
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //添加布局管理器--网格
        gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);


    }


    //填充数据
    protected void initData() {
        Datas = new ArrayList<>();
        for (int i = 0; i <= 60; i++) {
            if (i % 7 != 0) {
                int flag = i;
                if (i<7){
                    flag = 2;
                }else if (i<14){
                    flag = 3;
                }else if (i<21){
                    flag = 4;
                }else if (i<35){
                    flag = 5;
                }else if (i<49){
                    flag = 6;
                }else if (i<61){
                    flag = 7;
                }
                Datas.add(new Item(R.mipmap.ic_launcher_round, "" + i, flag));//根据 Item 类 最后一个参数确定填充数据的不同
            } else {
                Datas.add(new Item(R.mipmap.ic_launcher_round, "" + i, 1));
            }
        }
        mMutipleAdaper = new MutipleAddAdaper(this, Datas);
        mRecyclerView.setAdapter(mMutipleAdaper);
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mMutipleAdaper.refreshOne(Datas, 2);
//            }
//        },1000);

        /**
         *
         * 这里，我们根据控件的滚动情况，来对菜单栏进行处理。
         *
         * 这里可以参看http://blog.csdn.net/chenguang79/article/details/52247912
         *          http://blog.csdn.net/guolin_blog/article/details/9033553
         */
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int visibleItemCount,
                                   int totalItemCount) {
                super.onScrolled(recyclerView, visibleItemCount, totalItemCount);
                //取得当前屏幕可见数据的第一个值
                int firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();

//                int section = Datas.indexOf(firstVisibleItem);
                int nextSecPosition = getLastIndex(firstVisibleItem);

                if (firstVisibleItem != lastFirstVisibleItem) {
                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout.getLayoutParams();
                    params.topMargin = 0;
                    titleLayout.setLayoutParams(params);
                    txt_Title.setText(Datas.get(firstVisibleItem).getTv1()+"==="+nextSecPosition+"==="+firstVisibleItem);
                }
                if (nextSecPosition == firstVisibleItem + 1) {
                    View childView = recyclerView.getChildAt(0);
                    if (childView != null) {
                        int titleHeight = titleLayout.getHeight();
                        int bottom = childView.getBottom();
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout
                                .getLayoutParams();
                        if (bottom < titleHeight) {
                            float pushedDistance = bottom - titleHeight;
                            params.topMargin = (int) pushedDistance;
                            titleLayout.setLayoutParams(params);
                        } else {
                            if (params.topMargin != 0) {
                                params.topMargin = 0;
                                titleLayout.setLayoutParams(params);
                            }
                        }
                    }
                }
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                //取得当前屏幕可见数据的第一个值
//                int firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();
//
//                //取得当前屏幕可见数据的第一个值的类别值
//                int section = Datas.get(firstVisibleItem).getType();
//
//                //取得当前屏幕可见数据的第一个值的类别值在类别顺序中的下一个类别值
//                int nextSecPosition = getLastIndex(section);
//
//                if (firstVisibleItem != lastFirstVisibleItem) {
//                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout.getLayoutParams();
//                    params.topMargin = 0;
//                    titleLayout.setLayoutParams(params);
//                    txt_Title.setText(Datas.get(firstVisibleItem).getTv1() + "=====");
//                }
//
//
//                if (nextSecPosition == firstVisibleItem + 1) {
//                    View childView = recyclerView.getChildAt(0);
//                    if (childView != null) {
//
//                        int titleHeight = titleLayout.getHeight();
//                        int bottom = childView.getBottom();
//                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout
//                                .getLayoutParams();
//                        if (bottom < titleHeight) {
//                            float pushedDistance = bottom - titleHeight;
//                            params.topMargin = (int) pushedDistance;
//                            titleLayout.setLayoutParams(params);
//                        } else {
//                            if (params.topMargin != 0) {
//                                params.topMargin = 0;
//                                titleLayout.setLayoutParams(params);
//                            }
//                        }
//                    }
//                }
                lastFirstVisibleItem = firstVisibleItem;
            }
        });

    }

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });

    /**
     * 根据传入的当前类别值，取出下一个类别的第一条记录的排序号，就是在数据列表中的顺序
     * <p>
     * 这里的值，大家可以根据自己的实际情况去算一下。
     *
     * @param i 当前类别值
     * @return 下一个类别的第一条记录的排序号
     */
    private int getLastIndex(int i) {
//        switch (i) {//1-5 ：是第一节点下的数据的长度值（7）-（减去）【网格的列数（3） or 列表数（1）】+（加上）1
//            case 0:
//                return 0;
//            case 1:
//                return 5;
//            case 2:
//                return 12;
//            case 3:
//                return 25;
//            default:
//                return 0;
//        }
        int count = 0;
        int lineCount = gridLayoutManager.getSpanCount();
        int kind = Datas.get(i).getType();
        int countItem = 0;//显示出来的那个子布局所在的位置，以及其总共的数量
        if (kind != 1) {//是网格布局时：
            for (int j = i + 1; j < Datas.size(); j++) {
                if (kind != Datas.get(j).getType()) {
                    countItem = j;
                    break;
                }
            }
        }else {
            countItem = i;
        }
        if (Datas.get(i).getType() == 1)
        {//说明该属性是标题，头文件 列表
            count = countItem  - 1 +1;
        }else {//网格
            count = countItem  - lineCount +1;
        }
//       if (gridLayoutManager.getSpanCount() != 1){//每行几个
//           for (int j=0;j<Datas.size();j++){
//           }
//           count = 0;
//       }
        return count;
    }
}