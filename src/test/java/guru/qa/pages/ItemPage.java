package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ItemPage {
    String itemPrice;
    String itemBrand;
    String itemName;
    String itemLink;

    private SelenideElement

            currencyDropdown = $(".simple-menu__currency"),
            itemHeader = $(".product-page__header-wrap"),
            nameInfo = $("[data-link='text{:selectedNomenclature^goodsName}']"),
            brandInfo = $("[data-link='text{:selectedNomenclature^brandName}']"),
            priceBlock = $(".product-page__price-block.product-page__price-block--aside"),
            addToBasketButton = $(".product-page__aside-sticky").$(byText("Добавить в корзину")),
            goToBasketButton = $(".navbar-pc__icon--basket");

    public ItemPage(String itemPrice, String itemBrand, String itemName, String itemLink) {

        this.itemPrice = itemPrice;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemLink = itemLink;
    }

    public ItemPage() {
    }

    @Step("Проверяем, что на странице товара отображаются верные наименование, производитель и цена")
    public void checkInformationOnItemPage() {

        webdriver().shouldHave(url(itemLink));
        nameInfo.shouldHave(Condition.text(itemName));
        itemHeader.shouldHave(Condition.text(itemBrand));
        priceBlock.shouldHave(Condition.text(itemPrice));
    }

    @Step("Добавляем товар в корзину")
    public ItemPage addItemToBasket() {

        addToBasketButton.click();
        return this;
    }

    @Step("Открываем корзину")
    public BasketPage goToBasket() {

        goToBasketButton.click();
        return new BasketPage(itemPrice, itemBrand, itemName);
    }
}
