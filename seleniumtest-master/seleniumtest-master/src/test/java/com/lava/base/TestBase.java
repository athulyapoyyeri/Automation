package com.lava.base;
import com.lava.utils.Base;
import com.lava.utils.InitiateDriver;
import com.lava.utils.PropertyReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class TestBase{

protected RemoteWebDriver driver;

    public static HashMap<String,String> configProperties;


    public TestBase() {
        configProperties = PropertyReader.getPropValues("config.properties");
    }

    @BeforeSuite(alwaysRun=true)
    public void setup()
    {
        String url = configProperties.get("URL");
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        Base.driver = driver;
        System.out.println(url);
        driver.get(url);
    }


}
