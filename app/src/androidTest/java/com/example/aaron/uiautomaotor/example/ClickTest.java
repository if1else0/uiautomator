package com.example.aaron.uiautomaotor.example;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.widget.ImageView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class ClickTest {

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
        //等待直播控件出现
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/zp")),
                10000);

        //通过id定位到直播控件
        UiObject2 liveObj = device.findObject(By.res("com.netease.newsreader.activity:id/zp"));
        //调用点击的API
        liveObj.click();
    }

    @After
    public void tearDown() throws Exception {

    }


}


