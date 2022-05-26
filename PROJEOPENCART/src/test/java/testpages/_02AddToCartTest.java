package testpages;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _02AddToCartTest {
    PageClass pageClass= new PageClass();
    @Test
    public void loginAddToCart() throws InterruptedException {
        pageClass.login();
        pageClass.addToCart();
    }
    @Test
    public void offAddToCart() throws InterruptedException {
        pageClass.addToCart();
    }

    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
