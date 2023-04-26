package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class TopMenuTest extends Utilities {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyPageNavigation() {
        //use selectMenu method to click on menu
        selectMenu("Computers");
        //verify page is navigated to selected menu
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals("Error message not displayed","Computers", actualMessage);
    }
    @After
    public void tearDown() {
      //  closeBrowser();
    }
}
