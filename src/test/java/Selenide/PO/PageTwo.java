package Selenide.PO;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.String.format;

public class PageTwo {
    private String chooseCat = "//*[@data-tid='cb168a42']//a[text()='%s']";

    public PageThree chooseCategory(String category){
        $(By.xpath(format(chooseCat, category))).click();
        return page(PageThree.class);
    }

}
