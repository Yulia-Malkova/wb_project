package guru.qa.tests;

import guru.qa.pages.MainPage;
import guru.qa.pages.SectionPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CatalogTests extends TestBase {
    MainPage mainPage = new MainPage();
    SectionPage sectionPage = new SectionPage();

    @ParameterizedTest(name = "Пользователь может перейти в раздел {0} каталога через меню")
    @ValueSource(
            strings = {"Женщинам", "Обувь", "Мужчинам", "Дом", "Красота"}
    )
    @Tag("catalog")
    @Feature("Каталог")
    @Owner("jmalkova")
    void userCanNavigateToCatalogSectionViaMenu(String sectionName) {

        mainPage
                .openMenu()
                .clickOnSection(sectionName);
        sectionPage
                .checkSectionName(sectionName);
    }

    @ParameterizedTest(name = "Раздел каталога {0} содержит подраздел {1}")
    @CsvFileSource(resources = "/catalogSection.csv")
    @Tag("catalog")
    @Feature("Каталог")
    @Owner("jmalkova")
    void catalogSectionContainsSubsection(String sectionName, String subSectionName) {

        mainPage
                .openMenu()
                .hoverOnSection(sectionName)
                .checkSubsectionNameInChosenSection(subSectionName);
    }
}
