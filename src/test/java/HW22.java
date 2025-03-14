import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class HW22 extends BaseTest {
    String newPlaylistName= "Updated playlist \"Test Pro.\"";
    @Test
    public void enterNewPlaylistName() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage PlaylistPage = new PlaylistPage(driver);

        loginPage.loginCorrectCred();
        PlaylistPage.clickOnCreatePlaylistBtn();
        PlaylistPage.clickOnCreateNewPlaylist();
        PlaylistPage.enterNewPlaylistName("TestPro");

        Assert.assertEquals(HomePage.getSuccessMessage(), newPlaylistName);

    }
}
