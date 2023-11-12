package guru.qa.tests;

import guru.qa.pages.BasketPage;
import guru.qa.pages.ItemPage;
import guru.qa.pages.MainPage;
import guru.qa.pages.SectionPage;
import guru.qa.utils.DataExtractor;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BasketTests extends TestBase {

    MainPage mainPage = new MainPage();
    SectionPage sectionPage = new SectionPage();
    ItemPage itemPage = new ItemPage();
    BasketPage basketPage = new BasketPage();
    DataExtractor dataExtractor = new DataExtractor();



    @ParameterizedTest(name = "Пользователь может добавить товар из раздела {0} в корзину")
    @ValueSource(
            strings = {"Дом", "Книги", "Игрушки", "Зоотовары", "Бытовая техника"})
    @Tag("basket")
    @Feature("Корзина")
    @Owner("jmalkova")
    void userCanAddItemToBasket(String sectionName) {

        mainPage
                .openMenu()
                .goToSection(sectionName);
        sectionPage
                .getBrandOfRandomItemCard(dataExtractor)
                .getPriceOfRandomItemCard(dataExtractor)
                .getLinkOfRandomItemCard(dataExtractor)
                .openRandomItemCard();
        itemPage
                .addItemToBasket()
                .goToBasket();
        basketPage
                .checkBasketPage(dataExtractor);
    }

    @ParameterizedTest(name = "Пользователь может удалить товар раздела {0} из корзины")
    @ValueSource(
            strings = {"Дом", "Книги", "Игрушки", "Зоотовары", "Бытовая техника"})
    @Tag("basket")
    @Feature("Корзина")
    @Owner("jmalkova")
    void userCanDeleteItemFromBasket(String sectionName) {

        mainPage
                .openMenu()
                .goToSection(sectionName);
        sectionPage
                .getBrandOfRandomItemCard(dataExtractor)
                .getPriceOfRandomItemCard(dataExtractor)
                .getLinkOfRandomItemCard(dataExtractor)
                .openRandomItemCard();
        itemPage
                .addItemToBasket()
                .goToBasket();
        basketPage
                .clickOnItemSection()
                .deleteItemFromBasket()
                .checkEmptyBasket();
    }
}