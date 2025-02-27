import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
        public WebDriver driver = null;
        //    public String url = "https://qa.koel.app/";
        public String url;
        WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        url=baseURL;
        driver = new ChromeDriver(options);
        //instantiate Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        enterText(By.cssSelector("input[type='email']"),email);
    }

    public void providePassword(String password) {
        enterText(By.cssSelector("input[type='password']"),password);
    }

    public void clickSubmit() {
        clickOnElement(By.cssSelector("button[type='submit']"));
    }
    public String getDeletePlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        return notificationMsg.getText();

    }

    public void clickDeletePlaylistBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        //deletePlaylist.click();
        //Thread.sleep(2000);
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(8)"));
        emptyPlaylist.click();
    }
    public void loginCorrectCred() {
        navigateToPage();
        provideEmail("dawit.gebeyehu@testpro.io");
        providePassword("yozca5uQiLxb!");
    }

    void clickOnElement(By locator){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    void enterText(By locator, String text){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }
}