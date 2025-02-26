import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HW19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        navigateToPage();
        provideEmail("dawit.gebeyehu@testpro.io");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        getDeletePlaylistMsg();



    }

    public String getDeletePlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        return notificationMsg.getText();

    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(8)"));
        emptyPlaylist.click();
    }
}
