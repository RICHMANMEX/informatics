package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GitHubEdgeTitle {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver", "C:\\WebDrivers\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://github.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("GitHub"));

        String title = driver.getTitle();
        System.out.println("Заголовок сайта: " + title);

        driver.quit();
    }
}

