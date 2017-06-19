package com.example.aaron.uiautomaotor1;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Aaron on 2017/6/1.
 */

@RunWith(AndroidJUnit4.class)
public class IdTest {

    private UiDevice device;
    //设置网易新闻的包名
    private static  final String PACKAGE_NAME = "com.netease.newsreader.activity";

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
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)),
                10000);
    }

    @Test
    public void name() throws Exception {
//        //设置选择器
//        BySelector selector = By.res("com.netease.newsreader.activity:id/bg5");
//        //通过选择器定位控件
//        UiObject2 object2 = device.findObject(selector);
//        object2.click();
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/bg5")),5000);
        device.findObject(By.res("com.netease.newsreader.activity:id/bg5")).click();
    }

    @After
    public void tearDown() throws Exception {

    }


}
