package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.DataExtractor;
import guru.qa.utils.Variables;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SectionPage {

    Variables variables = new Variables();
    private final SelenideElement
    sectionTitle = $(".catalog-title"),
    goodsCounter =$(".goods-count"),
    randomItemCard = $$(".product-card__wrapper").get(variables.itemCardNumber),
    itemPriceElement = randomItemCard.$(".price__lower-price"),
    itemBrandElement = randomItemCard.$(".product-card__brand"),
    itemLinkElement = randomItemCard.$(".product-card__link");


    @Step("Получаем цену случайного товара")
    public SectionPage getPriceOfRandomItemCard(DataExtractor dataExtractor) {
        dataExtractor.setItemPrice(itemPriceElement.getText());
        return this;
    }

    @Step("Получаем производителя случайного товара")
    public SectionPage getBrandOfRandomItemCard(DataExtractor dataExtractor) {
        waitUntilFilterLoads();
        dataExtractor.setItemBrand(itemBrandElement.getText());
        return this;
    }

    @Step("Получаем ссылку на случайный товар")
    public SectionPage getLinkOfRandomItemCard(DataExtractor dataExtractor) {
        dataExtractor.setItemLink(itemLinkElement.getAttribute("href"));
        return this;
    }

    @Step("Открываем случайный товар")
    public void openRandomItemCard() {

        randomItemCard.click();
    }

    @Step("Проверяем название секции")
    public void checkSectionName(String sectionName) {

        sectionTitle.shouldHave(Condition.text(sectionName));
    }

    @Step("Проверяем, что карточки товара загрузились")
    public SectionPage waitUntilFilterLoads() {

        goodsCounter.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }
}
