package com.lava.seleniumWikiTest;

import com.lava.utils.ObjectsBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeleniumTestObjectRepo extends ObjectsBase {

    public SeleniumTestObjectRepo(RemoteWebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//ul//li//a[@href=\"http://www.periodicvideos.com/videos/034.htm\"]")
    protected static WebElement externalLink1;
    @FindBy(xpath = "//ul//li//a[@href=\"http://ods.od.nih.gov/factsheets/selenium.asp\"]")
    protected static WebElement externalLink2;
    @FindBy(xpath = "//ul//li//a[@href=\"http://www.sas-centre.org/assays/trace_metals/selenium.html\"]")
    protected static WebElement externalLink3;
    @FindBy(xpath = "//ul//li//a[@href=\"http://www.atsdr.cdc.gov/toxprofiles/tp92.html\"]")
    protected static WebElement externalLink4;
    @FindBy(xpath = "//ul//li//a[@href=\"https://www.cdc.gov/niosh/npg/npgd0550.html\"]")
    protected static WebElement externalLink5;
    @FindBy(xpath = "//ul//li//a[@href=\"http://elements.vanderkrogt.net/element.php?sym=Se\"]")
    protected static WebElement externalLink6;

    @FindBy(xpath = "(//div[contains(@class,\"mf-section-10\")]//ul)[2]//li")
    protected static List<WebElement> links;

    @FindBy(xpath = "//div[@class=\"navbox\"]//td[@title=\"Oxygen, 8 (reactive nonmetal)\"]")
    protected static WebElement oxygen;
    @FindBy(xpath = "//h1[@id=\"firstHeading\"]")
    protected static WebElement oxygenPageHeading;

    @FindBy(xpath = "//th[contains(text(),'Physical properties')]")
    protected static WebElement oxygenPhysicalProperties;

    @FindBy(xpath = "//th[contains(text(),'Atomic properties')]")
    protected static WebElement oxygenAtomicProperties;

    @FindBy(xpath = "//th[contains(text(),'Other properties')]")
    protected static WebElement oxygenOtherProperties;

    @FindBy(xpath = "//input[@id='searchInput']")
    protected static WebElement searchWiki;
    @FindBy(xpath = "(//div[@class=\"suggestions-result\"])[2]")
    protected static WebElement secondSuggestion;
    @FindBy(xpath = "//span[@id='References']")
    protected static WebElement reference;
    @FindBy(xpath = "//span[@class=\"cs1-format\"]")
    protected static List<WebElement> citationCount;




}
