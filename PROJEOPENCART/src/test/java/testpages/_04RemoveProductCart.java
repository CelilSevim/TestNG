package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _04RemoveProductCart {

    PageClass pageClass=new PageClass();
    @Test
    public void removeProductInCart() throws InterruptedException {
        pageClass.login();
        pageClass.removeProductCart();
    }
    @Test(priority = 1)
    public void offRemoveProductInCart() throws InterruptedException {
        pageClass.removeProductCart();
    }


    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
