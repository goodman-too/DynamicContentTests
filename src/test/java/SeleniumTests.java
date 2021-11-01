import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class SeleniumTests {

    WebDriver driver;
    DynamicContentPageSelenium dynamicContentPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getChromeDriver();
        dynamicContentPage = new DynamicContentPageSelenium(driver);
    }

    @AfterMethod
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

    @Test
    public void checkTextBlocksChange() {
        dynamicContentPage.openPage();
        dynamicContentPage.checkChangeText();
    }

    @Test
    public void checkOnlyThirdTextBlockChange() {
        dynamicContentPage.openPageInStaticMode();
        dynamicContentPage.checkChangeOnlyThirdBlock();
    }
}
