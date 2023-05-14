package quru.qa.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.FormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormTest {
    private FormPage formPage = new FormPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadTimeout = 60000;

    }

    @Test
    void fillFormTest() {
        formPage.openPage()
                .fillName(TestData.firstName)
                .fillLastName(TestData.lastName)
                .fillCalendar(TestData.day, TestData.month, TestData.year)
                .fillUserEmail(faker.internet().emailAddress())
                .fillUserAddress(TestData.currentAddress)
                .fillUserNumber(faker.phoneNumber().subscriberNumber(10));
        $(".custom-control-label[for='gender-radio-2']").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(".custom-control-label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("photo.webp");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter().pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(TestData.firstName + " " + TestData.lastName));
    }

}


