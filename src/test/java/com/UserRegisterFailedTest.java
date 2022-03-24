package com;
import com.model.User;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.Base.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class UserRegisterFailedTest {
    public static final String EMAIL_POSTFIX = "@yandex.ru";
    @Test
    @DisplayName("Получить ошибку регистрации пользователя с паролем короче 6 символов")
    public void registerUser() {
        // открыть стартовую страницу
        StartPage startPage = open(BASE_URL, StartPage.class);
        // создать объект класса LoginPage, кликнуть на стартовой странице по "Личный Кабинет"
        LoginPage loginPage = startPage.clickUserProfile();
        // создать объект класса RegisterPage, кликнуть на логин странице по "Зарегистрироваться"
        RegisterPage registerPage = loginPage.clickUserLogin();
        // создать пользователя
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setEmail(RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX);
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        // заполнить "Имя"
        registerPage.setValueName(user.getName());
        // заполнить "Email"
        registerPage.setValueEmail(user.getEmail());
        // заполнить "Пароль"
        registerPage.setValuePassword(user.getPassword());
        // кликнуть "Зарегистрироваться"
        registerPage.clickSignUp();
        // проверить видимость
        registerPage.shouldBeVisibleIncorrectPassword();
    }

}
