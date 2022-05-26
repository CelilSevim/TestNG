package utils;

import org.openqa.selenium.By;

public interface LocatorsSite {
    String url=" http://opencart.abstracta.us/";
    String myEmail="celilsvmm@gmail.com";
    String myPassword="7869572410";

    /*
    Login Locator
     */
    By myAccountButton= By.xpath("//i[@class='fa fa-user']");
    By loginButton=By.cssSelector("div#top-links li.dropdown.open > ul > li:nth-child(2) > a");
    By email=By.cssSelector("input#input-email");
    By password=By.cssSelector("input#input-password");
    By submitButton=By.cssSelector("div#content form > input");
    By userAccountInner=By.cssSelector("div#top-links ul.dropdown-menu.dropdown-menu-right li");
    By logoutButton=By.cssSelector("div#top-links li.dropdown.open > ul > li:nth-child(5) > a");
    By logoutCountinueButton=By.cssSelector("div#content a");

    /*
    Add to cart locators
     */
    By lHomePage=By.cssSelector("div#logo a");
    By lSearch=By.cssSelector("input[name=search]");
    By addToCartButton=By.cssSelector("button#button-cart");


    By lCart=By.cssSelector("div#cart");
    By lCartPanel=By.cssSelector("ul.dropdown-menu.pull-right >li");

    By lCartPanProductNum=By.cssSelector("div#cart td:nth-child(3)");
    By lCartPanelRemoveButton=By.cssSelector("div#cart button[type=\"button\"] > i");

    By lCartPageButton=By.cssSelector("div#top-links li:nth-child(4) > a > i");
    By lCartPageRemoveButton=By.cssSelector("div#content button[type=\"button\"].btn.btn-danger > i");

    By lUpdateNumber=By.cssSelector("div#content td:nth-child(4) > div > input");
    By lUpdateButton=By.cssSelector("div#content button[type=\"submit\"].btn.btn-primary > i");
    By lUpdateText=By.cssSelector("div#checkout-cart > div.alert.alert-success.alert-dismissible");


    By lCheckoutButton=By.cssSelector("div#cart a:nth-child(2) > strong");


    /*
    Your Personal Details
     */
    By guestCheckButton=By.xpath("(//input[@name='account'])[2]");
    By firstName=By.cssSelector("input#input-payment-firstname");
    By lastName=By.cssSelector("input#input-payment-lastname");
    By lEmailYourP=By.cssSelector("input#input-payment-email");
    By lTelephone=By.cssSelector("input#input-payment-telephone");
    By lGuestCountinueButton=By.cssSelector("input#button-account");
    By lCompany=By.cssSelector("input#input-payment-company");
    By laddress1=By.cssSelector("input#input-payment-address-1");
    By laddress2=By.cssSelector("input#input-payment-address-2");
    By lCity=By.cssSelector("input#input-payment-city");
    By lPostCode=By.cssSelector("input#input-payment-postcode");
    By lCountry=By.cssSelector("select#input-payment-country");
    By lState=By.cssSelector("select#input-payment-zone");
    By lCountinuebutton=By.cssSelector("input#button-guest");

    By textArea=By.cssSelector("div#collapse-shipping-method textarea");
    By textAreaCountinue=By.cssSelector("input#button-shipping-method");
    By agreeCheckButoon=By.cssSelector("input[name=\"agree\"]");
    By agreeCountinue=By.cssSelector("input#button-payment-method");
    By comfirnOrderButton=By.cssSelector("input#button-confirm");


    /*
    sort product

     */
    By sortButton=By.cssSelector("select#input-sort");
    By remButton2 = By.cssSelector("i[class='fa fa-times']");

    By heartButton=By.xpath("(//i[@class='fa fa-heart'])[2]");

    By telephoneButton=By.cssSelector("div#top-links li:nth-child(1) > a > i");
    By messageTextArea=By.cssSelector("textarea#input-enquiry");
    By messageSubmitButton=By.cssSelector("div#content form > div > div > input");
    By messageCountinueButton=By.cssSelector("div#content a");


   By myAccountButtonHP=By.cssSelector("div:nth-child(4) > ul > li:nth-child(1) > a");
   By editAccountButton=By.cssSelector("div#content ul:nth-child(2) > li:nth-child(1) > a");
   By editAccountCountButton=By.cssSelector("div#content div.pull-right > input");

   By myAddressBookButton=By.cssSelector("div#content ul:nth-child(2) > li:nth-child(3) > a");
   By newAddressButton=By.cssSelector("div#content div.pull-right > a");
   By firstNameadd=By.cssSelector("input#input-firstname");
   By lastNameadd=By.cssSelector("input#input-lastname");
   By companyadd=By.cssSelector("input#input-company");
   By address1add=By.cssSelector("input#input-address-1");
   By address2add=By.cssSelector("input#input-address-2");
   By cityadd=By.cssSelector("input#input-city");
   By postCodeadd=By.cssSelector("input#input-postcode");
   By countryadd=By.cssSelector("select#input-country");
   By stateadd=By.cssSelector("select#input-zone");
   By newAdresCountButton=By.cssSelector("div#content div.pull-right > input");

   By upAddressEditButton=By.cssSelector("div#content tr:nth-child(1) > td.text-right > a.btn.btn-info");
   By upAddress2=By.cssSelector("input#input-address-2");
   By upAdressCountButton=By.cssSelector("div#content div.pull-right > input");


   /*
   buy
    */
    By cartPageButton=By.cssSelector("div#top-links li:nth-child(4) > a > i");
    By lCheckButtonP=By.cssSelector("div#content div.pull-right > a");
    By lCheckCount1=By.cssSelector("input#button-payment-address");
    By lCheckCount2=By.cssSelector("input#button-shipping-address");
    By lCheckCount3=By.cssSelector("input#button-shipping-method");
    By textAreaBuy=By.cssSelector("div#collapse-shipping-method textarea");
    By checkButtonCl=By.cssSelector("input[name=\"agree\"]");
    By lCheckCount4=By.cssSelector("input#button-payment-method");

    By comfirmButton=By.cssSelector("input#button-confirm");

    By successText4=By.cssSelector("div#content > p:nth-child(2)");

}
