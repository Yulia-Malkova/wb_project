package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.Variables;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    Variables variables = new Variables();

    private SelenideElement
            menuButton = $(".nav-element__burger"),
            currencyDropdown = $(".simple-menu__currency"),
            currencyIcon = $(".simple-menu__currency"),
            searchBar = $("#searchInput"),
            supportIcon = $(".smm-fixed__toggle"),
            supportChatWindow = $(".chat__content-wrap"),
            supportDialogueName = $(".chat__text"),
            supportChatBody = $(".chat__message-none"),
            supportChatInput = $(".chat__inputs-wrap"),
            menuCloseButton = $(".menu-burger__close");


    private ElementsCollection
            menuSection = $$(".menu-burger__main-list-link"),
            menuFinalSubsection = $$(".menu-burger__link"),
            currencyValue = $$(".radio-with-text__name");


    @Step("Кликаем на строку поиска")
    public MainPage clickSearchBar() {
        waitTillChatLoads();
        searchBar.click();
        return this;
    }

    @Step("Добавляем текст в строку поиска")
    public void fillInSearchInput(String searchInput) {
        searchBar.setValue(searchInput).pressEnter();
    }
    @Step("Проверяем, что чат поддержки загрузился")
    public MainPage waitTillChatLoads(){
        supportIcon.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    @Step("Открываем чат поддержки")
    public MainPage openSupportChat() {
        waitTillChatLoads();
        supportIcon.click();
        return this;
    }

    @Step("Проверяем, что чат поддержки открылся и сообщений пока нет")
    public void checkSupportChatWindow() {

        supportChatWindow.shouldBe(visible);
        supportDialogueName.shouldHave(exactText("Поддержка Wildberries"));
        supportChatBody.shouldHave(exactText("Сообщений пока нет"));
        supportChatInput.shouldBe(visible);

    }

    @Step("Открываем меню")
    public MainPage openMenu() {
        waitTillChatLoads();
        menuButton.click();
        waitUntilMenuLoads();
        return this;
    }

    @Step("Переходим в секцию")
    public void clickOnSection(String value) {

        menuSection.findBy(text(value)).click();
    }

    @Step("Переходим в секцию")
    public void goToFinalSection() {

        menuSection.findBy(text(variables.randomSection)).hover();
        menuFinalSubsection.get(1).click();
        waitUntilCurrencyDropdownLoads();
    }

    @Step("Переходим в секцию")
    public void goToSection(String sectionName) {

        menuSection.findBy(text(sectionName)).hover();
        menuFinalSubsection.get(1).click();
        waitUntilCurrencyDropdownLoads();
    }

    @Step("Проверяем, что дропдаун с валютами загрузился")
    public MainPage waitUntilCurrencyDropdownLoads() {

        currencyDropdown.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    @Step("Проверяем, что меню загрузилось")
    public MainPage waitUntilMenuLoads() {
        menuCloseButton.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    @Step("Наводим курсор на секцию")
    public MainPage hoverOnSection(String value) {

        menuSection.findBy(text(value)).hover();
        return this;
    }


    @Step("Проверяем, что у выбранной секции есть нужная подсекция")
    public void checkSubsectionNameInChosenSection(String value) {

        menuFinalSubsection.findBy(text(value)).shouldHave(text(value));
    }

    @Step("Наводим курсор на дропдаун с валютами")
    public MainPage hoverOnCurrencyDropdown() {

        currencyDropdown.hover();
        return this;
    }

    @Step("Меняем валюту")
    public MainPage changeCurrency(String currency) {

        currencyValue.findBy(text(currency)).click();
        return this;
    }

    @Step("Проверяем, что валюта поменялась")
    public void checkCurrencyChange(String currency) {

        currencyIcon.shouldHave(text(currency));
    }
}
