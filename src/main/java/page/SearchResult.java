package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.text.MatchesPattern;

import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.codeborne.selenide.Condition.*;
import static java.util.stream.Collectors.joining;

public class SearchResult {
    private SelenideElement container;

    public SearchResult(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement getHeader() {
        return container.$(".m-offerBox_headline");
    }

    public String getPrice(){
        return container.$(".m-priceBox_price").$$("span").stream()
                .map(SelenideElement::text)
                .collect(joining());
    }

    public SelenideElement getBuyNowButton(){
        return container.$(".m-offerBox_basket");
    }

    public PreCardModal addToBasket(){
        getBuyNowButton().click();
        return new PreCardModal();
    }

    public void validateResultHasAllRequiredElements()
    {
        getHeader().should(appear);
        assertThat("Price does not match pattern", getPrice(), MatchesPattern.matchesPattern("[0-9]+((,[0-9]{2})|,-)"));
        getBuyNowButton().should(appear, exactTextCaseSensitive("Kup teraz"));
    }

    public SearchResultData getData() {
        return new SearchResultData.Builder()
                .setName(getHeader().text())
                .setPrice(getPrice())
                .build();
    }
}
