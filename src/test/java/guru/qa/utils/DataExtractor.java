package guru.qa.utils;

public class DataExtractor {
    String itemLink;
    String itemPrice;
    String itemName;
    String itemBrand;
    public String getItemLink() {
        return itemLink;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }
}
