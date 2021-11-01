import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;


public class DynamicContentPageSelenide {

    ElementsCollection avatarsForSelenide = $$(By.xpath("//div[@id='content']/div[@class='row']/div[1]/img"));
    ElementsCollection textBlocksSelenide = $$(By.xpath("//div[@id='content']/div[@class='row']/div[2]"));


    public void openPage() {
        open("http://the-internet.herokuapp.com/dynamic_content");
    }

    public void openPageInStaticMode() {
        open("http://the-internet.herokuapp.com/dynamic_content?with_content=static");
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

    public void checkChangeText() {
        ArrayList<String> savedText = saveTextBlockText();
        Selenide.refresh();
        ArrayList<String> actualText = saveTextBlockText();

        for (int i = 0; i < savedText.size(); i++) {
            System.out.println("Saved and actual text:\n" + savedText.get(i) + "\n" + actualText.get(i));
        }

        Assert.assertNotEquals(savedText, actualText);
    }

    public void checkChangeOnlyThirdBlock() {
        ArrayList<String> savedText = saveTextBlockText();
        Selenide.refresh();
        ArrayList<String> actualText = saveTextBlockText();

        //Asserts
        System.out.println("Saved and actual text:\n" + savedText.get(0) + "\n" + actualText.get(0));
        Assert.assertEquals(savedText.get(0), actualText.get(0));

        System.out.println("Saved and actual text:\n" + savedText.get(1) + "\n" + actualText.get(1));
        Assert.assertEquals(savedText.get(1), actualText.get(1));

        System.out.println("Saved and actual text:\n" + savedText.get(2) + "\n" + actualText.get(2));
        Assert.assertNotEquals(savedText.get(2), actualText.get(2));
    }

    private ArrayList<String> saveTextBlockText() {
        ArrayList<String> savedTextList = new ArrayList<>();

        for (SelenideElement textBlock : textBlocksSelenide) {
            savedTextList.add(textBlock.getText());
        }
        return savedTextList;
    }
}
