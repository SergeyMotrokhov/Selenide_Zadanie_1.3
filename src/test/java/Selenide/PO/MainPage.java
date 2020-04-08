package Selenide.PO;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.page;
import static java.lang.String.format;


public class MainPage {
    private String chooseCat = "//span[text()='%s']/ancestor::a";


    public MainPage open(){
        Selenide.open("https://market.yandex.ru/");
        return this;
    }

    public PageTwo chooseCategory(String category){
        $(By.xpath(format(chooseCat, category))).click();
        return page(PageTwo.class);
    }
}
