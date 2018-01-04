package com.dqm.mvpframe.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * toast显示
 */

public class TipUtils {

    private static Toast mToast;

    /**
     * 非阻塞试显示Toast,防止出现连续点击Toast时的显示问题
     */
    public static void toast(Context context, String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(Context context, String text) {
        toast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToastLong(Context context, String text) {
        toast(context, text, Toast.LENGTH_LONG);
    }

}
