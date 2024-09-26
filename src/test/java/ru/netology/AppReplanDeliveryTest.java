package ru.netology;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppReplanDeliveryTest {



    String secondDate = Generator.dataGenerate(5);
    String firstDate = Generator.dataGenerate(4);
    Faker faker = new Faker(new Locale("ru"));
    String city = Generator.city();


    @Test
    public void validTestAppReplanDelivery() {


        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue(city);
        $("[data-test-id=date] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(faker.name().fullName());
        $("[data-test-id=phone] input").setValue(faker.phoneNumber().phoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $(byText("Встреча запланирована на " + firstDate));
        $("[data-test-id=date] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id=date] input").setValue(secondDate);
        $(".button__content").click();
        $("[data-test-id=replan-notification]").shouldBe(visible);
        $("[data-test-id=replan-notification] .button__content").click();
        $(byText("У вас уже запланирована встреча на другую дату"));
        $(withText("Встреча забронирована на" + secondDate));
        $("[data-test-id=success-notification]").shouldBe(visible);

    }

}