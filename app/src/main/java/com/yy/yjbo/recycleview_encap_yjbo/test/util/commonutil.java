package com.yy.yjbo.recycleview_encap_yjbo.test.util;

import android.content.Context;
import android.content.Intent;

import com.yy.yjbo.recycleview_encap_yjbo.R;

import java.util.ArrayList;

/**
 * 公共的方法
 *
 * @author yjbo
 * @time 2017/4/2 10:37
 */

public class commonutil {
    /**
     * 跳转类，带主题的
     * @author yjbo
     * @time 2017/4/2 11:02
     */
    public static void skipAct(Context mcontext, Class<?> cls, String title) {
        Intent intent = new Intent();
        intent.setClass(mcontext, cls);
        intent.putExtra("title", title);
        mcontext.startActivity(intent);
    }
    /**
     * 跳转类，不带参数
     * @author yjbo
     * @time 2017/4/2 11:02
     */
    public static void skipActOnly(Context mcontext, Class<?> cls) {
        skipAct(mcontext, cls,"");
    }
    /**
     * 生产数组
     * @author yjbo  @time 2017/4/6 17:34
     */
    public static ArrayList<Item> getDatas(int count){
        ArrayList<Item> Datas = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            if (i % 2 == 0) {
                Datas.add(new Item(R.mipmap.ic_launcher_round, "我 get 新技能 " + i, 0));
            } else {
                Datas.add(new Item(R.mipmap.ic_launcher_round, "你 get 新技能 " + i, 1));
            }
        }
        return Datas;
    }
}
