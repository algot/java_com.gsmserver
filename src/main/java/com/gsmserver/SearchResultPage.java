package com.gsmserver;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    @Step
    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();
    }
}
