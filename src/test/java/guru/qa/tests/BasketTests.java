package guru.qa.tests;

import guru.qa.pages.MainPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BasketTests extends TestBase {

    MainPage mainPage = new MainPage();



    @ParameterizedTest(name = "Пользователь может добавить товар из раздела {0} в корзину")
    @ValueSource(
            strings = {"Дом", "Книги", "Игрушки", "Зоотовары", "Бытовая техника"})
    @Tag("basket")
    void userCanAddItemToBasket(String sectionName) {

        mainPage
                .openMenu()
                .goToSection(sectionName)
                .getNameOfRandomItemCard()
                .getBrandOfRandomItemCard()
                .getPriceOfRandomItemCard()
                .getItemLink()
                .openRandomItemCard()
                .addItemToBasket()
                .goToBasket()
                .checkBasketPage();
    }

    @ParameterizedTest(name = "Пользователь может удалить товар раздела {0} из корзины")
    @ValueSource(
            strings = {"Дом", "Книги", "Игрушки", "Зоотовары", "Бытовая техника"})
    @Tag("basket")
    void userCanDeleteItemFromBasket(String sectionName) {

        mainPage
                .openMenu()
                .goToSection(sectionName)
                .getNameOfRandomItemCard()
                .getBrandOfRandomItemCard()
                .getPriceOfRandomItemCard()
                .getItemLink()
                .openRandomItemCard()
                .addItemToBasket()
                .goToBasket()
                .clickOnItemSection()
                .deleteItemFromBasket()
                .checkEmptyBasket();
    }
}