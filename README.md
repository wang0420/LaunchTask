# LaunchTask  
一个启动初始化的库

#上传JCenter 步骤
1、修改 local.properties  用户名称及key
2、我们开源库中的 upload_bintray.gradle 文件中引入 bintary.gradle ，注意引入的命令需要写在最后一行，不然会报错。
3、修改上述文件#号注释的地方
4、执行 gradlew install
5、执行 gradle bintrayUpload
6、如果是第一次上传  需要发布到 JCenter  ，Add to JCenter 的提示，点击提交 commit 就可以啦


参考文章
https://www.jianshu.com/p/152d88245b60

简单来说就是把初始化任务一个个都封装成Task（单一职责），
可以设置Task的执行线程、它需要依赖的其他task、是否需要主线程等待，
最后将配置好的线程排序，按顺序分线程执行。

初始化顺序   主线程>需要主线程等待(needWait) > 异步线程
```
implementation 'com.github.wang:launchTask:1.1.0'
```

      

