import UI.LoginDemoUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

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
        //driver.navigate().to("https://saucelabs.com/request-demo");
        //In đường dẫn
        //String getUrl = driver.getCurrentUrl();
        //System.out.println("Đường dẫn là: " + getUrl);

        //Tìm và in text
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println("Header text: " + header.getText());

        //Tìm list và in text
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        System.out.println("\nParagraphs:");
        for (WebElement paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }
        //Tìm phần tử theo CSS Selector: tất cả các nút <button>
        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
        System.out.println("\nButtons:");
        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }
        //Tìm phần tử theo CSS Selector: tất ả các input có name là "Email"
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='Email']"));
        emailInput.sendKeys("abc@gmail.com");
//        Một số CSS Selector phổ biến:
//        tagName.className:
//        Tìm thẻ với class cụ thể. Ví dụ: button.submit (tìm thẻ <button> có class là submit).
//
//        tagName#id:
//        Tìm thẻ với ID cụ thể. Ví dụ: input#email (tìm thẻ <input> có ID là email).
//
//                tagName[attribute='value']:
//        Tìm thẻ với thuộc tính và giá trị cụ thể. Ví dụ: input[name='email'].
//
//                tagName > child:
//        Tìm phần tử con trực tiếp. Ví dụ: div > p (tìm <p> là con trực tiếp của <div>).
//
//                tagName:first-child:
//        Tìm phần tử con đầu tiên. Ví dụ: li:first-child.
        // Tạo instance của TestDemo
        Demo Demo = new Demo(driver);
        // Sử dụng requestDemoPageUI
        /*Demo.loginDemoUI.findInputEmail().sendKeys("duyhoa.ic29@gmail.com");
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
        Demo.loginDemoUI.findButtonLetsTalk().click();*/
        //Tìm element
        //WebElement element = driver.findElement(By.linkText("Try it free"));
        //WebElement element = driver.findElement(By.partialLinkText("Try"));
       //element.click();
        driver.quit();
    }
}