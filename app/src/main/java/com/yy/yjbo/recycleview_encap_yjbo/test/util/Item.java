package com.yy.yjbo.recycleview_encap_yjbo.test.util;

/**
 * Created by admin on 2017/4/1.
 */

public class Item {
    private int res;
    private String tv1;
    private String tv2;


    public Item(int res, String tv1, String tv2) {
        this.res = res;
        this.tv1 = tv1;
        this.tv2 = tv2;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

}
