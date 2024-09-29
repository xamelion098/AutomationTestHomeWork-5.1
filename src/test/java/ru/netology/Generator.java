package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class Generator {


    static Faker faker = new Faker();

    public static String name() {
        Faker faker = new Faker(new Locale("ru"));

        String fullName = faker.name().fullName();
        return fullName;
    }

    public static String phone() {
        Faker faker = new Faker(new Locale("ru"));

        String PhoneClient = faker.name().fullName();
        return PhoneClient;
    }

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