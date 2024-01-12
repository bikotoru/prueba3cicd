package com.testqa;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081"); // Cambia la URL según tu configuración
    }

    @When("I enter the username {string} and password {string}")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username")); // Cambia el selector según tu HTML
        WebElement passwordField = driver.findElement(By.id("password")); // Cambia el selector según tu HTML

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-btn")); // Cambia el selector según tu HTML
        loginButton.click();
    }

    @Then("I should see {string} on the page")
    public void iShouldSeeOnThePage(String expectedText) {
        WebElement pageBody = driver.findElement(By.tagName("body"));
        String bodyText = pageBody.getText();

        assert bodyText.contains(expectedText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
