package com.friday.presentation.utils;

import io.flutter.plugin.common.EventChannel;

public class EventHandler implements EventChannel.StreamHandler {

    private static EventHandler instance;
    private EventChannel.EventSink mEventSink;

    public static EventHandler getInstance() {
        if (instance == null) {
            synchronized (EventHandler.class) {
                if (instance == null) {
                    instance = new EventHandler();
                }
            }
        }
        return instance;
    }

    private EventHandler() {
    }

    public void response(Object o) {
        this.mEventSink.success(o);
    }

    @Override
    public void onListen(Object o, EventChannel.EventSink eventSink) {
        this.mEventSink = eventSink;
    }


    @Override
    public void onCancel(Object o) {
    }
}
