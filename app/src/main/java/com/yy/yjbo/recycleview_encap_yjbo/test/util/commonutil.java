package com.yy.yjbo.recycleview_encap_yjbo.test.util;

import android.content.Context;
import android.content.Intent;

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
}
