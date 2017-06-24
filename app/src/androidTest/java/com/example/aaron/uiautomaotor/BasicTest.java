package com.example.aaron.uiautomaotor;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.widget.ImageView;

import com.example.aaron.uiautomaotor.utils.Finder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by aaronyang on 6/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class BasicTest {

    private UiDevice device;
    //设置网易新闻的包名
    private static  final String PACKAGE_NAME = "com.netease.newsreader.activity";
    private Finder finder;
    public PageHelper helper;


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
        //初始化Finder
        finder = new Finder(device);
        helper = new PageHelper(finder);
    }


    @After
    public void tearDown() throws Exception {

    }


}


