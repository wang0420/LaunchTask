# LaunchTask
一个启动初始化的库
gradlew install
gradlew bintrayUpload

简单来说就是把初始化任务一个个都封装成Task（单一职责），
可以设置Task的执行线程、它需要依赖的其他task、是否需要主线程等待，
最后将配置好的线程排序，按顺序分线程执行。

初始化顺序   主线程>需要主线程等待(needWait) > 异步线程
> implementation 'com.github.wang:launchTask:1.1.0'

      

