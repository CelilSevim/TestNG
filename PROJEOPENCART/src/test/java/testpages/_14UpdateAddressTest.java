package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _14UpdateAddressTest {
    PageClass pageClass= new PageClass();
    @Test
    public void updateToAddress()  {
        pageClass.login();
        pageClass.updateAdress();
    }
    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}
