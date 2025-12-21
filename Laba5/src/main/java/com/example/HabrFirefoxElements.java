package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HabrFirefoxElements {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://habr.com/ru/articles/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Хабр"));

        String title = driver.getTitle();
        System.out.println("Заголовок сайта: " + title);

        // ===== Поиск статей =====
        List<WebElement> articles = driver.findElements(
                By.cssSelector("article h2 a")
        );

        System.out.println("\n=== СТАТЬИ НА ГЛАВНОЙ HABR ===");
        System.out.println("Найдено статей: " + articles.size());

        for (int i = 0; i < Math.min(5, articles.size()); i++) {
            System.out.println((i + 1) + ". " + articles.get(i).getText());
        }

        // ===== КЛИК ЧЕРЕЗ CSS =====
        System.out.println("\n=== CSS селектор ===");
        WebElement cssArticle = articles.get(0);
        System.out.println("Кликаем на: " + cssArticle.getText());
        cssArticle.click();
        System.out.println("Клик выполнен");

        Thread.sleep(3000);
        driver.navigate().back();

        // ===== КЛИК ЧЕРЕЗ XPATH =====
        System.out.println("\n=== XPath локатор ===");
        WebElement xpathArticle = driver.findElement(
                By.xpath("(//article//h2//a)[2]")
        );
        System.out.println("Кликаем на: " + xpathArticle.getText());
        xpathArticle.click();
        System.out.println("Клик выполнен");

        Thread.sleep(3000);

        driver.quit();
        System.out.println("\nСкрипт выполнен успешно");
    }
}