import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTests {

    DynamicContentPageSelenide dynamicContentPage = new DynamicContentPageSelenide();

    @BeforeClass
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void checkPhotosExist() {
        dynamicContentPage.openPage();
        dynamicContentPage.checkPhotosExist();
    }

    @Test
    public void checkTextBlocksExist() {
        dynamicContentPage.openPage();
        dynamicContentPage.checkTextBlocksExist();
        dynamicContentPage.checkTextBlocksHaveText();
    }
}
