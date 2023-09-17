package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.Variables;

import static com.codeborne.selenide.Selenide.$$;

public class SubMenuPage {

    Variables variables = new Variables();

   private ElementsCollection
            subSectionPhoto = $$(".j-banner-wba");

    public void openRandomSubSection(){
        subSectionPhoto.get(4).click();}


}
