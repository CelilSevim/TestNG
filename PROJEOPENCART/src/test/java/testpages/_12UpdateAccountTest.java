package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _12UpdateAccountTest {
    PageClass pageClass=new PageClass();
    @Test
    public void updateAccountTest(){
        pageClass.login();
        pageClass.updateAccount();
    }


    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}

