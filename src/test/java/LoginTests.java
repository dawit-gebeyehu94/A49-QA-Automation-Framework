import PageFactory.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    @Test
    public void validPassword() throws InterruptedException {
        loginPage.loginCorrectCred();
    }
    @Test
    public void validLoginPassword(){
        loginPage.loginCorrectCred();
    }
}