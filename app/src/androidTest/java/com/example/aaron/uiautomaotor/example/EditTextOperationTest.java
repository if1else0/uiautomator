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
public class EditTextOperationTest {

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
        //等待搜索控件出现
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/bfu")),
                10000);
        //点击搜索按钮
        UiObject2 searchObj = device.findObject(By.res("com.netease.newsreader.activity:id/bfu"));
        searchObj.click();

        //等待搜索控件出现
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/agm")),
                10000);
        //定位到输入框搜索框
        UiObject2 searchET = device.findObject(By.res("com.netease.newsreader.activity:id/agm"));
        //调用输入的API，输入HelloWorld
        searchET.setText("Hello World");
        //为了可以清楚的看到有成功输入，特意加了延迟
        Thread.sleep(5000);
        searchET.setText("输入中文也一样可以的！");
        Thread.sleep(5000);
        //调用清空的API，清空输入框
        searchET.clear();

    }

    @After
    public void tearDown() throws Exception {

    }


}


