package page;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class CartPage {
    public List<CartElement> getCardItems()
    {
        return $$(".js-itemDataLayerInfo ").stream()
                .map(CartElement::new)
                .collect(toList());
    }
}
