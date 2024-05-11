
package ru.netology.delivery.data;
import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM."));
    }

    public static String generateCity() {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        var cities = new String[]{"Москва", "Новосибирск", "Санкт-Петербург", "Санкт-Петербург",
                "Нижний Новгород", "Казань", "Самара", "Челябинск", "Омск", "Ростов-на-Дону", "Уфа",
                "Красноярск", "Пермь", "Волгоград", "Воронеж", "Саратов", "Краснодар", "Тольятти",
                "Тюмень", "Ижевск", "Барнаул", "Ульяновск", "Иркутск", "Владивосток", "Ярославль",
                "Хабаровск", "Махачкала", "Оренбург", "Томск", "Новокузнецк", "Кемерово", "Астрахань",
                "Рязань", "Набережные Челны", "Пенза", "Липецк", "Тула", "Киров", "Чебоксары",
                "Калининград", "Курск", "Улан-Удэ", "Ставрополь", "Магнитогорск", "Тверь", "Иваново",
                "Брянск", "Сочи", "Белгород", "Сургут"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();

    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}