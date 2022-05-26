package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.LocatorsSite;
import utils.ParentClass;
import utils.WaitConditions;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static utils.LocatorsSite.*;

public class PageClass extends ParentClass {
    List<WebElement> products;
    List<WebElement> products2;


    public void gotoUrl() {
        openSite(url);
    }

    public void login() {
        gotoUrl();
        clickTo(myAccountButton);
        clickTo(loginButton);
        sendKeys(email, myEmail);
        sendKeys(password, myPassword);
        clickTo(submitButton);


    }

    public void logout() {

        clickTo(myAccountButton);
        clickTo(logoutButton);
        clickTo(logoutCountinueButton);
        List<WebElement> myAccounInner = driver.findElements(userAccountInner);
        Assert.assertTrue(myAccounInner.size() <= 2);
    }


    public void addToCart() throws InterruptedException {

        clickTo(lHomePage);
        sendKeys(lSearch, "mac" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        for (WebElement product : products) {
            System.out.println(product.getText());
        }
        int rUrun = new Random().nextInt(products.size());
        String myUrun = products.get(rUrun).getText();
        System.out.println(myUrun);
        products.get(rUrun).click();
        clickTo(addToCartButton);
        clickTo(lCart);
        Thread.sleep(2000);
        WebElement cartPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(lCartPanel));
        System.out.println(cartPanel.getText());
        Assert.assertTrue(cartPanel.getText().contains(myUrun));
        Thread.sleep(2000);
        clickTo(lCartPanelRemoveButton);
    }


    public void loginWebSite(String email, String password, int status) {

        clickTo(myAccountButton);
        clickTo(loginButton);
        sendKeys(LocatorsSite.email, email);
        sendKeys(LocatorsSite.password, password);
        clickTo(submitButton);

        if (status == 0) {
            driver.findElement(By.cssSelector("div#account-login > div.alert.alert-danger.alert-dismissible")).isDisplayed();
            driver.findElement(By.cssSelector("input#input-email")).clear();
            driver.findElement(By.cssSelector("input#input-password")).clear();
        } else {
            waitFor(WaitConditions.exist, By.cssSelector("i.fa.fa-heart"));
        }
    }


    public void quit() {
        afterSuite();
    }


    public void addProduct() throws InterruptedException {
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, "ipod" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        for (int i = 0; i < 3; i++) {
            clickTo(addToCartButton);
        }

        clickTo(lCart);
        Thread.sleep(2000);
        WebElement num = driver.findElement(lCartPanProductNum);
        num.getText();
        Assert.assertTrue(num.getText().contains("3"));
        Thread.sleep(3000);
        clickTo(lCartPanelRemoveButton);
    }


    public void removeProductCart() throws InterruptedException {
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, "ipod" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        clickTo(addToCartButton);
        clickTo(lHomePage);
        sendKeys(lSearch, "mac" + Keys.ENTER);
        products2 = driver.findElements(By.cssSelector(".caption a"));
        int rUrun2 = new Random().nextInt(products2.size());
        products2.get(rUrun2).click();
        clickTo(addToCartButton);
        Thread.sleep(5000);
        clickTo(lCart);
        List<WebElement> remButton = driver.findElements(By.xpath("//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr"));
        System.out.println(remButton.size());
        clickTo(lCart);
        for (int i = 0; i < remButton.size(); i++) {
            clickTo(lCart);
            clickTo(remButton2);
            Thread.sleep(1000);
        }
        clickTo(lCart);
        WebElement text = driver.findElement(By.cssSelector("div#cart p"));
        Assert.assertTrue(text.getText().contains("empty"));
    }

    public void clearPanel() throws InterruptedException {
        clickTo(lHomePage);
        clickTo(lCart);
        List<WebElement> remButton = driver.findElements(By.xpath("//ul[@class='dropdown-menu pull-right']/li/table/tbody/tr"));
        System.out.println(remButton.size());
        clickTo(lCart);
        for (int i = 0; i < remButton.size(); i++) {
            clickTo(lCart);
            clickTo(remButton2);
            Thread.sleep(1000);
        }
    }


    public void updateCartProduct() {
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, "iphone" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        clickTo(addToCartButton);
        clickTo(lCartPageButton);
        WebElement updateNumber = driver.findElement(By.cssSelector("div#content td:nth-child(4) > div > input"));
        updateNumber.clear();
        sendKeys(lUpdateNumber, "3");
        clickTo(lUpdateButton);
        String updateText = wait.until(ExpectedConditions.visibilityOfElementLocated(lUpdateText)).getText();
        Assert.assertTrue(updateText.contains("modified "));
        clickTo(lCartPageRemoveButton);
    }

