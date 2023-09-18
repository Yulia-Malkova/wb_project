package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    String itemPrice;
    String itemBrand;
    String itemName;
    private SelenideElement
            basketHeader = $(".basket-section__header").$(byText("Корзина")),
            itemCounter = $(".navbar-pc__notify"),
            itemNameInBasket = $(".good-info__good-name"),
            itemBrandInBasket = $(".good-info__good-brand "),
            itemPriceInBasket = $(".b-right"),
            itemSectionInBasket = $(".basket-section__basket-list.basket-list"),
            deleteButton = $(".btn__del"),
            emptyBasketMessage = $(".basket-page__basket-empty");

    public BasketPage(String itemPrice, String itemBrand, String itemName) {
        this.itemPrice = itemPrice;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
    }

    @Step("Проверяем наименование, производителя и стоимость добавленного в корзину товара")
    public void checkBasketPage() {

        itemCounter.shouldHave(Condition.text("1"));
        itemNameInBasket.shouldHave(Condition.text(itemName));
        itemBrandInBasket.shouldHave(Condition.text(itemBrand));
        itemPriceInBasket.shouldHave(Condition.text(itemPrice));
    }

    @Step("Кликаем на поле с товаром в корзине")
    public BasketPage clickOnItemSection() {

        itemSectionInBasket.click();
        return this;
    }

    @Step("Удаляем товар из корзины")
    public BasketPage deleteItemFromBasket() {

        deleteButton.click();
        return this;
    }

    @Step("Проверяем, что в корзине нет товаров")
    public void checkEmptyBasket() {

        emptyBasketMessage.shouldHave(Condition.text("В корзине пока пусто"));
    }
}
