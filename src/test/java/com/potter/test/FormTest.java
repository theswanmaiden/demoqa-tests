package com.potter.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import com.potter.pages.FormPage;

import static com.codeborne.selenide.Selenide.$;

public class FormTest {
    private FormPage formPage = new FormPage();
    Faker faker = new Faker();

    @Test
    void fillFormTest() {
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
    }
}
