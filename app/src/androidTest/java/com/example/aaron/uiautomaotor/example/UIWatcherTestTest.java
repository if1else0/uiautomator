package com.example.aaron.uiautomaotor.example;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class UIWatcherTestTest {

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
        //注册uiwatcher
        device.registerWatcher("myWatcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                //allow button
                UiObject2 allow =  device.findObject(By.res("android:id/button1"));
                //判断如果允许的按钮存在就点击掉
                if(allow != null){
                    allow.click();
                    return true;
                }
                return false;
            }
        });
    }

    @Test
    public void name() throws Exception {
        device.wait(Until.hasObject(By.res("com.netease.newsreader.activity:id/bfu")),
                6000);
        //首次启动因为会弹出权限确认弹框，因此搜索按钮会找不到，会触发uiwatcher
        UiObject2 search = device.findObject(By.res("com.netease.newsreader.activity:id/bfu"));
        search.click();

    }

    @After
    public void tearDown() throws Exception {

    }


}


