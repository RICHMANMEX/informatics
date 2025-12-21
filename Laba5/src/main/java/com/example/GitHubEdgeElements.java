package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class GitHubEdgeElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\WebDrivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://github.com/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            System.out.println("=== НАВИГАЦИОННЫЕ ССЫЛКИ GITHUB ===");

            List<WebElement> links = driver.findElements(By.cssSelector("a"));

            System.out.println("Найдено элементов: " + links.size());

            for (int i = 0; i < links.size(); i++) {
                String text = links.get(i).getText().trim();
                if (!text.isEmpty()) {
                    System.out.println((i + 1) + ". " + text);
                }
            }

            // === CSS селектор + JS click ===
            System.out.println("\n=== CSS селектор ===");

            WebElement cssElement = driver.findElement(By.cssSelector("a[href='/pricing']"));

            String cssText = cssElement.getText();
            System.out.println("Найден элемент: " + cssText);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", cssElement);

            System.out.println("Клик выполнен (Pricing)");

            // === XPath ===
            System.out.println("\n=== XPath локатор ===");

            WebElement xpathElement = driver.findElement(
                    By.xpath("//a[contains(@href,'/features')]")
            );

            String xpathText = xpathElement.getText();
            System.out.println("Найден элемент: " + xpathText);

            js.executeScript("arguments[0].click();", xpathElement);

            System.out.println("Клик выполнен (Features)");


        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}