package com.example.demo.common.enu;

/**
 * Created by yexin on 2017/9/1.
 */
public enum OptSet {

    UPDATE(1),
    DELETE(2),
    INSERT(3),
    QUERY(0);

    private int opt;

    private OptSet( int opt) {
        this.opt = opt;
    }


}
