package com.example.aaron.uiautomaotor;

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

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class CopyTest {

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
        Thread.sleep(8000);
        BySelector selector1 = By.res("com.netease.newsreader.activity:id/n_");
        //hasChild要一级一级找
        BySelector selector2 = selector1.hasChild(By.clazz("android.widget.LinearLayout"));
        UiObject2 uiObject1 = device.findObject(selector2);
        uiObject1.findObject(By.res("com.netease.newsreader.activity:id/dz")).getText().toString();

        BySelector selector = selector2.hasDescendant(By.res("com.netease.newsreader.activity:id/dz"));
       System.out.println(device.findObject(selector).getText().toString());

    }

    @After
    public void tearDown() throws Exception {

    }


}


