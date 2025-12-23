package com.example.tests;

import com.example.pages.WikipediaPage;
import com.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTests extends BaseTest {

    private WikipediaPage page;

    @Test(priority = 1)
    public void testOpenPage() {
        System.out.println("=== Тест 1: Открытие страницы ===");
        page = new WikipediaPage(driver);
        page.openPage();
        Assert.assertTrue(page.isPageLoaded());
        System.out.println("✓ Страница открыта");
    }

    @Test(priority = 2, dependsOnMethods = "testOpenPage")
    public void testLogoDisplayed() {
        System.out.println("=== Тест 2: Проверка логотипа ===");
        Assert.assertTrue(page.isLogoDisplayed());
        System.out.println("✓ Логотип отображается");
    }

    @Test(priority = 3, dependsOnMethods = "testOpenPage")
    public void testTitleNotEmpty() {
        System.out.println("=== Тест 3: Проверка заголовка страницы ===");
        Assert.assertFalse(page.getTitle().isEmpty());
        System.out.println("✓ Заголовок не пустой");
    }

    @Test(priority = 4, dependsOnMethods = "testOpenPage")
    public void testSearch() {
        System.out.println("=== Тест 4: Поиск статьи ===");
        page.enterSearchText("Java");
        page.submitSearch();
        Assert.assertTrue(page.isHeadingDisplayed());
        System.out.println("✓ Поиск выполнен");
    }

    @Test(priority = 5, dependsOnMethods = "testSearch")
    public void testHeadingContainsText() {
        System.out.println("=== Тест 5: Проверка текста заголовка ===");
        Assert.assertTrue(page.getHeadingText().toLowerCase().contains("java"));
        System.out.println("✓ Заголовок корректный");
    }

    @Test(priority = 6)
    public void testUrlContainsWikipedia() {
        System.out.println("=== Тест 6: Проверка URL ===");
        page = new WikipediaPage(driver);
        page.openPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia"));
        System.out.println("✓ URL корректный");
    }

    @Test(priority = 7)
    public void testEmptySearch() {
        System.out.println("=== Тест 7: Пустой поиск ===");
        page = new WikipediaPage(driver);
        page.openPage();
        page.submitSearch();
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));
        System.out.println("✓ Пустой поиск обработан");
    }

    @Test(priority = 8)
    public void testMultipleActions() {
        System.out.println("=== Тест 8: Многократные действия ===");
        page = new WikipediaPage(driver);
        page.openPage();
        page.enterSearchText("Selenium");
        page.submitSearch();
        page.openPage();
        Assert.assertTrue(page.isLogoDisplayed());
        System.out.println("✓ Многократные действия выполнены");
    }
}