package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private SelenideElement
            resultPageTitle = $(".searching-results__title");

    @Step("Проверяем, что заголовок страницы совпадает с названием выбранной секции")
    public void checkResultPageTitle(String searchInput) {

        resultPageTitle.shouldHave(text("По запросу «" + searchInput + "» найдено"));
    }
}
