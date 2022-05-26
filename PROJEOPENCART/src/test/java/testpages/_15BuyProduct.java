package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _15BuyProduct {
    PageClass pageClass= new PageClass();
    @Test
    public void updateToAddress()  {
        pageClass.login();
        pageClass.butTheProduct();
    }
    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}
