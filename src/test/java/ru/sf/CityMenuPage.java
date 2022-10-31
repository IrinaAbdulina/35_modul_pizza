package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityMenuPage {
    private final WebDriver webDriver;
    private final static String ACTIVE_CITY_SPAN_XPATH = "//a[@data-testid='header__about-slogan-text_link']";

    public CityMenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentActiveCity() {
        return webDriver.findElement(By.xpath(ACTIVE_CITY_SPAN_XPATH)).getText();
    }

}
