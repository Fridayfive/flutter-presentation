# presentation

一个支持 Android端的双屏插件，开发者在双屏场景中使用flutter开发双屏的UI

## 功能列表

支持屏幕信息获取、副屏视图嵌入、主屏副屏切换、主屏副屏的通信

### 安装

---

添加依赖 pubspec.yaml

```
dependencies:
  presentation: "^1.0.0"
```

### 使用

---

`import 'package:presentation/presentation.dart';`

初始化：在项目的入口widget或者在main中进行初始化

```
    Presentation presentation = Presentation.getInstance();
    presentation.init();
```

注：init方法只需要调用一次即可

获取屏幕信息

```
Map<String, dynamic> res = await presentation.getDisNum();
```

设置屏幕画面:传入第一个参数为设置屏幕的id，第二个参数为flutter端显示页面的路由，成功返回true失败返回false

```
bool  res = await presentation.setContentView(1, "TestPage");
```

关闭双屏显示

```
presentation.close()
```

屏幕间消息通信

1. 注册通信method监听消息

```
//在wideget init生命周期中注册一个streamCotroller用于在native返回数据后监听返回的数据，第一个注册的是stream唯一method id，在接收到native数据后会根据methodId返回给相应注册的页面
//第一个页面
 @override
  void initState() {
    // TODO: implement initState
    presentation = Presentation.getInstance();
    presentation.registerListener("page1", streamController);
    streamController.stream.listen((event) {
    });
    super.initState();
  }
//第二个页面
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


```

2. 通过method发布消息

```
presentation.subscribeMsg("page2", {"value": "test"})
```
