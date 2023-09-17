package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementDescriber;
import guru.qa.utils.Variables;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SectionPage {

    Variables variables = new Variables();
    public String itemPrice;
    public String itemName;
    public String itemBrand;

    private SelenideElement
            sectionTitle = $(".catalog-title"),
            itemsGallery = $(".goods-slider__header");

    private ElementsCollection
            itemCards = $$(".product-card__wrapper");

    public SectionPage getPriceOfRandomItemCard(){
       SelenideElement itemPriceElement = itemCards.get(1);
        itemPrice = itemPriceElement.$(".price__lower-price").getText();
       return this;
    }
    public SectionPage getNameOfRandomItemCard(){
        SelenideElement itemNameElement = itemCards.get(1);
        itemName = itemNameElement.$(".product-card__name").getText();
        return this;
    }
    public SectionPage getBrandOfRandomItemCard(){
        SelenideElement itemBrandElement = itemCards.get(1);
        itemBrand = itemBrandElement.$(".product-card__name").getText();
        return this;
    }
    public void openRandomItemCard(){
        itemCards.get(1).click();}

    public void checkSectionName(String sectionName) {
        sectionTitle.shouldHave(Condition.text(sectionName));
    }
        }
