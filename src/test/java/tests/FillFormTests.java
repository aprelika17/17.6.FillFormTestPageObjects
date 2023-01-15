package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class FillFormTests extends TestBase {

    @Test
    void fillFormSuccess() {
        //Переменные
        String firstName = "Иван";
        String lastName = "Гуру";
        String userEmail = "ivan_quru@gmail.com";
        String gender = "Male";
        String userNumber = "9505555555";
        String month = "May";
        String year = "1970";
        String day = "5";
        String subject = "Hindi";
        String hobby = "Sports";
        String currentAddress = "г.Первый ул.Вторая д.1 кв. 2";
        String state = "Haryana";
        String city = "Karnal";
        String happyText = "Thanks for submitting the form";

        //Старт теста
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender()
                .setUserNumber(userNumber)
                .setUserBirthDate(day, month, year)
                .setSubject(subject)
                .setUserHobby(hobby)
                .uploadFile()
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .pressSubmit();

        //Проверки
        registrationPage.verifyResultsModalAppears(happyText)
                .verifyResult("Student Name", (firstName + " " + lastName))
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", "05 May,1970")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "File.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", (state + " " + city));

        //Закрыть модалку
        registrationPage.pressCloseModal();
    }
}
