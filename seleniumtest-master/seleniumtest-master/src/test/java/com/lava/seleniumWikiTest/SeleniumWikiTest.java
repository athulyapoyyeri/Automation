package com.lava.seleniumWikiTest;
import com.lava.Pages;
import com.lava.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;


public class SeleniumWikiTest extends TestBase {

    @Title("Verify Selenium page")
    @TestCaseId("TMS-1")

    @Test(priority =1)
    public void wikiSeleniumPage(){

        Assert.assertTrue(Pages.LoginPage().seleniumtest(),"Failed to Login");
    }
    @Test(priority =2)
    public void oxygenClick(){
        Assert.assertTrue(Pages.LoginPage().oxygen(),"Failed to click oxygen in periodic table");
    }

    @Test(priority =3)
    public void OxygenFeaturedArticle(){
        Assert.assertTrue(Pages.LoginPage().verifyOxygenFeaturedArticle(),"Failed to click oxygen in periodic table");
    }
     @Test(priority =4)
    public void screenshotTest(){
        Assert.assertTrue(Pages.LoginPage().getScreenshotofOxygenProperties(),"Failed to click oxygen in periodic table");
    }

    @Test(priority =5)
    public void pdfCountInCitation(){
        Assert.assertTrue(Pages.LoginPage().citationPDFcount(),"Failed to click oxygen in periodic table");
    }

     @Test(priority =6)
    public void plutoniumSearch(){
        String suggestion = "Plutonium";
        Assert.assertTrue(Pages.LoginPage().searchWiki(suggestion),"Failed to click oxygen in periodic table");
    }




}
