package quru.com.potter.pages;

import com.codeborne.selenide.SelenideElement;
import quru.com.potter.pages.components.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userAddress = $("#currentAddress"),
            userNumber = $("#userNumber");

    private Calendar calendar = new Calendar();

    public FormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
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

    public FormPage fillUserNumber(String number){
        userNumber.setValue(number);
        return this;
    }

}
