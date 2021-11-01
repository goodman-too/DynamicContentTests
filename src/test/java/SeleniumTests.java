import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class SeleniumTests {

    WebDriver driver = Driver.getChromeDriver();
    DynamicContentPageSelenium dynamicContentPage;

    @BeforeTest
    public void setUp() {
        dynamicContentPage = new DynamicContentPageSelenium(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkPhotosExist() {
        dynamicContentPage.openPage();
        dynamicContentPage.checkAvatarsExist();
    }

    @Test
    public void checkTextBlocksExist() {
        dynamicContentPage.openPage();
        dynamicContentPage.checkTextBlocksExist();
        dynamicContentPage.checkTextBlocksHaveText();
    }
}
