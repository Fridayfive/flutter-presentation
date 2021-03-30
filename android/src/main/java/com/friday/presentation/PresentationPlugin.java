package com.friday.presentation;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.View;

import com.friday.presentation.presenDisplay.DifferentDislay;
import com.friday.presentation.presenDisplay.ScreenManager;
import com.friday.presentation.utils.DisResultUtils;
import com.friday.presentation.utils.EventHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * PresentationPlugin
 */
public class PresentationPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;
    private Context mContext;
    private ScreenManager screenManager;
    private static String EventChannel = "presentationEventChannel";
    private io.flutter.plugin.common.EventChannel eventChannel;
    private EventHandler mEventHandler;

    @Override
    public void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "presentation");
        eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), EventChannel);
        mEventHandler = EventHandler.getInstance();
        eventChannel.setStreamHandler(mEventHandler);
        channel.setMethodCallHandler(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onMethodCall(MethodCall call, Result result) {
        switch (call.method) {
            case "init":
                screenManager = ScreenManager.init(mContext);
                result.success(0);
                break;
            case "getDisNum":
                Display[] displays = screenManager.getDisNum();
                Map<String, Object> res = new HashMap<>();
                for (int i = 0; i < displays.length; i++) {
                    Map<String, Object> dis = new HashMap<>();
                    dis.put("disName", displays[i].getName());
                    dis.put("disId", displays[i].getDisplayId());
                    dis.put("disRataion", displays[i].getRotation());
                    dis.put("disState", displays[i].getState());
                    dis.put("disMode", displays[i].getMode().toString());
                    res.put("dis" + i, dis);
                }
                result.success(res);
                break;
            case "setContentView":
                int index = call.argument("index");
                final String rout = call.argument("rout");
                try {
                    screenManager.setContentView(new DifferentDislay(mContext, screenManager.getDisNum()[index]) {
                        @Override
                        protected View getLayoutView() {
                            return null;
                        }

                        @Override
                        protected String viewRout() {
                            return rout;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result.success(screenManager.isShowing());
                break;
            case "close":
                screenManager.close();
                break;
            case "subscribeMsg":
                mEventHandler.response(call.arguments);
                break;
        }
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }

    @Override
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        mContext = activityPluginBinding.getActivity();
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {

    }

    @Override
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {

    }

    @Override
    public void onDetachedFromActivity() {

    }
}
