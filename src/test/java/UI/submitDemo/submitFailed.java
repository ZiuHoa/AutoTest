package UI.submitDemo;

import UI.LoginDemoFindUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class submitFailed {
    private WebDriver driver;
    private static LoginDemoFindUI loginDemoFindUI;
    public submitFailed(WebDriver driver) {
        this.driver = driver;
        this.loginDemoFindUI = new LoginDemoFindUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        submitFailed submitFailed = new submitFailed(driver);
        submitFailed.loginDemoFindUI.findInputEmail().sendKeys("duyhoa.ic29@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        submitFailed.loginDemoFindUI.findInputFirstName().sendKeys("FirstName");
        submitFailed.loginDemoFindUI.findInputLastName().sendKeys("LastName");
        //submitFailed.loginDemoUI.findInputCompany().sendKeys("ABCompany");
        submitFailed.loginDemoFindUI.findInputPhoneNumber().sendKeys("+84123456789");
        submitFailed.loginDemoFindUI.findSelectCountry().click();
        submitFailed.loginDemoFindUI.findCountry().click();
        submitFailed.loginDemoFindUI.findSelectInterest().click();
        submitFailed.loginDemoFindUI.findInterest().click();
        submitFailed.loginDemoFindUI.findInputComments().sendKeys("Comments");
        submitFailed.loginDemoFindUI.findCheckboxPolicy().click();
        submitFailed.loginDemoFindUI.findButtonLetsTalk().click();
        Thread.sleep(5000);
        WebElement validText = driver.findElement(By.id("ValidMsgCompany"));
        System.out.println("Valid text: " + validText.getText());
        driver.quit();
    }
}
