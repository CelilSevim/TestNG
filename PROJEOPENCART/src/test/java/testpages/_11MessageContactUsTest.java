package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _11MessageContactUsTest {
    PageClass pageClass= new PageClass();
    @Test
    public void messageContactUsTest(){
        pageClass.login();
        pageClass.messaageContactUs();
    }
    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }

}
