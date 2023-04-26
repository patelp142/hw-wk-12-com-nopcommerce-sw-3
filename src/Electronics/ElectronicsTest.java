package Electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class ElectronicsTest extends Utilities {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //1.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']"),
                "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(3000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //2.3 Verify the text “Cell phones”
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']"),
                "Cell phones");

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyExpectedAndActual(By.xpath("//div[@class='product-name']"),
                "Nokia Lumia 1020");

        // 2.7 Verify the price “$349.00”
        verifyExpectedAndActual(By.xpath("//span[@id='price-value-20']"),
                "$349.00");

        // 2.8  Change quantity to 2
        clearElementValue(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button
        verifyExpectedAndActual(By.xpath("//div[@id='bar-notification']/div/p"),
                "The product has been added to your shopping cart");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        // 2.12 Verify the message "Shopping cart"
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']"),
                "Shopping cart");
        Thread.sleep(2000);

        // 2.13 Verify the quantity is 2
        //  verifyExpectedAndActual(By.xpath("//input[@id='itemquantity11347']"),
        //         "value=\"2\"");

        //2.14 Verify the Total $698.00
        verifyExpectedAndActual(By.xpath("//span[@class='product-subtotal']"),
                "$698.00");

        //2.15 click on checkbox “I agree with the terms of service
        clickOnElement(By.id("termsofservice"));

        // 2.16 Click on checkout
        clickOnElement(By.id("checkout"));

        //  2.17 Verify the Text “Welcome, Please Sign In!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),
                "Welcome, Please Sign In!");

        //2.18 Click on "Register" tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text "Register"
        verifyExpectedAndActual(By.xpath("//div[@class='page-title']"),
                "Register");

        // 2.20 Fill the mandatory fields
                clickOnElement(By.xpath("//input[@id='gender-female']"));
                sendTextToElement(By.id("FirstName"), "Raju");
                sendTextToElement(By.id("LastName"), "Japan");

                selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "11");
                selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
                selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1990");
                sendTextToElement(By.id("Email"), "raju15@gmail.com");

                sendTextToElement(By.id("Password"), "test123");
                sendTextToElement(By.id("ConfirmPassword"), "test123");

        //2.21 Click on "Register" button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        Thread.sleep(3000);
        verifyExpectedAndActual(By.xpath("//div[text()='Your registration completed']"),
                "Your registration completed");

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24  Verify the text “Shopping cart”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Shopping cart')]"),
                "Shopping cart");

        //click on the ‘Login’ link
        clickOnElement(By.xpath("//a[text()='Log in']"));
        //Enter valid username
        sendTextToElement(By.xpath("//input[@id='Email']"),"raju15@gmail.com");
        // Enter valid password
        sendTextToElement(By.xpath("//input[@id='Password']"),"test123");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//button[@type='submit' and text()='Log in']"));

        //2.25 click on checkbox "I agree with the terms of service"
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on "Checkout"
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
       // sendTextToElement(By.id("BillingNewAddress_FirstName"), "Prime");
      //  sendTextToElement(By.id("BillingNewAddress_LastName"), "Testing");
      //  sendTextToElement(By.id("BillingNewAddress_Email"), "prime1@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "london");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "100 harrow road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA1 6AG");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567890");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 click on Radio Button "2nd Day Air($0.00)"
        Thread.sleep(3000);
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on 'Continue'
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //2.31 Select Radio Button 'Credit Card'
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"Raju Japan");
        sendTextToElement(By.id("CardNumber"),"3252 7814 7648 5333");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"01");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2030");
        sendTextToElement(By.id("CardCode"),"111");

        //2.34 Click on "Continue Checkout
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Credit Card')]"),
                "Credit Card");

        //2.36 Verify “Shipping Method” is “2nd Day Air”
      //  verifyExpectedAndActual(By.xpath("//li[@class='shipping-method']"),
       //         "2nd Day Air");


        //2.37 Verify Total is “$698.00”
        verifyExpectedAndActual(By.xpath("//td[@class='subtotal']/span"),
                "$698.00");


        //2.38  Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the text Thank You
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Thank you')]"),
                "Thank you");


        //2.40 Verify the message “Your order has been successfully processed!”
        verifyExpectedAndActual(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
                "Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42  Verify the text “Welcome to our store”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Welcome to our store')]"),
                "Welcome to our store");

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();

        Assert.assertEquals("https://demo.nopcommerce.com/", url);
    }

}
