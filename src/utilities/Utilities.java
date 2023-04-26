package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utilities extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will clear filled detials
    public void clearElementValue(By by) {

        driver.findElement(by).clear();
    }

    //This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);
    }

    public void selectByVisibleTextFromDropDown(By by, String option) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by visible text
        select.selectByVisibleText(option);
    }
// Mousehover Method
    public void mouseHoverToElement(By by) {
        Actions action = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        action.moveToElement(mouseHover).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions action = new Actions(driver);
        WebElement mouseHoverAndClick = driver.findElement(by);
        action.moveToElement(mouseHoverAndClick).click().build().perform();
    }

}