    public void totalPriceandNameCheck() {
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, "iphone" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        WebElement eProductPrice = driver.findElement(By.cssSelector("div#content li:nth-child(1) > h2"));
        String productPrice = eProductPrice.getText().replaceAll("[^0-9]", "");
        double price1 = Double.parseDouble(productPrice) / 100;
        System.out.println(price1);
        clickTo(addToCartButton);

        clickTo(lHomePage);

        sendKeys(lSearch, "mac" + Keys.ENTER);
        products2 = driver.findElements(By.cssSelector(".caption a"));
        int rUrun2 = new Random().nextInt(products2.size());
        products2.get(rUrun2).click();
        WebElement eProductPrice2 = driver.findElement(By.cssSelector("div#content li:nth-child(1) > h2"));
        String productPrice2 = eProductPrice2.getText().replaceAll("[^0-9]", "");
        double price2 = Double.parseDouble(productPrice2) / 100;
        System.out.println(price2);
        clickTo(addToCartButton);

        clickTo(lHomePage);
        clickTo(lCart);

        WebElement totalPrice = driver.findElement(By.cssSelector("span[id='cart-total']"));
        String totalPriceT = totalPrice.getText().split("-")[1].replaceAll("[^0-9]", "");

        double totalPrice2 = Double.parseDouble(totalPriceT) / 100;
        System.out.println(totalPrice2);

        double toplam = price1 + price2;
        System.out.println(toplam);
        Assert.assertTrue(totalPrice2 == toplam);
    }

    public void productCheckOut() throws InterruptedException {
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, "mac" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        clickTo(addToCartButton);
        clickTo(lCart);
        clickTo(lCheckoutButton);
        clickTo(guestCheckButton);
        clickTo(lGuestCountinueButton);
        sendKeys(firstName, "celil");
        sendKeys(lastName, "sevim");
        sendKeys(lEmailYourP, "celilsvmm@gmail.com");
        sendKeys(lTelephone, "05439321666");
        sendKeys(lCompany, "türkiye");
        sendKeys(laddress1, "Cirgisin Mah Küme Evler");
        sendKeys(laddress2, "No 17");
        sendKeys(lCity, "Erzincan");
        sendKeys(lPostCode, "24000");
        WebElement country = driver.findElement(lCountry);
        WebElement state = driver.findElement(lState);
        selectOption(country, "215");
        Thread.sleep(1000);
        selectOption(state, "3344");
        clickTo(lCountinuebutton);
        sendKeys(textArea, "dhgfsdlgsdgflsgfhsdgfsd");
        clickTo(textAreaCountinue);
        clickTo(agreeCheckButoon);
        Thread.sleep(200);
        clickTo(agreeCountinue);
        clickTo(comfirnOrderButton);
        Thread.sleep(2000);
        WebElement chechkOutSuccesText = driver.findElement(By.cssSelector("div#common-success li:nth-child(4) > a"));

        Assert.assertTrue(chechkOutSuccesText.isDisplayed());

    }

