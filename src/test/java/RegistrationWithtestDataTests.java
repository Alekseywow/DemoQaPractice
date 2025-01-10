import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithtestDataTests {

//    static String firstName,
//            lastName,
//            userEmail;


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

//    @BeforeEach
//    void prepareTestData(){
//        firstName = "Aleksey";
//        lastName = "Danilov";
//        userEmail = "danilov@mail.ru";
//    }


    @Test
    void fillFormTest () {
//        String firstName = "Aleksey",
//                lastName = "Danilov",
//                userEmail = "danilov@mail.ru";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Aleksey");
        $("#lastName").setValue("Danilov");
        $("#userEmail").setValue("mail@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8900112233");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1994");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("26")).click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("Cat.png");

        $("#currentAddress").setValue("INDIA");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Aleksey Danilov"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("mail@mail.ru"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8900112233"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("26 September,1994"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("Cat.png"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("INDIA"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Karnal"));
    }
}
