package guru.qa.tests;

import guru.qa.data.Currency;
import guru.qa.pages.ItemPage;
import guru.qa.pages.MainPage;
import guru.qa.pages.SearchResultPage;
import guru.qa.pages.SectionPage;
import guru.qa.utils.DataExtractor;
import guru.qa.utils.Variables;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BasicTests extends TestBase {

    Variables variables = new Variables();
    DataExtractor dataExtractor = new DataExtractor();
    MainPage mainPage = new MainPage();
    ItemPage itemPage = new ItemPage();
    SectionPage sectionPage = new SectionPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @DisplayName("Пользователь может найти товары через строку поиска")
    @Test()
    @Feature("Поиск")
    @Owner("jmalkova")
    void userCanFindItemsUsingSearchField() {

        mainPage
                .clickSearchBar()
                .fillInSearchInput(variables.randomSearchInput);
        searchResultPage
                .checkResultPageTitle(variables.randomSearchInput);
    }

    @DisplayName("Пользователь может открыть чат поддержки")
    @Test
    @Feature("Чат поддержки")
    @Owner("jmalkova")
    void userCanOpenSupportChat() {
        mainPage
                .openSupportChat()
                .checkSupportChatWindow();
    }

    @ParameterizedTest(name = "Пользователь может поменять валюту на {0}")
    @EnumSource(Currency.class)
    @Feature("Смена валюты")
    @Owner("jmalkova")
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
    @Feature("Карточка товара")
    @Owner("jmalkova")
    void userCanOpenItemCard() {

        mainPage
                .openMenu()
                .goToFinalSection();
        sectionPage
                .getBrandOfRandomItemCard(dataExtractor)
                .getPriceOfRandomItemCard(dataExtractor)
                .getLinkOfRandomItemCard(dataExtractor)
                .openRandomItemCard();
        itemPage
                .checkInformationOnItemPage(dataExtractor);
    }
}
