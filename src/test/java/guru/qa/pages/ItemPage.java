package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage {

    SectionPage sectionPage = new SectionPage();

    private SelenideElement
            itemHeader = $(".product-page__header-wrap"),
            priceBlock = $(".price-block__final-price");

    public void checkInformationOnItemPage(){
        itemHeader.shouldHave(Condition.text(sectionPage.itemName));
        itemHeader.shouldHave(Condition.text(sectionPage.itemBrand));
        priceBlock.shouldHave(Condition.text(sectionPage.itemPrice));
    }
}
