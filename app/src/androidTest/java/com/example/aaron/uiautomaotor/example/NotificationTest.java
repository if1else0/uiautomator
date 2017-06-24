package com.example.aaron.uiautomaotor.example;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class NotificationTest {

    private UiDevice device;
    //设置网易新闻的包名
    private static final String PACKAGE_NAME = "com.netease.newsreader.activity";

    @Before
    public void setUp() throws Exception {
        // 实例化UiDevice
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // 启动应用
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        // 等待应用启动
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/bfw")),
                10000);
    }

    @Test
    public void name() throws Exception {
        //打开通知栏
        device.openNotification();
        //等待通知栏出现
        device.wait(Until.hasObject(By.res("android:id/icon")),
                10000);
        //通过uiautomatorviewer定位到通知栏的图标的id
        device.findObject(By.res("android:id/icon")).click();
        Thread.sleep(3000);

    }

    @After
    public void tearDown() throws Exception {

    }


}


