import UI.LoginDemoUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo {
    private  WebDriver driver;
    private LoginDemoUI loginDemoUI;
    public Demo(WebDriver driver) {
        this.driver = driver;
        this.loginDemoUI = new LoginDemoUI(driver);
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        // Tạo instance của TestDemo
        Demo Demo = new Demo(driver);
        // Sử dụng requestDemoPageUI
        Demo.loginDemoUI.findInputEmail().sendKeys("duyhoa.ic29@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Demo.loginDemoUI.findInputFirstName().sendKeys("FirstName");
        Demo.loginDemoUI.findInputLastName().sendKeys("LastName");
        Demo.loginDemoUI.findInputCompany().sendKeys("ABCompany");
        Demo.loginDemoUI.findInputPhoneNumber().sendKeys("+84123456789");
        Demo.loginDemoUI.findSelectCountry().click();
        Demo.loginDemoUI.findCountry().click();
        Demo.loginDemoUI.findSelectInterest().click();
        Demo.loginDemoUI.findInterest().click();
        Demo.loginDemoUI.findInputComments().sendKeys("Comments");
        Demo.loginDemoUI.findCheckboxPolicy().click();
        Demo.loginDemoUI.findButtonLetsTalk().click();
        driver.quit();
    }
}