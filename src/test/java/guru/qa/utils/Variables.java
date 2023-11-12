package guru.qa.utils;

import guru.qa.data.SearchInputs;
import guru.qa.data.Sections;

public class Variables {
    FakerGenerator fakerGenerator = new FakerGenerator();

    RandomEnumGenerator randomEnumGeneratorSearch = new RandomEnumGenerator(SearchInputs.class);
    SearchInputs searchInputs = (SearchInputs) randomEnumGeneratorSearch.randomEnum();
    public String randomSearchInput = searchInputs.getName();

    public int itemCardNumber = fakerGenerator.getRandomNumberForItemCard();

    RandomEnumGenerator randomEnumGeneratorSection = new RandomEnumGenerator(Sections.class);
    Sections sections = (Sections) randomEnumGeneratorSection.randomEnum();
    public String randomSection = sections.getName();
}
