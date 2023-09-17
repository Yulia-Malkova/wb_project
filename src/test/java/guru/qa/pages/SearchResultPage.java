package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private SelenideElement
        resultPageTitle = $(".searching-results__title");

    public void checkResultPageTitle(String searchInput){
        resultPageTitle.shouldHave(text("По запросу «"+searchInput+"» найдено"));
    }

}
