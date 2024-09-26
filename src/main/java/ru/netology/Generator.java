package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Generator {

    Faker faker = new Faker();

    String name = faker.name().fullName(); // Miss Samanta Schmidt
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton

    public static String city() {
        List<String> list = Arrays.asList("Волгоград", "Владивосток", "Владимир", "Вологда", "Рязань",
                "Чебоксары", "Москва", "Санкт-Петербург", "Симферополь", "Ростов-на-Дону");
        Random rand = new Random();
        String city = list.get(rand.nextInt(list.size()));
        return city;
    }

    public static String dataGenerate(int step) {
        String date = LocalDate.now().plusDays(step).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
    }
}