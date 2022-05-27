package gun8;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Driver;
import utils.ParentClass;
import utils.WaitConditions;

public class DataProvedir2 extends ParentClass {
   By myAccount=By.xpath("//i[@class='fa fa-user']");
   By login=By.cssSelector("div#top-links li.dropdown.open > ul > li:nth-child(2) > a");
   By email=By.cssSelector("input#input-email");
   By pass=By.cssSelector("input#input-password");
   By loginButton=By.cssSelector("div#content form > input");


   @BeforeTest

    public void loginClick(){
      openSite("https://opencart.abstracta.us/");
      clickTo(myAccount);
       clickTo(login);
   }


   @Test(dataProvider = "getData")
    public void test1(String name,String password,int a) throws InterruptedException {
       sendKeys(name,email);
       sendKeys(password,pass);
       clickTo(loginButton);

       if (a==0){
           driver.findElement(By.cssSelector("div#account-login > div.alert.alert-danger.alert-dismissible")).isDisplayed();
           driver.findElement(By.cssSelector("input#input-email")).clear();
           driver.findElement(By.cssSelector("input#input-password")).clear();
       }else{
           waitFor(WaitConditions.exist,By.cssSelector("i.fa.fa-heart"));
       }

   }
   @DataProvider
   public Object[][] getData(){
       Object[][] data={
               {"mvawton1@ebay.co.uk", "P6uQ10x07pbo",0},
               {"ijonuzi2@blogger.com", "ueQsdRg",0},
               {"rhackley3@phpbb.com", "BrQmT8OQy3d8",0},
               {"sbaylis4@admin.ch", "2FrLKz",0},
               {"bdunsford5@gnu.org", "0h0Ej32",0},
               {"dmarven6@accuweather.com", "lLIXdOlqjrR",0},
               {"celilsvmm@gmail.com", "7869572410",1},

       };
       return data;
   }
   @AfterTest
    public void afterTest(){
       driver.quit();
   }




}
