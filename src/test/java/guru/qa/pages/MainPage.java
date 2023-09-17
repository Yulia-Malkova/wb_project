package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.Variables;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement
            menuButton = $(".nav-element__burger"),
            currencyDropdown = $(".simple-menu__currency"),
            currencyIcon = $(".simple-menu__currency"),
            searchBar = $("#searchInput"),
            supportIcon = $(".smm-fixed__toggle[aria-label='Онлайн чат']"),
            supportChatWindow = $(".chat__content-wrap"),
            supportDialogueName = $(".chat__text"),
            supportChatBody = $(".chat__message-none"),
            supportChatInput = $(".chat__inputs-wrap");


    private ElementsCollection
            menuSection = $$(".menu-burger__main-list-link"),
            menuSubsection = $$(".menu-burger__next"),
            currencyValue = $$(".radio-with-text__name");


    public MainPage clickSearchBar(){
        searchBar.click();
        return this;
    }

    public void fillInSearchInput(String searchInput){
        searchBar.setValue(searchInput).pressEnter();
    }
    public MainPage waitUntilSupportChatLoads() {
        supportIcon.should(Condition.appear, Duration.ofSeconds(50));
        return this;}



    public void openSupportChat(){
        supportIcon.click();
    }
    public void checkSupportChatWindow(){
        supportChatWindow.shouldBe(visible);
        supportDialogueName.shouldHave(exactText("Поддержка Wildberries"));
        supportChatBody.shouldHave(exactText("Сообщений пока нет"));
        supportChatInput.shouldBe(visible);

    }
    public MainPage openMenu() {
        menuButton.click();
        return this;
    }

    public MainPage clickOnSection(String value) {
        menuSection.findBy(text(value)).click();
        return this;
    }

    public MainPage waitUntilCurrencyDropdownLoads() {
        currencyDropdown.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    public MainPage hoverOnSection(String value) {
        menuSection.findBy(text(value)).hover();
        return this;
    }

    public void checkSubsectionNameInChosenSection(String value) {
        menuSubsection.findBy(text(value)).shouldHave(text(value));
    }

    public MainPage hoverOnCurrencyDropdown() {
        currencyDropdown.hover();
        return this;
    }

    public MainPage changeCurrency(String currency) {
        currencyValue.findBy(text(currency)).click();
        return this;
    }

    public void checkCurrencyChange(String currency) {
        currencyIcon.shouldHave(text(currency));
    }

}
