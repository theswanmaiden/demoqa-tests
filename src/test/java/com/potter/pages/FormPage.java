package com.potter.pages;

import com.codeborne.selenide.SelenideElement;
import com.potter.pages.components.Calendar;
import com.potter.test.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userAddress = $("#currentAddress"),
            userNumber = $("#userNumber"),
            femaleRadio = $(".custom-control-label[for='gender-radio-2']"),
            subjectInput = $("#subjectsInput"),
            musicCheckbox = $(".custom-control-label[for='hobbies-checkbox-3']"),
            uploadPicture = $("#uploadPicture"),
            stateField = $("#react-select-3-input"),
            cityField = $("#react-select-4-input"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            responseTable = $(".table-responsive");
    private final String URL = "/automation-practice-form";

    private Calendar calendar = new Calendar();

    public FormPage openPage() {
        open(URL);
        return this;
    }

    public FormPage fillName(String value) {
        firstName.setValue(value);
        return this;
    }

    public FormPage fillLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public FormPage fillCalendar(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public FormPage fillUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public FormPage fillUserAddress(String address) {
        userAddress.setValue(address);
        return this;
    }

    public FormPage fillUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public FormPage femaleSelect() {
        femaleRadio.click();
        return this;
    }

    public FormPage fillSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public FormPage selectMusicCheckbox() {
        musicCheckbox.click();
        return this;
    }

    public FormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public FormPage fillState(String value) {
        stateField.setValue(value).pressEnter();
        return this;
    }

    public FormPage fillCity(String value) {
        cityField.setValue(value).pressEnter().pressEnter();
        return this;
    }

    public void checkForm() {
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        responseTable.shouldHave(text(TestData.firstName + " " + TestData.lastName));
    }
}
