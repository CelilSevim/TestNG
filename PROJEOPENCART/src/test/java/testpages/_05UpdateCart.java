package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _05UpdateCart {
    PageClass pageClass=new PageClass();
    @Test
    public void updateProductCart() {
        pageClass.login();
        pageClass.updateCartProduct();
    }
    @Test
    public void offUpdateProductCart() {
        pageClass.updateCartProduct();
    }
    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
