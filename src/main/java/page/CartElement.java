package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartElement {
    private final SelenideElement container;

    public CartElement(SelenideElement container)
    {
        this.container = container;
    }

    public SelenideElement getProductName(){
        return container.$(".m-cartList_itemProductName a");
    }

    public SelenideElement getPrice(){
        return container.$(".m-cartList_itemPriceValue");
    }

    public SelenideElement getCounter(){
        return container.$(".js-cart-item-change-quantity-input");
    }

    public SelenideElement getTotalPrice(){
        return container.$(".js-totalItemPrice");
    }

    public SelenideElement getIncreaseButton(){
        return container.$(".m-cartList_itemPlus");
    }

    public SelenideElement getDecreaseButton(){
        return container.$(".m-cartList_itemMinus");
    }

    public SelenideElement getRemoveButton(){
        return container.$(".js-cart-list-del");
    }
}
