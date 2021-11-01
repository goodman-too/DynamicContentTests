import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class DynamicContentPageSelenium {

    By avatarsSelector = By.xpath("//div[@id='content']/div[@class='row']/div[1]/img");
    By textBlocksSelector = By.xpath("//div[@id='content']/div[@class='row']/div[2]");

    private final WebDriver driver;


    public DynamicContentPageSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/dynamic_content");
    }

    public void checkAvatarsExist() {
        List<WebElement> avatarsList = getElementsList(avatarsSelector);

        for (WebElement avatar : avatarsList) {
            Assert.assertTrue(avatar.isDisplayed());
        }
    }

    public void checkTextBlocksExist() {
        List<WebElement> textBlocksList = getElementsList(textBlocksSelector);

        for (WebElement textBlock : textBlocksList) {
            Assert.assertTrue(textBlock.isDisplayed());
        }
    }

    public void checkTextBlocksHaveText() {
        List<WebElement> textBlocksList = getElementsList(textBlocksSelector);

        for (WebElement textBlock : textBlocksList) {
            System.out.println("Text block has text:\n" + textBlock.getText() + "\n");
            Assert.assertNotNull(textBlock.getText());
        }
    }

    private List<WebElement> getElementsList(By by) {
        return driver.findElements(by);
    }
}
