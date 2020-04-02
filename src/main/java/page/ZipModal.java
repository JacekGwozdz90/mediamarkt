package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ZipModal {

    public SelenideElement getContainer() {
        return $(".js-postcode-form-content");
    }

    public SelenideElement getZipCodeInput() {
        return getContainer().$("#enp_cart_postcode_type_postcode");
    }

    public SelenideElement getSaveButton(){
        return getContainer().$("#js-postcode-submit");
    }

    public void fillForm(String zipCode){
        getZipCodeInput().sendKeys(zipCode);
        getSaveButton().click();
    }

    public void isNotVisible() {
        getContainer().is(not(visible));
    }
}
