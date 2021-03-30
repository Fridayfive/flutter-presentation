/*
 * @Descripttion: 
 * @version: 
 * @Author: 秦城二院吴大夫
 * @Date: 2021-03-29 13:41:56
 * @LastEditors: 秦城二院吴大夫
 * @LastEditTime: 2021-03-30 17:24:48
 */
import 'dart:async';
import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Presentation {
  static Presentation _instance;

  Presentation._internal();

  factory Presentation.instance() => getInstance();

  //flutter端推送到原生消息通道
  static const MethodChannel _channel = const MethodChannel('presentation');

  //原生主动推送消息通道
  static const EventChannel _eventChannel =
      const EventChannel("presentationEventChannel");

  static Stream<dynamic> _streamController =
      new StreamController<dynamic>().stream;

  Map<String, StreamController<dynamic>> _dispatchMap =
      new HashMap<String, StreamController<dynamic>>();

  //单例初始化获取Android端DisplayManager
  static Presentation getInstance() {
    if (_instance == null) {
      _instance = Presentation._internal();
    }
    return _instance;
  }

  init() {
    _channel.invokeMethod("init");
    _eventChannel.receiveBroadcastStream().listen((event) {
      try {
        _dispatchMap[event["method"]].sink.add(event);
      } catch (e) {
        throw new Exception(e);
      }
    });
  }

  Future<Map<String, dynamic>> getDisNum() async {
    var result = await _channel.invokeMethod("getDisNum");
    return Map.from(result);
  }

  Stream<dynamic> get resPonseMessage => _streamController;

  Future<bool> setContentView(int index, String rout) async {
    return await _channel.invokeMethod(
        "setContentView", <String, dynamic>{"index": index, "rout": rout});
  }

  close() {
    _channel.invokeMethod("close");
  }

  void dispose() {
    _dispatchMap.clear();
  }

  void registerListener(String method, StreamController<dynamic> listeners) {
    try {
      if (!_dispatchMap.containsValue(listeners)) {
        _dispatchMap[method] = listeners;
      }
    } catch (e) {
      throw new Exception(e);
    }
  }

  void unregisterListener(String method) {
    if (_dispatchMap.containsKey(method)) {
      _dispatchMap.removeWhere((key, value) => key == method);
    }
  }

  void subscribeMsg(String method, dynamic value) {
    _channel.invokeMethod(
        "subscribeMsg", <String, dynamic>{"method": method, "value": value});
  }
}
