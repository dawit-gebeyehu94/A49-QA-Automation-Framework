public class Homework18 extends BaseTest {

    @Test()
    public void playSong () {
        navigateToPage();
        provideEmail("dagebeyehu@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(millis: 3000);
        //https://qa.koel.app/
        clickPlayNextBtn();
    }

    private void clickPlayNextBtn() {
        WebElement playNextBtn = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextBtn.click();
        Thread.sleep(millis: 3000);
    }
}
