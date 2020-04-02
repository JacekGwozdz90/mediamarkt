package test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.*;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediaMarktSearchTest {

    MediaMarkt mediaMarkt;


    @BeforeEach
    void prepare() {
        mediaMarkt = open("https://mediamarkt.pl", MediaMarkt.class);
    }

    @Test
    void searchNavigatesToOtherPage() {
        String searchText = "macbook pro";
        ResultsPage resultsPage = mediaMarkt.searchFor(searchText);
        resultsPage.getSearchHeader().shouldHave(text(searchText));
        resultsPage.getResults().stream()
                .forEach(result -> validateResultRow(result, searchText));
        assertEquals(Math.min(resultsPage.getNumberOfResultsFromHeader(), resultsPage.getNumberOfResultsOnSinglePage()),
                resultsPage.getResults().size(),
                "Results had not the same number of results as min of number from header and number of elements displayed on single results page");
    }


    @Test
    void testAddingToBasket()
    {
        String searchText = "macbook pro";
        ResultsPage resultsPage = mediaMarkt.searchFor(searchText);
        resultsPage.getSearchHeader().shouldHave(text(searchText));
        SearchResult result = resultsPage.getResults().get(new Random().nextInt(resultsPage.getResults().size()));
        SearchResultData resultData = result.getData();
        mediaMarkt.clickCloseCookiePopupIfVisible();
        PreCardModal preCardModal = result.addToBasket();
        fillZipModal();
        CartPage cartPage = preCardModal.selectBasicService();
        CartElement cardElement = cartPage.getCardItems().get(0);
        cardElement.getPrice().has(exactText(resultData.getPrice()));
        cardElement.getCounter().has(exactValue("1"));
        cardElement.getProductName().has(exactText(resultData.getName()));
    }

    private void fillZipModal() {
        ZipModal zipModal = new ZipModal();
        zipModal.fillForm("30303");
        zipModal.isNotVisible();
    }

    private void validateResultRow(SearchResult searchResult, String searchText){
        searchResult.validateResultHasAllRequiredElements();
        searchResult.getHeader().shouldHave(text(searchText));
    }

}
