package starttesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @BeforeClass
    public void preConditions() {

        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositive() {
/*
1. click login
2. fill inputs
3. click Y'alla!
4. validate by text: Logged in success in the element //h2[@class='message']
 */

        WebElement buttonLogin = driver.findElement(By.xpath(""));
        buttonLogin.click();

        WebElement inputEmail = driver.findElement(By.xpath(""));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("");

        WebElement inputPassword = driver.findElement(By.xpath(""));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("");

        WebElement buttonYalla = driver.findElement(By.xpath(""));
        buttonYalla.click();

        WebElement textMessagePopUpH2 = driver.findElement(By.xpath("//h2[@class='message']"));
        String textMessageH2 = textMessagePopUpH2.getText().trim().toUpperCase();
        String expectedResult = "Logged in success".toUpperCase();
        Assert.assertEquals(textMessageH2, expectedResult);
    }

    @AfterClass
    public void postConditions() {

        driver.quit();
    }
}
