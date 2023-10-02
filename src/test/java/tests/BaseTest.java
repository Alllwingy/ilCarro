package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static ApplicationManager apple = new ApplicationManager();

    @BeforeSuite // запуск всех тестов
    public void setup() {

        apple.init();
    }

    @AfterSuite
    public void stop() {

        apple.tearDown();
    }
}
