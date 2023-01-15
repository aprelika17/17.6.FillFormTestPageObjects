package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String titleText = "Practice Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#gender-radio-1"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            userHobby = $("#hobbiesWrapper"),
            uploadFileButton = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            submitButton = $("#submit"),
            closeModalButton = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(Condition.text(titleText));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserGender() {
        userGender.parent().click();

        return this;
    }

    public RegistrationPage setUserBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.click();
        subject.sendKeys(value);
        subject.pressEnter();

        return this;
    }

    public RegistrationPage setUserHobby(String value) {
        userHobby.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile() {
        uploadFileButton.uploadFromClasspath("img/File.jpg");

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2) {
        userState.click();
        userState.$(byText(value1)).click();
        userCity.click();
        userCity.$(byText(value2)).click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }


    public RegistrationPage verifyResultsModalAppears(String value) {
        registrationResultsModal.verifyModalAppears(value);

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage pressCloseModal() {
        closeModalButton.click();

        return this;
    }
}
