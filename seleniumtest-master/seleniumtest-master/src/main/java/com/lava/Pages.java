package com.lava;
import com.lava.seleniumWikiTest.SeleniumTestThis;
import com.lava.utils.Base;



public class Pages {

    private static <T extends Base> T getPage(Class<T> pageType)  {
        T page;
        try {
            page = pageType.newInstance();
        } catch (InstantiationException e) { //make sure you use JDK 1.7
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return page;
    }

    public static SeleniumTestThis LoginPage(){return getPage(SeleniumTestThis.class);}


}
