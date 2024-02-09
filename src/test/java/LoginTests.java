import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    @Test
    public void validPassword() {
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void validLoginPassword(){
        loginPage.loginCorrectCred();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}