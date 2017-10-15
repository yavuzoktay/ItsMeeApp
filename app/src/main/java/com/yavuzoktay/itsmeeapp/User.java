package com.yavuzoktay.itsmeeapp;

/**
 * Created by Yavuz on 14.10.2017.
 */
public class User {
    private String isim;
    private String soyIsim;

    public User(String isim, String soyIsim) {
        this.isim = isim;
        this.soyIsim = soyIsim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }
}
