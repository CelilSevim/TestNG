package testpages;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _08SearchProduct {
    PageClass pageClass = new PageClass();

    @Test
    public void searchproductTest() {
        pageClass.login();
        pageClass.searchProduct();
    }
    @Test
    public void offSearchproductTest() {
        pageClass.searchProduct();
    }

    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}

