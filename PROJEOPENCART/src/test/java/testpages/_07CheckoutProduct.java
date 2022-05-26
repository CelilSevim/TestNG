package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _07CheckoutProduct {
    PageClass pageClass= new PageClass();
    @Test
    public void checkProduct() throws InterruptedException {
        pageClass.productCheckOut();
    }
    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
