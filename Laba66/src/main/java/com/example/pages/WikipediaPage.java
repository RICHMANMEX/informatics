package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String URL = "https://ru.wikipedia.org/";

    private By searchInput = By.id("searchInput");
    private By searchButton = By.id("searchButton");
    private By heading = By.id("firstHeading");
    private By logo = By.cssSelector(".mw-wiki-logo");
    private By body = By.tagName("body");

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get(URL);
    }

    public void enterSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(text);
    }

    public void submitSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isHeadingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).isDisplayed();
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).getText();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(body)).isDisplayed();
    }
}