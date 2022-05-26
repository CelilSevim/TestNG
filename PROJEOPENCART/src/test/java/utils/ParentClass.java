package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.time.Duration;
import java.util.List;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void clickTo(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickTo(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void hover(WebElement element){
        hover(element,10);
    }
    public void hover(WebElement element,long milis){
        new Actions(driver).moveToElement(element).pause(milis).build().perform();
    }
    public void scrool(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrool(By element){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void selectOption(WebElement element,String value){
        Select select= new Select(element);
        select.selectByValue(value);

    }
    public void selectOption(WebElement element,int index){
        Select select= new Select(element);
        select.selectByIndex(index);

    }
    public void waitFor(WaitConditions condition,By locator) {
        switch (condition) {
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            case visiable:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }
    public void hover(List<WebElement> element, long milis){
        for (WebElement e:element) {
            hover(e,milis);
        }
    }

    @AfterClass
    public void afterSuite()  {

        Driver.quitDriver();
    }
}
