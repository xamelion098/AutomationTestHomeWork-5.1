package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AppReplanDeliveryTest {


    String secondDate = Generator.dataGenerate(5);
    String firstDate = Generator.dataGenerate(4);

    String city = Generator.city();
    String phone = Generator.phone();
    String fullName = Generator.name();

    @Test
    public void validTestAppReplanDelivery() {


        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue(city);
        $("[data-test-id=date] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(fullName);
        $("[data-test-id=phone] input").setValue(phone);
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=success-notification]").shouldHave(text("Встреча успешно запланирована на " + firstDate))
                .shouldBe(visible);
        $("[data-test-id=date] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id=date] input").setValue(secondDate);
        $(".button__content").click();
        $(withText("У вас уже запланирована встреча на другую дату.")).shouldBe(visible);
        $("[data-test-id=replan-notification] .button__content").click();
        $("[data-test-id=success-notification] .notification__content")
                .shouldBe(exactText("Встреча успешно запланирована на " + secondDate) , (visible));
    }
}