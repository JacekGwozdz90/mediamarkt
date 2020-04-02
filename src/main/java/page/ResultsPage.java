package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class ResultsPage {
    public SelenideElement getSearchHeader() {
        return $(".b-listing_categoryTitle");
    }

    public int getNumberOfResultsFromHeader() {
        return Integer.parseInt(getSearchHeader().$("span").getText().replace("(","").replace(")",""));
    }

    public List<SearchResult> getResults() {
        return $$(".m-offerBox").stream()
                .map(SearchResult::new)
                .collect(toList());
    }

    public int getNumberOfResultsOnSinglePage() {
        return Integer.parseInt($(".selectric-js-showProductsOnPage").$(By.xpath(".//option[@selected = 'selected']")).getValue());
    }
}
