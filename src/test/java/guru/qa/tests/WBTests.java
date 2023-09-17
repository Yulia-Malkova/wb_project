package guru.qa.tests;

import com.codeborne.selenide.WebDriverRunner;
import guru.qa.data.Currency;
import guru.qa.pages.*;
import guru.qa.utils.Variables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
public class WBTests extends TestBase {

    Variables variables = new Variables();
    MainPage mainPage = new MainPage();
    SectionPage sectionPage = new SectionPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ItemPage itemPage = new ItemPage();
    SubMenuPage subMenuPage = new SubMenuPage();

    @DisplayName("Пользователь может найти товары через строку поиска")
    @Test()
    void userCanFindItemsUsingSearchField(){
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .clickSearchBar()
                .fillInSearchInput(variables.randomSearchInput);

        searchResultPage.checkResultPageTitle(variables.randomSearchInput);
    }

    @DisplayName("Пользователь может открыть чат поддержки")
    @Test
    void userCanOpenSupportChat(){
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .openSupportChat();
        mainPage
                .checkSupportChatWindow();
    }


    @ParameterizedTest(name = "Пользователь может поменять валюту на {0}")
    @EnumSource(Currency.class)
    void userCanChangeCurrency(Currency c) {
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .hoverOnCurrencyDropdown()
                .changeCurrency(c.getName())
                .waitUntilCurrencyDropdownLoads();

         mainPage
                 .checkCurrencyChange(c.toString());

    }
    @ParameterizedTest(name = "Пользователь может перейти в раздел {0} каталога через меню")
    @ValueSource(
           strings = {"Женщинам", "Обувь", "Детям", "Мужчинам", "Дом", "Красота", "Аксессуары", "Электроника", "Игрушки"}
    )
    void userCanNavigateToCatalogSectionViaMenu(String sectionName) {
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .openMenu()
                .clickOnSection(sectionName);

        sectionPage
                .checkSectionName(sectionName);
    }

    @DisplayName("Пользователь может открыть страницу товара")
    @Test()
    void userCanOpenItemCard(){
        mainPage
                .waitUntilCurrencyDropdownLoads()
                .openMenu()
                .clickOnSection("Игрушки");
        sectionPage
                .getPriceOfRandomItemCard()
                .getBrandOfRandomItemCard()
                .getNameOfRandomItemCard()
                .openRandomItemCard();
        itemPage
                .checkInformationOnItemPage();
    }

}
