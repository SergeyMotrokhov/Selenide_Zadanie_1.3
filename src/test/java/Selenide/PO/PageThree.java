package Selenide.PO;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class PageThree {
    private int count;
    private String chooseProduct = "//span[text()='%s']/ancestor::*[@class='LhMupC0dLR']";
    private ElementsCollection listOfProduct = $$(By.xpath("//*[@class='n-snippet-cell2__brand-name']"));
    private WebElement pageGo = $(By.xpath("//span[text()='Вперед']/ancestor::a"));

    private void son(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public PageThree clickProduct(String category){
        $(By.xpath(format(chooseProduct, category))).click();
        return this;
    }

    public ElementsCollection getListOfProduct(){
        son(5000);
        return listOfProduct;
    }

    public PageThree checkProduct() {
        count=1;
        son(5000);
        while (pageGo.isDisplayed()){
            if(count<=10){
                try {
                    pageGo.click();
                    count++;
                    son(5000);
                }
                catch (NoSuchElementException e){
                    break;
                }
            }else {
                break;
            }
        }
    return this;
    }
}
