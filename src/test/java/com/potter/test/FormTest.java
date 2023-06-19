package com.potter.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.potter.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.potter.pages.FormPage;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;

public class FormTest {
    private FormPage formPage = new FormPage();
    Faker faker = new Faker();

    @Test
    void fillFormTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.pageLoadTimeout=60000;
        Configuration.baseUrl = "https://demoqa.com";

        formPage.openPage()
                .fillName(TestData.firstName)
                .fillLastName(TestData.lastName)
                .fillCalendar(TestData.day, TestData.month, TestData.year)
                .fillUserEmail(faker.internet().emailAddress())
                .fillUserAddress(TestData.currentAddress)
                .fillUserNumber(faker.phoneNumber().subscriberNumber(10))
                .femaleSelect()
                .fillSubject("Computer Science")
                .selectMusicCheckbox()
                .uploadPicture("photo.webp")
                .fillState("NCR")
                .fillCity("Delhi")
                .checkForm();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
