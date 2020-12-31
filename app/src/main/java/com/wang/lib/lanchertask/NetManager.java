package com.wang.lib.lanchertask;

import android.util.Log;

import com.wang.lib.launchertask.task.Task;


/**
 * @author wangwei
 * @date 2020/12/31.
 */
public class NetManager extends Task {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  Log.w("TAG", "--在子线程初始化，但是需要主线程等待-NetManager---" + Thread.currentThread().getName());
    }

    //当前任务是在子线程里面初始化的  但是这个需要主线程等待
    @Override
    public boolean needWait() {
        return true;
    }

}
