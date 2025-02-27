import org.testng.annotations.Test;

public class HW20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        loginCorrectCred();
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        getDeletePlaylistMsg();
    }
}

