package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginCorrectCred() {
        provideEmail("dagebeyehu@gmail.com");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
    }


    public void provideEmail(String email) {
        enterText(By.cssSelector("input[type='email']"),email);
    }

    public void providePassword(String password) {
        enterText(By.cssSelector("input[type='password']"),password);
    }

    public void clickSubmit() {
        clickOnElement(By.cssSelector("[type='submit']"));
    }
}