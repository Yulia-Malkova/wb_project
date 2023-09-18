package guru.qa.utils;

import com.github.javafaker.Faker;

public class FakerGenerator {
    Faker faker = new Faker();

    public int getRandomNumberForItemCard() {

        return faker.number().numberBetween(0, 9);
    }

}
