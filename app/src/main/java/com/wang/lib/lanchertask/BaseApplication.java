package com.wang.lib.lanchertask;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.wang.lib.launchertask.TaskDispatcher;
import com.wang.lib.launchertask.utils.DispatcherLog;


public class BaseApplication extends Application {

    private static BaseApplication sInstance;
    /**
     * 初始化调度器
     */
    protected TaskDispatcher mDispatcher = null;
    long time;

    public static BaseApplication getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("Application has not been created");
        }
        return sInstance;
    }

    public static Context getContext() {
        return sInstance != null ? sInstance.getApplicationContext() : null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (sInstance == null) {
            sInstance = this;
        }
        //------------初始化任务启动器-----start-------
        time = System.currentTimeMillis();
        TaskDispatcher.init(this);
        mDispatcher = TaskDispatcher.createInstance();
        DispatcherLog.setDebug(true);
        init();
        Log.w("launcherTask", "---start---");
        mDispatcher.start();
        Log.w("launcherTask", "---end---");
        mDispatcher.await();//异步线程执行的Task是否需要在被调用await的时候等待，默认不需要
        Log.w("launcherTask", "--await-end---");
        Log.w("launcherTask", "--time--" + (System.currentTimeMillis() - time));

        //------------初始化任务启动，并且等待初始化任务的完成----end--------

    }

    protected void init() {
        mDispatcher.addTask(new InitDatabaseManager())
                .addTask(new MainManager())
                .addTask(new NetManager())
                .addTask(new FileManager())
        ;
    }

}