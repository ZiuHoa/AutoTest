package UI.submitDemo;

import UI.LoginDemoFindUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class submitSuccess {
    private WebDriver driver;
    private static LoginDemoFindUI loginDemoFindUI;
    public submitSuccess(WebDriver driver) {
        this.driver = driver;
        this.loginDemoFindUI = new LoginDemoFindUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        submitSuccess submitSuccess = new submitSuccess(driver);
        submitSuccess.loginDemoFindUI.findInputEmail().sendKeys("duyhoa.ic29@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        submitSuccess.loginDemoFindUI.findInputFirstName().sendKeys("FirstName");
        submitSuccess.loginDemoFindUI.findInputLastName().sendKeys("LastName");
        submitSuccess.loginDemoFindUI.findInputCompany().sendKeys("ABCompany");
        submitSuccess.loginDemoFindUI.findInputPhoneNumber().sendKeys("+84123456789");
        submitSuccess.loginDemoFindUI.findSelectCountry().click();
        submitSuccess.loginDemoFindUI.findCountry().click();
        submitSuccess.loginDemoFindUI.findSelectInterest().click();
        submitSuccess.loginDemoFindUI.findInterest().click();
        submitSuccess.loginDemoFindUI.findInputComments().sendKeys("Comments");
        submitSuccess.loginDemoFindUI.findCheckboxPolicy().click();
        submitSuccess.loginDemoFindUI.findButtonLetsTalk().click();
        Thread.sleep(5000);
        driver.quit();
    }
}
