package com.example.aaron.uiautomaotor.example;

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

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class OpenRecentAppTest {

    private UiDevice device;

    @Before
    public void setUp() throws Exception {
        // 实例化UiDevice
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void name() throws Exception {

        //打开最近访问的APP列表
        device.pressRecentApps();
        //等待最近访问APP列表出现
        device.wait(Until.hasObject(By.res("com.android.systemui:id/recent_item")),
                10000);
        //通过uiautomatorviewr选择定位方式定位到ES浏览器
        device.findObjects(By.res("com.android.systemui:id/recent_item")).get(1).click();

    }

    @After
    public void tearDown() throws Exception {

    }


}





//         device.pressEnter();
//
//         device.pressMenu();
//
//         device.pressSearch();
//
//         device.pressDelete();
