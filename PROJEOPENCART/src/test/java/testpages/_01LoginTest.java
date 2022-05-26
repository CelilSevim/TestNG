package testpages;



import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class _01LoginTest {
    PageClass pageClass=new PageClass();

    @Test(dataProvider = "getData")
    public void login(String email,String pass,int a) {
        pageClass.gotoUrl();
        pageClass.loginWebSite(email,pass,a);

    }
    @Test(priority = 2,dependsOnMethods = "login")
    public void logout(){
        pageClass.gotoUrl();
       pageClass.logout();

    }
    @AfterClass
    public void afterClass(){
        pageClass.quit();
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
}
