package com.lava.seleniumWikiTest;

import com.lava.utils.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

public class SeleniumTestThis extends Base{

    private static SeleniumTestObjectRepo lo;

    public SeleniumTestThis(){
        lo = new SeleniumTestObjectRepo(driver);
    }


     public boolean seleniumtest(){
        scrollToElement(lo.externalLink1);
       sleep(1000);
//        for(int i=0; i<lo.links.size();i++){
//            WebElement element = lo.links.get(i);
//            String urlLink = element.getAttribute("href");
//            verifyLink(urlLink);
//        }

        WebElement element1 = lo.externalLink1;
        String urlLink1 = element1.getAttribute("href");
        verifyLink(urlLink1);
        sleep(1000);
        WebElement element2 = lo.externalLink2;
        String urlLink2 = element2.getAttribute("href");
        verifyLink(urlLink2);
        sleep(1000);
        WebElement element3 = lo.externalLink3;
        String urlLink3 = element3.getAttribute("href");
        verifyLink(urlLink3);
        sleep(1000);
        WebElement element4 = lo.externalLink4;
        String urlLink4 = element4.getAttribute("href");
        verifyLink(urlLink4);
        sleep(1000);
        WebElement element5 = lo.externalLink5;
        String urlLink5 = element5.getAttribute("href");
        verifyLink(urlLink5);
        sleep(1000);
        WebElement element6 = lo.externalLink6;
        String urlLink6 = element6.getAttribute("href");
        verifyLink(urlLink6);

        return true;
    }


    public void verifyLink(String urlLink) {
        try{
            URL link = new URL(urlLink);
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            if(httpConn.getResponseCode()== 200) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(httpConn.getResponseCode()== 404) {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server.
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean oxygen(){
        scrollToElement(lo.oxygen);
        lo.oxygen.click();
        return true;
    }

    public boolean verifyOxygenFeaturedArticle(){

        if(isElementVisible(lo.oxygenPageHeading)==false){
            waitUntilElementIsVisible(lo.oxygenPageHeading);
        }
        //verify heading of the page
        if(lo.oxygenPageHeading.getText().equalsIgnoreCase("Oxygen")){
            return true;
        }
        return false;
    }

   public boolean getScreenshotofOxygenProperties(){
        scrollToElement(lo.oxygenPhysicalProperties);
       File src1= driver.getScreenshotAs(OutputType.FILE);
       try {
           // now copy the  screenshot to desired location using copyFile //method
           FileUtils.copyFile(src1, new File("/Users/ashwi/Desktop/lava_webautomation1/src/main/resources/oxygenPhysicalProperties.png"));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

       scrollToElement(lo.oxygenAtomicProperties);
       File src2= driver.getScreenshotAs(OutputType.FILE);
       try {
           // now copy the  screenshot to desired location using copyFile //method
           FileUtils.copyFile(src2, new File("/Users/ashwi/Desktop/lava_webautomation1/src/main/resources/oxygenAtomicProperties.png"));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

       scrollToElement(lo.oxygenOtherProperties);
       File src3= driver.getScreenshotAs(OutputType.FILE);
       try {
           // now copy the  screenshot to desired location using copyFile //method
           FileUtils.copyFile(src3, new File("/Users/ashwi/Desktop/lava_webautomation1/src/main/resources/oxygenOtherProperties.png"));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

       return true;
   }

    public boolean citationPDFcount(){
        scrollToElement(lo.reference);
        int count = lo.citationCount.size();
        System.out.println("PDF count "+count);
        return true;
    }

    public boolean searchWiki(String suggestion2){
        scrollToElement(lo.searchWiki);
        sleep(1000);
        lo.searchWiki.sendKeys("pluto");
        isElementVisible(lo.secondSuggestion);
        String plutonium = lo.secondSuggestion.getText();
        System.out.println("Suggestion in second position "+plutonium);
        if(plutonium.equalsIgnoreCase(suggestion2)) {
            return true;
        }
        return false;
    }



}