    public void searchProduct() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        for (WebElement product : products) {
            System.out.println(product.getText());
        }
        for (WebElement product : products) {
            Assert.assertTrue(product.getText().toLowerCase(Locale.ROOT).contains(searchText));
        }

    }

    public void sortByProductNameA_Z() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);

        WebElement sort = driver.findElement(By.cssSelector("select#input-sort"));
        selectOption(sort, 1);
        products = driver.findElements(By.cssSelector(".caption a"));
        String productOneName = products.get(0).getText();
        Assert.assertTrue(productOneName.toLowerCase(Locale.ROOT).contains("imac"));


    }

    public void sortByProductNameZ_A() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);

        WebElement sort = driver.findElement(By.cssSelector("select#input-sort"));
        selectOption(sort, 2);
        products = driver.findElements(By.cssSelector(".caption a"));
        String productOneName = products.get(0).getText();
        Assert.assertTrue(productOneName.toLowerCase(Locale.ROOT).contains("macbook pro"));


    }

    public void sortByProductNameL_H() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);

        WebElement sort = driver.findElement(By.cssSelector("select#input-sort"));
        selectOption(sort, 3);
        products = driver.findElements(By.cssSelector(".caption a"));
        String productOneName = products.get(0).getText();
        Assert.assertTrue(productOneName.toLowerCase(Locale.ROOT).contains("imac"));

    }

    public void sortByProductNameH_L() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);

        WebElement sort = driver.findElement(By.cssSelector("select#input-sort"));
        selectOption(sort, 4);
        products = driver.findElements(By.cssSelector(".caption a"));
        String productOneName = products.get(0).getText();
        Assert.assertTrue(productOneName.toLowerCase(Locale.ROOT).contains("macbook pro"));

    }

    public void favoriteProduct() {
        String searchText = "mac";
        gotoUrl();
        clickTo(lHomePage);
        sendKeys(lSearch, searchText + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        clickTo(heartButton);
        String successText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#product-product > div.alert.alert-success.alert-dismissible"))).getText();
        System.out.println(successText);
        Assert.assertTrue(successText.contains("Success"));
    }

    public void messaageContactUs() {
        clickTo(lHomePage);
        clickTo(telephoneButton);
        sendKeys(messageTextArea, "merhaba java merhaba selenium :)))))");
        clickTo(messageSubmitButton);
        String ContactUsTextAssert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content > h1"))).getText();
        System.out.println(ContactUsTextAssert);
        Assert.assertTrue(ContactUsTextAssert.contains("Contact Us"));
        clickTo(messageCountinueButton);
    }

    public void updateAccount() {
        clickTo(lHomePage);
        clickTo(myAccountButtonHP);
        clickTo(editAccountButton);

        WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        firstName.clear();
        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        lastName.clear();
        WebElement emaill = driver.findElement(By.cssSelector("input#input-email"));
        emaill.clear();
        WebElement telephonee = driver.findElement(By.cssSelector("input#input-telephone"));
        telephonee.clear();

        sendKeys(firstName, "celil");
        sendKeys(lastName, "sevim");
        sendKeys(emaill, "celilsvmm@gmail.com");
        sendKeys(telephonee, "05439321666");

        clickTo(editAccountCountButton);

        String successText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#account-account > div.alert.alert-success.alert-dismissible"))).getText();
        Assert.assertTrue(successText.contains("Success"));
    }

    public void addToAddress() throws InterruptedException {
        clickTo(lHomePage);
        clickTo(myAccountButtonHP);
        clickTo(myAddressBookButton);
        clickTo(newAddressButton);
        sendKeys(firstNameadd, "celil");
        sendKeys(lastNameadd, "sevim");
        sendKeys(companyadd, "turkiye");
        sendKeys(address1add, "absdghdd");
        sendKeys(address2add, "csdasdas");
        sendKeys(cityadd, "erzincan");
        sendKeys(postCodeadd, "24000");
        WebElement countryadd = driver.findElement(By.cssSelector("select#input-country"));
        WebElement stateadd = driver.findElement(By.cssSelector("select#input-zone"));
        scrool(countryadd);
        selectOption(countryadd, "215");
        Thread.sleep(1000);
        selectOption(stateadd, 25);
        clickTo(newAdresCountButton);

        String assertText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#account-address > div.alert.alert-success.alert-dismissible"))).getText();
        Assert.assertTrue(assertText.contains("successfully"));
    }

    public void updateAdress() {
        clickTo(lHomePage);
        clickTo(myAccountButtonHP);
        clickTo(myAddressBookButton);
        clickTo(upAddressEditButton);
        WebElement address2 = driver.findElement(upAddress2);
        address2.clear();
        sendKeys(upAddress2, "kemah");
        clickTo(upAdressCountButton);
        String succesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#account-address > div.alert.alert-success.alert-dismissible"))).getText();
        Assert.assertTrue(succesText.contains("successfully updated"));

    }

    public void butTheProduct() {
        clickTo(lHomePage);
        sendKeys(lSearch, "ipod" + Keys.ENTER);
        products = driver.findElements(By.cssSelector(".caption a"));
        int rUrun = new Random().nextInt(products.size());
        products.get(rUrun).click();
        clickTo(addToCartButton);
        clickTo(lCartPageButton);
        clickTo(lCheckButtonP);
        clickTo(lCheckCount1);
        clickTo(lCheckCount2);
        sendKeys(textAreaBuy,"hshfgsdlhflsdkfhsldfhsldhf");
        clickTo(lCheckCount3);
        clickTo(checkButtonCl);
        clickTo(lCheckCount4);
        clickTo(comfirnOrderButton);
        String successText=wait.until(ExpectedConditions.visibilityOfElementLocated(successText4)).getText();
        Assert.assertTrue(successText.contains("successfully"));

    }


}


