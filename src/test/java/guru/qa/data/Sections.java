package guru.qa.data;

public enum Sections {
    WOMEN("Женщинам"),
    SHOES("Обувь"),
    CHILDREN("Детям"),
    MEN("Мужчинам"),
    HOUSE("Дом"),
    BEAUTY("Красота"),
    ACCESSORIES("Аксессуары"),
    ELECTRONICS("Электроника"),
    TOYS("Игрушки"),
    FOOD("Продукты"),
    TECHNIC("Бытовая техника"),
    ZOO("Зоотовары"),
    SPORT("Спорт"),
    AUTO("Автотовары"),
    SCHOOL("Школа"),
    BOOKS("Книги"),
    REPARATION("Для ремонта"),
    HEALTH("Здоровье"),
    STATIONERY("Канцтовары");

    private final String name;

    Sections(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
