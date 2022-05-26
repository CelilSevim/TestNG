package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _06ProductTolalPriceCheck {
    PageClass pageClass=new PageClass();
    @Test
    public void tProductTolalPriceCheck() throws InterruptedException {
        pageClass.login();
        pageClass.clearPanel();
        pageClass.totalPriceandNameCheck();

    }
    @Test(priority = 1)
    public void offProductTolalPriceCheck() throws InterruptedException {
        pageClass.clearPanel();
        pageClass.totalPriceandNameCheck();
    }
    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
