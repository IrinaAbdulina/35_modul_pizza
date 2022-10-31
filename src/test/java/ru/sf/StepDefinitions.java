package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefinitions {
    public static final WebDriver webDriver;
    public static final ChooseCityPage chooseCityPage;
    public static final CityMenuPage cityMenuPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IRINA\\IdeaProjects\\cc-scenario\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);
    }

    @Given("url of restaurant  {string}")
    public void url_of_restaurant(String url) {
        chooseCityPage.go(url);
    }
    @Then("chose city {string}")
    public void chose_city(String city) {
        chooseCityPage.searchCity(city);
    }
    @Then("assert that chosen city is {string}")
    public void assert_that_chosen_city_is(String expectedCity) {
        final var currentActiveCity= cityMenuPage.getCurrentActiveCity();
        Assert.assertEquals(expectedCity, currentActiveCity);
    }

    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var cityNotFoundMessage = chooseCityPage.getCityNotFoundMessage();
        Assert.assertEquals(errorMessage, cityNotFoundMessage);
    }
}
