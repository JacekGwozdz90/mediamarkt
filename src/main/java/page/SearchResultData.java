package page;

import java.util.Locale;

public class SearchResultData {
    private String name;
    private String price;

    private SearchResultData(){
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder{
        private String name;
        private String price;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public SearchResultData build() {
            SearchResultData data = new SearchResultData();
            data.name=name;
            data.price = price;
            return data;
        }
    }
}
