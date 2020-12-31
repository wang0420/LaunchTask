package com.wang.lib.lanchertask;

import android.os.Handler;
import android.util.Log;

import com.wang.lib.launchertask.task.Task;


/**
 * @author wangwei
 * @date 2020/12/31.
 */
public class InitDatabaseManager extends Task {


    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //初始化的任务放在主线程，默认在子线程里面异步
    @Override
    public boolean runOnMainThread() {
        return true;
    }


}
