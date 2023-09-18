package guru.qa.data;

public enum SearchInputs {

    JEANS("Джинсы"),
    SCALES("Весы"),
    SHOVEL("Лопата"),
    MIRROR("Зеркало"),
    JUICE("Сок"),
    RAZOR("Бритва"),
    CREAM("Крем"),
    BLANKET("Одеяло"),
    NOTEBOOK("Тетрадь"),
    BAG("Сумка"),
    IRON("Утюг"),
    TOY("Игрушка"),
    CUP("Чашка"),
    HAT("Шляпа"),
    CAT_FOOD("Кошачий корм"),
    HEADPHONES("Наушники"),
    POSTER("Постер"),
    ARMCHAIR("Садовое кресло"),
    PERFUME("Туалетная вода"),
    BOAT("Надувная лодка");

    private final String name;
    SearchInputs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

}
