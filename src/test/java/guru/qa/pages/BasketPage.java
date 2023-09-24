package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.DataExtractor;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private SelenideElement
            itemCounter = $(".navbar-pc__notify"),
            itemNameInBasket = $(".good-info__good-name"),
            itemBrandInBasket = $(".good-info__good-brand "),
            itemPriceInBasket = $(".b-right"),
            itemSectionInBasket = $(".basket-section__basket-list.basket-list"),
            deleteButton = $(".btn__del"),
            emptyBasketMessage = $(".basket-page__basket-empty");


    @Step("Проверяем наименование, производителя и стоимость добавленного в корзину товара")
    public void checkBasketPage(DataExtractor dataExtractor) {

        itemCounter.shouldHave(Condition.text("1"));
        itemNameInBasket.shouldHave(Condition.text(dataExtractor.getItemName()));
        itemBrandInBasket.shouldHave(Condition.text(dataExtractor.getItemBrand()));
        itemPriceInBasket.shouldHave(Condition.text(dataExtractor.getItemPrice()));
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
