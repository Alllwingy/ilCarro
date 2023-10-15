package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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

    public void pause(int seconds) {
        try {

            Thread.sleep(seconds * 1_000L);

        } catch (InterruptedException e) {

            throw new RuntimeException(e); }
    }

    public boolean isElementExists(By locator) {

        return !findElementsBase(locator).isEmpty();
//        return findElementsBase(locator).size() > 0;
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

            System.out.println("expected result: " + expectedResult + "\nactual result: " + actualResult);
            return false;
        }
    }

    public void clickBase(By locator) {

        WebElement element = findElementBase(locator);
        element.click();
    }

    public void executeScript(String query) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(query);
    }

    public void clickByXY(By locator, int down, int right) {

        Rectangle rectangle = findElementBase(locator).getRect();
        int x = rectangle.getX() + right;
        int y = rectangle.getY() - down;

        Actions actions = new Actions(driver);
        actions.moveByOffset(x,y).click().perform();
    }
}
