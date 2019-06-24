package com.bawei.shopmall;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Author:程金柱
 * Date:2019/6/20 20:54
 * Description：
 */

public class App extends Application {

    private static SharedPreferences shop;

    public static SharedPreferences getShop() {
        return shop;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        shop = getSharedPreferences("shop", MODE_PRIVATE);

    }
}
