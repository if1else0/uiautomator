package com.example.aaron.uiautomaotor1;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Aaron on 2017/5/30.
 */
@RunWith(AndroidJUnit4.class)
public class HelloWorld {
    private UiDevice device;
    private static  final String PACKAGE_NAME = "com.android.calculator2";

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
        //点击数字1
        device.findObject(By.res("com.android.calculator2:id/digit_1")).click();
        //点击数字0
        device.findObject(By.res("com.android.calculator2:id/digit_0")).click();
        //点击乘号
        device.findObject(By.res("com.android.calculator2:id/op_mul")).click();
        //点击数字1
        device.findObject(By.res("com.android.calculator2:id/digit_1")).click();
        //点击数字2
        device.findObject(By.res("com.android.calculator2:id/digit_2")).click();
        //点击等号
        device.findObject(By.res("com.android.calculator2:id/eq")).click();
        //获取运行结果
        String result = device.findObject(By.res("com.android.calculator2:id/result")).getText();
        assertEquals("120",result);
    }

    @After
    public void tearDown() throws Exception {

    }
}


