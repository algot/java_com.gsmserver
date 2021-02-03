package com.gsmserver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class BaseTest {
    static {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 500;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
