package testpages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _09SortProductTest {
    PageClass pageClass=new PageClass();
    @Test
    public void sortProductTestA_Z(){
        pageClass.sortByProductNameA_Z();
    }
    @Test(priority = 1)
    public void sortProductTestZ_A(){
        pageClass.sortByProductNameZ_A();
    }
    @Test(priority = 2)
    public void sortProductTestL_H(){
        pageClass.sortByProductNameL_H();
    }
    @Test(priority = 3)
    public void sortProductTestH_L(){
        pageClass.sortByProductNameH_L();
    }


    @AfterClass
    public void afterClass(){
        pageClass.quit();
    }
}

