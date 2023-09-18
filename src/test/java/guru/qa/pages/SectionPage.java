package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.Variables;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SectionPage {

    public String itemLink;
    public String itemName;
    public String itemPrice;
    public String itemBrand;
    Variables variables = new Variables();
    private final SelenideElement
    sectionTitle = $(".catalog-title"),
    randomItemCard = $$(".product-card__wrapper").get(variables.itemCardNumber),
    itemPriceElement = randomItemCard.$(".price__lower-price"),
    itemNameElement = randomItemCard.$(".product-card__name"),
    itemBrandElement = randomItemCard.$(".product-card__brand"),
    itemLinkElement = randomItemCard.$(".product-card__link");


    @Step("Получаем цену случайного товара")
    public SectionPage getPriceOfRandomItemCard() {

        itemPrice = itemPriceElement.getText();
        return this;
    }

    @Step("Получаем наименование случайного товара")
    public SectionPage getNameOfRandomItemCard() {

        itemName = itemNameElement.getText().substring(2);
        return this;
    }

    @Step("Получаем производителя случайного товара")
    public SectionPage getBrandOfRandomItemCard() {

        itemBrand = itemBrandElement.getText();
        return this;
    }

    @Step("Получаем ссылку на случайный товар")
    public SectionPage getItemLink() {

        itemLink = itemLinkElement.getAttribute("href");
        return this;
    }

    @Step("Открываем случайный товар")
    public ItemPage openRandomItemCard() {

        randomItemCard.click();
        return new ItemPage(itemPrice, itemBrand, itemName, itemLink);
    }

    @Step("Проверяем название секции")
    public void checkSectionName(String sectionName) {

        sectionTitle.shouldHave(Condition.text(sectionName));
    }
}
