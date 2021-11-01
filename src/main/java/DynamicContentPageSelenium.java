import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
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

    public void openPageInStaticMode() {
        driver.get("http://the-internet.herokuapp.com/dynamic_content?with_content=static");
    }

    public void checkAvatarsExist() {
        List<WebElement> avatarsList = driver.findElements(avatarsSelector);

        for (WebElement avatar : avatarsList) {
            Assert.assertTrue(avatar.isDisplayed());
        }
    }

    public void checkTextBlocksExist() {
        List<WebElement> textBlocksList = driver.findElements(textBlocksSelector);

        for (WebElement textBlock : textBlocksList) {
            Assert.assertTrue(textBlock.isDisplayed());
        }
    }

    public void checkTextBlocksHaveText() {
        List<WebElement> textBlocksList = driver.findElements(textBlocksSelector);

        for (WebElement textBlock : textBlocksList) {
            System.out.println("Text block has text:\n" + textBlock.getText() + "\n");
            Assert.assertNotNull(textBlock.getText());
        }
    }

    public void checkChangeText() {
        ArrayList<String> savedText = saveTextBlockText(driver.findElements(textBlocksSelector));
        driver.navigate().refresh();
        ArrayList<String> actualText = saveTextBlockText(driver.findElements(textBlocksSelector));

        for (int i = 0; i < savedText.size(); i++) {
            System.out.println("Saved and actual text:\n" + savedText.get(i) + "\n" + actualText.get(i));
        }

        Assert.assertNotEquals(savedText, actualText);
    }

    public void checkChangeOnlyThirdBlock() {
        ArrayList<String> savedText = saveTextBlockText(driver.findElements(textBlocksSelector));
        driver.navigate().refresh();
        ArrayList<String> actualText = saveTextBlockText(driver.findElements(textBlocksSelector));

        //Asserts
        System.out.println("Saved and actual text:\n" + savedText.get(0) + "\n" + actualText.get(0));
        Assert.assertEquals(savedText.get(0), actualText.get(0));

        System.out.println("Saved and actual text:\n" + savedText.get(1) + "\n" + actualText.get(1));
        Assert.assertEquals(savedText.get(1), actualText.get(1));

        System.out.println("Saved and actual text:\n" + savedText.get(2) + "\n" + actualText.get(2));
        Assert.assertNotEquals(savedText.get(2), actualText.get(2));
    }

    private ArrayList<String> saveTextBlockText(List<WebElement> webElements) {
        ArrayList<String> savedTextList = new ArrayList<>();

        for (WebElement textBlock : webElements) {
            savedTextList.add(textBlock.getText());
        }
        return savedTextList;
    }
}
