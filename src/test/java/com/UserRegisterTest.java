package com;
import com.model.User;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class UserRegisterTest {
    public static final String EMAIL_POSTFIX = "@yandex.ru";

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void signIn() {
        // открыть стартовую страницу
        StartPage startPage =
                open("https://stellarburgers.nomoreparties.site",
                        StartPage.class);

        // кликнуть "Войти в аккаунт" и перейти на страницу логина пользователя
        LoginPage loginPage = startPage.clickSignInButton();
        // проверить видимость поля "Email"
        loginPage.shouldBeVisibleInputEmail();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void signInInAuthForm() {
        // открыть стартовую страницу
        StartPage startPage =
                open("https://stellarburgers.nomoreparties.site",
                        StartPage.class);
        // создать объект класса LoginPage, кликнуть на стартовой странице по "Личный Кабинет"
        LoginPage loginPage = startPage.clickUserProfile();
        // создать объект класса RegisterPage, кликнуть на логин странице по "Зарегистрироваться"
        RegisterPage registerPage = loginPage.clickUserLogin();
        // кликнуть "Войти" в форме авторизации и перейти на страницу логина пользователя
        LoginPage loginPageNext = registerPage.clickSignInButtonInAuthForm();
        // проверить видимость поля "Email"
        loginPageNext.shouldBeVisibleInputEmail();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void signInWithinResetPassword() {
        // открыть стартовую страницу
        StartPage startPage =
                open("https://stellarburgers.nomoreparties.site",
                        StartPage.class);
        // создать объект класса LoginPage, кликнуть на стартовой странице по "Личный Кабинет"
        LoginPage loginPage = startPage.clickUserProfile();
        // кликнуть "Восстановить пароль"
        loginPage.clickResetPassword();
        // проверить на странице видимость текста "Восстановить пароль"
        loginPage.shouldBeVisibleTextResetPassword();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void registerUser() {
        // открыть стартовую страницу
        StartPage startPage =
                open("https://stellarburgers.nomoreparties.site",
                        StartPage.class);
        // создать объект класса LoginPage, кликнуть на стартовой странице по "Личный Кабинет"
        LoginPage loginPage = startPage.clickUserProfile();
        // создать объект класса RegisterPage, кликнуть на логин странице по "Зарегистрироваться"
        RegisterPage registerPage = loginPage.clickUserLogin();
        // создать пользователя
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setEmail(RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX);
        user.setPassword(RandomStringUtils.randomAlphabetic(10));
        // заполнить "Имя"
        registerPage.setValueName(user.getName());
        // заполнить "Email"
        registerPage.setValueEmail(user.getEmail());
        // заполнить "Пароль"
        registerPage.setValuePassword(user.getPassword());
        // кликнуть  "Зарегистрироваться" и перейти к форме заполнения
        LoginPage loginPageAfterRegister = registerPage.clickSignUp();
        // заполнить форму
        loginPageAfterRegister.fillLoginForm(user.getEmail(), user.getPassword());
        // кликнуть "Войти" и перейти на стартовую страницу
        StartPage startPageAfterLogin = loginPageAfterRegister.clickLoginButton();
        // проверить видимость кнопки "Оформить заказ"
        startPageAfterLogin.shouldBeVisibleMakeOrderButton();
        // перейти в личный кабинет
        ProfilePage profilePage = startPage.clickAuthUserProfile();
        // кликнуть выход и перейти к логину
        profilePage.clickSignOut();
        loginPage.shouldBeVisibleResetPassword();

    }
}