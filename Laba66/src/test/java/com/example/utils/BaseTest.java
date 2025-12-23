package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("=== ЗАКРЫВАЕМ БРАУЗЕР ===");
            driver.quit();
            System.out.println("✓ Браузер закрыт");
        }
    }
}