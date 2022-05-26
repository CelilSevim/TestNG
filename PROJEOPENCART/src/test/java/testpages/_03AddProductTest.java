package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _03AddProductTest {
    PageClass pageClass = new PageClass();

    @Test
    public void addProductTest() throws InterruptedException {
        pageClass.addProduct();
    }
    @Test(priority = 2)
    public void offAddProductTest() throws InterruptedException {
        pageClass.login();
        pageClass.addProduct();
    }

    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
