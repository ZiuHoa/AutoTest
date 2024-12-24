package UI.day07;

import UI.submitDemo.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ModelTest2 {
    public WebDriver driver;
    WebDriverWait wait;
    public LoginPageUI loginPageUI;
    String excelFilePath = "dataLogin.xlsx";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void setUrl() {
        driver.get("https://saucedemo.com");
        loginPageUI = new LoginPageUI(driver);
    }

    //Su dung module cach 2
    public void InputData(String user, String pass) {
        loginPageUI.inputUser().sendKeys(user);
        loginPageUI.inputPass().sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void logInSuccess() {
//        Su dung module cach 2
//       InputData("standard_user", "secret_sauce");
//       clickLogin();

        //Su dung doc file
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet2");
        for (Map<String, String> rowData : excelData) {
            driver.get("https://saucedemo.com");
            InputData(rowData.get("Username"), rowData.get("Password"));
            clickLogin();
            break;
        }

    }

    @Test
    public void loginFailed() {
        int count = 0;
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet2");
        for (Map<String, String> rowData : excelData) {
            if (count > 0) {
                driver.get("https://saucedemo.com");
                InputData(rowData.get("Username"), rowData.get("Password"));
                clickLogin();
            }
        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}