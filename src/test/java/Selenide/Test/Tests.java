package Selenide.Test;


import Selenide.PO.PageThree;
import Selenide.PO.PageTwo;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import Selenide.PO.MainPage;


public class Tests {
    private MainPage mainPage;
    private PageTwo pageTwo;
    private PageThree pageThree;
    @BeforeEach
    public void option() {
        Configuration.timeout = 50000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    public void firsrTest(){
        mainPage = new MainPage();
        pageTwo = new PageTwo();
        pageThree = new PageThree();
        mainPage.open();
        mainPage.chooseCategory("Электроника");
        pageTwo.chooseCategory("Мобильные телефоны");
        pageThree.clickProduct("Apple");
        pageThree.checkProduct();
        boolean check = false;
        for (WebElement e: pageThree.getListOfProduct())
            if(e.getText().equals("APPLE"))
                check=true;
        Assertions.assertTrue(check);
    }

}
