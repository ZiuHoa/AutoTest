package UI.submitDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageUI {
    public LoginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public WebElement inputUser() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement inputPass() {
        return driver.findElement(By.id("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.id("login-button"));
    }
}
