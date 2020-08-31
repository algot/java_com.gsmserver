package com.gsmserver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {


    @Test
    void searchProductByTitle() {
        Configuration.browserSize = "1920x1080";
        clearBrowserCookies();
        open("https://gsmserver.com/");

        var productName = "Z3X Box Samsung Edition (without Cable Set)";
        var productId = "860455";

        $("[name='searchword']").val(productName).pressEnter();
        $(".search-title-highlight").shouldHave(text(productName));

        findProductById(productId).$(".product-info_title").shouldHave(text(productName));

        findProductById(productId).$("[data-action-click='site.cart.add']").click();
        findProductById(productId).$(".in-cart").click();

        $("#cart h1").shouldHave(text("Cart"));
        $$("#cart tr[data-product-id]").shouldHaveSize(1);
        findProductById(productId).$(".product-title").shouldHave(text(productName));
    }

    private SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }
}