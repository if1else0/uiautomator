package com.example.aaron.uiautomaotor.utils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.view.KeyEvent;

import java.util.regex.Pattern;

/**
 * Created by aaronyang on 6/24/17.
 */

public class Finder {
    private UiDevice device;
    //默认超时时间
    private static final int DEFAULT_TIMEOUT = 5000;

    public Finder(UiDevice device) {
        this.device = device;
    }

    //为啥不用静态的方法
    //封装按Resource Id定位的方法
    public UiObject2 findById(String resourceId) {
        //添加等待
        device.wait(Until.hasObject(By.res(resourceId)), DEFAULT_TIMEOUT);
        return device.findObject(By.res(resourceId));
    }

    //封装相同id定位的方法，指定id和index
    public UiObject2 findById(String resourceId, int index) {
        //添加等待
        device.wait(Until.hasObject(By.res(resourceId)), DEFAULT_TIMEOUT);
        return device.findObjects(By.res(resourceId)).get(index);
    }

    //封装按文本定位的方法
    public UiObject2 findByText(String text) {
        //添加等待
        device.wait(Until.hasObject(By.text(text)),DEFAULT_TIMEOUT);
        return device.findObject(By.text(text));
    }

    public UiObject2 findByTextPattern(String pattern){
        device.wait(Until.hasObject(By.text(Pattern.compile(pattern))),DEFAULT_TIMEOUT);
        return device.findObject(By.text(Pattern.compile(pattern)));
    }

    //封装按Content Description定位的方法
    public UiObject2 findByContentDesc(String contentDesc) {
        //添加等待
        device.wait(Until.hasObject(By.desc(contentDesc)),DEFAULT_TIMEOUT);
        return device.findObject(By.desc(contentDesc));
    }



}
