package com.friday.presentation.presenDisplay;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.widget.Toast;


public class ScreenManager {

    private static DisplayManager displayManager;
    private DifferentDislay differentDislay;

    public Display[] getDisNum() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            disNum = displayManager.getDisplays(null);
        }
        return disNum;
    }

    private static Display[] disNum;
    private static Context mContext;
    private int type;
    private static ScreenManager instance;

    private ScreenManager() {
    }


    public static ScreenManager init(Context context) {
        if (instance == null) {
            synchronized (ScreenManager.class) {
                if (instance == null) {
                    instance = new ScreenManager();
                    mContext = context;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        displayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
                        disNum = displayManager.getDisplays(null);
                    } else {
                        Toast.makeText(context, "您的Android版本不支持双屏功能", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        return instance;
    }


    public void setContentView(DifferentDislay differentDislay) {
        this.differentDislay = differentDislay;
        this.differentDislay.show();
    }

    public boolean isShowing() {
        if (this.differentDislay != null)
            return this.differentDislay.isShowing();
        else
            return false;
    }

    public void close() {
        if (this.differentDislay != null && this.differentDislay.isShowing()) {
            this.differentDislay.cancel();
            this.differentDislay.dismiss();
        } else {
            Toast.makeText(mContext, "副屏未设置视图", Toast.LENGTH_SHORT).show();
        }
    }


    public void destroy() {
        this.differentDislay = null;
        displayManager = null;
    }
}
