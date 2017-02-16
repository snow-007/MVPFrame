package com.dqm.mvpframe.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:sp缓存工具类
 */
public class PreferenceUtil {

    private static String SP_NAME = "dqm";
    private static SharedPreferences sp;


    private static SharedPreferences getSharedPreferences(final Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static void putString(Context context, String key, String value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }


    public static String getString(Context context, String key, String defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }


    public static void putInt(Context context, String key, int value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        if (sp == null)
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static boolean remove(Context context, String key) {
        SharedPreferences.Editor editor = PreferenceUtil.getSharedPreferences(context).edit();
        editor.remove(key);
        return editor.commit();
    }

}
