package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement findElementBase(By locator) {

        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {

        return driver.findElements(locator);
    }

    public void clickBase(By locator) {

        WebElement element = findElementBase(locator);
        element.click();
    }

    public String getTextBase(By locator) {

        WebElement element = findElementBase(locator);
        return element.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text) {

        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult) {

        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)) {

            return true;
        } else {

            System.out.println("expected result: " + expectedResult + " actual result: " + actualResult);
            return false;
        }
    }
}
