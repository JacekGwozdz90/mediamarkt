package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MediaMarkt {

    public ResultsPage searchFor(String searchText)
    {
        getSearch().setValue(searchText);
        getSearchButton().click();
        return new ResultsPage();
    }

    public SelenideElement getSearch()
    {
        return $("#query_querystring");
    }

    public SelenideElement getSearchButton()
    {
        return $(".m-search_submit");
    }

    public void clickCloseCookiePopupIfVisible(){
        SelenideElement closeCookie = $(".m-cookieInfo_confirm");
       if(closeCookie.isDisplayed())
           closeCookie.click();
    }
}
