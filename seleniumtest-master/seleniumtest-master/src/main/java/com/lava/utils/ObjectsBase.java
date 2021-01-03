package com.lava.utils;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class ObjectsBase {

    public ObjectsBase(RemoteWebDriver driver){
        PageFactory.initElements(driver, this );
    }

}
