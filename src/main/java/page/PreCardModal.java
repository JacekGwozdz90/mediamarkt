package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PreCardModal {
    public SelenideElement getContainer() {
        return $("#js-preCart");
    }

    public CartPage selectBasicService() {
        getSelectService().click();
        return new CartPage();
    }

    public SelenideElement getSelectService() {
        return getContainer().$x(".//label[contains(@class,'m-servicesPopup_add') and @for='servicePrecartEmpty']");
    }
}
