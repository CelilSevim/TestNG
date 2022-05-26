package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _13AddToAddress {
    PageClass pageClass= new PageClass();
    @Test
    public void addToAddress() throws InterruptedException {
        pageClass.login();
        pageClass.addToAddress();
    }
    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}
