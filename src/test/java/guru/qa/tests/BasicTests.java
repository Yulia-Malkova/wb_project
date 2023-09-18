package guru.qa.tests;

import guru.qa.data.Currency;
import guru.qa.pages.MainPage;
import guru.qa.utils.Variables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BasicTests extends TestBase {

    Variables variables = new Variables();
    MainPage mainPage = new MainPage();

    @DisplayName("Пользователь может найти товары через строку поиска")
    @Test()
    void userCanFindItemsUsingSearchField() {

        mainPage
                .clickSearchBar()
                .fillInSearchInput(variables.randomSearchInput)
                .checkResultPageTitle(variables.randomSearchInput);
    }

    @DisplayName("Пользователь может открыть чат поддержки")
    @Test
    void userCanOpenSupportChat() {

        mainPage
                .openSupportChat()
                .checkSupportChatWindow();
    }

    @ParameterizedTest(name = "Пользователь может поменять валюту на {0}")
    @EnumSource(Currency.class)
    void userCanChangeCurrency(Currency c) {

        mainPage
                .waitUntilCurrencyDropdownLoads()
                .hoverOnCurrencyDropdown()
                .changeCurrency(c.getName())
                .waitUntilCurrencyDropdownLoads()
                .checkCurrencyChange(c.toString());
    }

    @DisplayName("Пользователь может открыть страницу товара")
    @Test
    void userCanOpenItemCard() {

        mainPage
                .openMenu()
                .goToFinalSection()
                .getNameOfRandomItemCard()
                .getBrandOfRandomItemCard()
                .getPriceOfRandomItemCard()
                .getItemLink()
                .openRandomItemCard()
                .checkInformationOnItemPage();
    }
}
