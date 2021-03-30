import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:presentation/presentation.dart';

import 'TestPage.dart';

void main() {
  runApp(MyApp());
  Presentation presentation = Presentation.getInstance();
  presentation.init();
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: <String, WidgetBuilder>{
        "index": (BuildContext context) => MainPage(),
        "TestPage": (BuildContext context) => TestPage(),
      },
      initialRoute: "index",
    );
  }
}

class MainPage extends StatefulWidget {
  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  Presentation presentation;
  String screeInfo = "";
  bool res = false;
  StreamController<dynamic> streamController = new StreamController<dynamic>();

  @override
  void initState() {
    // TODO: implement initState
    presentation = Presentation.getInstance();
    presentation.registerListener("page1", streamController);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Plugin example app'),
      ),
      body: Center(
          child: Column(
        children: [
          Row(
            children: [
              TextButton(
                onPressed: () async {
                  Map<String, dynamic> res = await presentation.getDisNum();
                  setState(() {
                    screeInfo = res.toString();
                  });
                },
                child: Text("获取屏幕信息"),
              ),
              TextButton(
                  style: ButtonStyle(
                      foregroundColor:
                          MaterialStateProperty.resolveWith((states) {
                        return Colors.black;
                      }),
                      backgroundColor: MaterialStateProperty.all(Colors.red)),
                  onPressed: () async {
                    res = await presentation.setContentView(1, "TestPage");
                    setState(() {});
                  },
                  child: Text("设置副屏:" + res.toString())),
              FlatButton(
                  onPressed: () => {presentation.close()}, child: Text("关闭双屏")),
              FlatButton(
                  onPressed: () => {
                        presentation.subscribeMsg("page2", {"value": "test"})
                      },
                  child: Text("发送消息"))
            ],
          ),
          Text(screeInfo)
        ],
      )),
    );
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    streamController.close();
    presentation.dispose();

  }
}
