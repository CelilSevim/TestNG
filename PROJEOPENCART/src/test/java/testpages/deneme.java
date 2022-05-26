package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class deneme {
    PageClass pageClass = new PageClass();

    @Test
    public void removeProduct() throws InterruptedException {

    }

    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}
