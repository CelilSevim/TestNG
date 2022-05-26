package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _10FavoriteProductTest {
    PageClass pageClass= new PageClass();
    @Test
    public void favoriteProduct(){
        pageClass.login();
        pageClass.favoriteProduct();
    }
    @AfterClass
    public void afterClass() {
        pageClass.quit();
    }
}
