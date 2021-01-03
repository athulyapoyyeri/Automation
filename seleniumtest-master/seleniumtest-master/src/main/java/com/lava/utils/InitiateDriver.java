package com.lava.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.Platform;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import java.util.HashMap;

public class InitiateDriver {

    private RemoteWebDriver driver;
    private HashMap<String,String> getProperties;

    public InitiateDriver()
    {

        try
        {
            getProperties = PropertyReader.getPropValues("config.properties");
            String runOn = System.getProperty("runOn") == null ? getProperties.get("RUN_ON") : System.getProperty("runOn");
            String platform = System.getProperty("platform") == null ? getProperties.get("PLATFORM") : System.getProperty("platform");
            String url = System.getProperty("url") == null ? getProperties.get("SELENIUMSERVERURL") : System.getProperty("url");
            String browser = null;

            if(platform.equalsIgnoreCase("MAC"))

        {
          if (runOn.equalsIgnoreCase("WEBSITE"))
          {
            browser = System.getProperty("browser") == null ? getProperties.get("BROWSER") : System.getProperty("browser");
            System.out.println(url);

              //For other browsers
              //driver = new RemoteWebDriver(new URL(url), getBrowserCapabilities(browser,runOn));

              DesiredCapabilities capabilities = DesiredCapabilities.chrome();
              driver = new RemoteWebDriver(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          }
        }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver()
    {
        if(driver==null)
            throw new RuntimeException("Driver has not been Instantiated");

        return driver;
    }




    private DesiredCapabilities getBrowserCapabilities(String browser, String runOn)
    {
        DesiredCapabilities capabilities = null;


        try
        {
            if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("Firefox"))
            {
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setPlatform(Platform.ANY);
            }
            else if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("IE"))
            {
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setBrowserName("internet explorer");
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability("ie.ensureCleanSession", true);
            }
            else if (runOn.equalsIgnoreCase("WEBSITE") && browser.equalsIgnoreCase("Chrome"))
            {
                ChromeOptions options = new ChromeOptions();
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setPlatform(Platform.ANY);
            }

            else
            {
                // default is firefox
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.ANY);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return capabilities;
    }
}
