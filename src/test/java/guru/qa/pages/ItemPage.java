package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.DataExtractor;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ItemPage {
    private SelenideElement

            itemHeader = $(".product-page__header-wrap"),
            priceBlock = $(".product-page__price-block--aside"),
            basketButton = $(".product-page__aside-sticky"),
            deliveryInformationInfo = $(".product-page__aside-sticky").$(".delivery__store");

    @Step("Проверяем, что на странице товара отображаются верные наименование, производитель и цена")
    public void checkInformationOnItemPage(DataExtractor dataExtractor) {

        webdriver().shouldHave(url(dataExtractor.getItemLink()));
        itemHeader.shouldHave(Condition.text(dataExtractor.getItemBrand()));
        priceBlock.shouldHave(Condition.text(dataExtractor.getItemPrice()));
    }

    @Step("Добавляем товар в корзину")
    public ItemPage addItemToBasket() {
        waitTillInformationAboutDeliveryLoads();
        basketButton.$(byText("Добавить в корзину")).click();
        return this;
    }

    @Step("Открываем корзину")
    public void goToBasket() {

        basketButton.$(byText("Перейти в корзину")).click();
    }
    @Step("Проверяем, что информация о доставке загрузилась")
    public void waitTillInformationAboutDeliveryLoads() {

        deliveryInformationInfo.should(Condition.appear, Duration.ofSeconds(10));
    }
}
