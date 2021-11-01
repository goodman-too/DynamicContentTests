import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;


public class DynamicContentPageSelenide {

    ElementsCollection avatarsForSelenide = $$(By.xpath("//div[@id='content']/div[@class='row']/div[1]/img"));
    ElementsCollection textBlocksSelenide = $$(By.xpath("//div[@id='content']/div[@class='row']/div[2]"));


    public void openPage() {
        open("http://the-internet.herokuapp.com/dynamic_content");
    }

    public void checkPhotosExist() {
        for (SelenideElement avatar : avatarsForSelenide) {
            avatar.shouldBe(Condition.visible);
        }
    }

    public void checkTextBlocksExist() {
        for (SelenideElement textBlock : textBlocksSelenide) {
            textBlock.shouldBe(Condition.visible);
        }

    }

    public void checkTextBlocksHaveText() {
        for (SelenideElement textBlock : textBlocksSelenide) {
            System.out.println("Text block has text:\n" + textBlock.getText() + "\n");
            Assert.assertNotNull(textBlock.getText());
        }
    }
}
