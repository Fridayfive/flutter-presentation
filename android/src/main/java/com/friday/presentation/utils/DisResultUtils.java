package com.friday.presentation.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.Display;

import java.util.HashMap;

public class DisResultUtils {

    private final int flags;
    private final String name;
    private final Display.Mode mode;
    private final int rotation;
    private final int state;
    private int screenId;

    private Long AppVsyncOffsetNanos;

    @TargetApi(Build.VERSION_CODES.M)
    public DisResultUtils(Display display) {
        this.screenId = display.getDisplayId();
        this.AppVsyncOffsetNanos = display.getAppVsyncOffsetNanos();
        this.flags = display.getFlags();
        name = display.getName();
        mode = display.getMode();
        state = display.getState();
        rotation = display.getRotation();
    }

    @Override
    public String toString() {
        return "{" +
                "flags:" + flags +
                ", name:'" + name + '\'' +
                ", mode:" + mode +
                ", rotation:" + rotation +
                ", state:" + state +
                ", screenId:" + screenId +
                ", AppVsyncOffsetNanos:" + AppVsyncOffsetNanos +
                '}';
    }
}
