package quru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    String firstName = "Sophie";
    String lastName = "Potter";
    String userEmail = "sophie.potter@test.ru";
    String userNumber = "9123456789";
    String currentAddress = "address 1";
        @BeforeAll
        static void beforeAll() {

            Configuration.pageLoadTimeout = 60000;
            open("https://demoqa.com/automation-practice-form");
        }

        @Test
        void fillFormTest() {

            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#userNumber").setValue(userNumber);
            $(".custom-control-label[for='gender-radio-2']").click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("11");
            $(".react-datepicker__year-select").selectOptionByValue("1997");
            $(".react-datepicker__day.react-datepicker__day--014.react-datepicker__day--weekend").click();
            $("#subjectsInput").setValue("Computer Science").pressEnter();
            $(".custom-control-label[for='hobbies-checkbox-3']").click();
            $("#uploadPicture").uploadFromClasspath("photo.webp");
            $("#currentAddress").setValue(currentAddress);
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#react-select-4-input").setValue("Delhi").pressEnter().pressEnter();

            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        }


    }


