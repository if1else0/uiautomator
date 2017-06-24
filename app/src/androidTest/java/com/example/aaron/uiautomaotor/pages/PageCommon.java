package com.example.aaron.uiautomaotor.pages;

import android.graphics.pdf.PdfDocument;
import android.support.test.uiautomator.UiObject2;

import com.example.aaron.uiautomaotor.utils.Finder;

/**
 * Created by aaronyang on 6/25/17.
 */

public class PageCommon {

    Finder finder;

    public PageCommon(Finder finder){
        this.finder = finder;
    }

    public void clickNewsTab(){
        getNewsTab().click();
    }

    public void clickMyTab(){
        getMyTab().click();
    }

    public UiObject2 getNewsTab(){
        return finder.findById("com.netease.newsreader.activity:id/a03",0);
    }

    public UiObject2 getMyTab(){
        return finder.findById("com.netease.newsreader.activity:id/a03",4);
    }

}
