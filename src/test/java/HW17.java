import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        loginWithCorrectCreds();
        enterSongIntoSearchInput();
        clickViewAllBtn();
        clickOnSongTitle();
        clickOnAddToBtn();
        enterNewUniquePlaylistName();
    }

    private void enterNewUniquePlaylistName() {
       enterText(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']"),getRandomString());

    }

    private void clickOnAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
    }

    private void clickOnSongTitle() {
        WebElement songTitle = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        songTitle.click();

    }

    private void enterSongIntoSearchInput() {
        enterText(By.cssSelector("[type='search']"), "Reactor");
        clickViewAllBtn();
    }

    private void clickViewAllBtn() {
        WebElement viewAllBtn= driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }


}

