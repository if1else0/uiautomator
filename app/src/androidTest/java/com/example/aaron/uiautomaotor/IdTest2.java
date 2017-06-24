package com.example.aaron.uiautomaotor;

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
 * Created by Aaron on 2017/6/1.
 */

public class IdTest2 extends BasicTest{



    @Test
    public void name() throws Exception {
        helper.getPageCommon().clickMyTab();
    }



}
