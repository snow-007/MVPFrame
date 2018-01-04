package com.dqm.mvpframe.widget;

import android.app.Dialog;
import android.content.Context;

import com.dqm.mvpframe.R;

/**
 * Created by Administrator on 2017/11/15.
 */

public class LoadingDialog extends Dialog {
    private LoadingDialog dialog = null;

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    public LoadingDialog(Context context) {
        super(context);
        dialog = new LoadingDialog(context, R.style.dialog_custom);
        dialog.setContentView(R.layout.progressbar_loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void stopProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}