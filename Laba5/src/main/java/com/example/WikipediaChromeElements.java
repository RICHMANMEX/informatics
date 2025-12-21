package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikipediaChromeElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.wikipedia.org/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // Находим языковые ссылки
            List<WebElement> languages = driver.findElements(By.cssSelector("a.link-box"));

            System.out.println("=== ЯЗЫКИ WIKIPEDIA ===");
            System.out.println("Всего найдено: " + languages.size());

            for (int i = 0; i < languages.size(); i++) {
                String text = languages.get(i).getText().trim();
                if (!text.isEmpty()) {
                    System.out.println((i + 1) + ". " + text);
                }
            }

            // Клик через CSS
            System.out.println("\n=== CSS селектор ===");
            WebElement englishCss = driver.findElement(By.cssSelector("a#js-link-box-en"));
            System.out.println("Кликаем на: " + englishCss.getText());
            englishCss.click();

            Thread.sleep(3000);

            // Возврат назад
            driver.navigate().back();
            Thread.sleep(3000);

            // Клик через XPath
            System.out.println("\n=== XPath локатор ===");
            WebElement englishXpath = driver.findElement(
                    By.xpath("//a[@id='js-link-box-en']")
            );
            System.out.println("Кликаем на: " + englishXpath.getText());
            englishXpath.click();

            Thread.sleep(3000);

            System.out.println("\nСкрипт выполнен успешно");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

