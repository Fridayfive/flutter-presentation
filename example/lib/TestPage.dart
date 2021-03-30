import 'dart:async';
import 'package:flutter/material.dart';
import 'package:presentation/presentation.dart';

class TestPage extends StatefulWidget {
  @override
  _TestPageState createState() => _TestPageState();
}

class _TestPageState extends State<TestPage> {
  Presentation presentation;
  String screeInfo = "";
  StreamController<dynamic> streamController = new StreamController<dynamic>();

  @override
  void initState() {
    // TODO: implement initState
    presentation = Presentation.getInstance();
    presentation.init();
    presentation.registerListener("page2", streamController);
    streamController.stream.listen((event) {
    });
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Text("这是测试页面"),
      ),
    );
  }
}
