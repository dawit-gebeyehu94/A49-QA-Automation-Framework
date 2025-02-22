import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Hello Playlist.\"";
        navigateToPage();
        provideEmail("dawit.gebeyehu@testpro.io");
        providePassword("yozca5uQiLxb!");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Pluto");
        clickViewBtn();
        CLickFirstSongResult();
        ClickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAppToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public String getAppToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement choosePL = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li{contains,(),'Hello Playlist'"));
        choosePL.click();
        Thread.sleep(2000);
    }

    public void ClickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void CLickFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id=songResultWrapper']tri[@class='song item][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickViewBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchform input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

}
