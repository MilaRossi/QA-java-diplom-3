package com;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    // локатор поля "Имя"
    @FindBy(how = How.XPATH,using = "//form/fieldset[1]/div/div/input")
    private SelenideElement name;
    // локатор поля "Email"
    @FindBy(how = How.XPATH,using = "//form/fieldset[2]/div/div/input")
    private SelenideElement email;
    // локатор поля "Пароль"
    @FindBy(how = How.XPATH,using = "//form/fieldset[3]/div/div/input")
    private SelenideElement password;
    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = "//button[text() = 'Зарегистрироваться']")
    public SelenideElement signUp;
    // локатор ошибки "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "//p[text() = 'Некорректный пароль']")
    public SelenideElement incorrectPassword;
    // локатор кнопки "Войти" в форме авторизации
    @FindBy(how = How.XPATH,using = "//a[text() = 'Войти']")
    private SelenideElement signInLinkInAuthForm;

    // заполнить "Имя"
    public void setValueName(String value) {
        name.setValue(value);
    }
    // заполнить "Email"
    public void setValueEmail(String value) {
        email.setValue(value);
    }
    // заполнить "Пароль"
    public void setValuePassword(String value) {
        password.setValue(value);
    }
    // кликнуть по "Зарегистрироваться"
    public LoginPage clickSignUp() {
        signUp.click();
        return page(LoginPage.class);
    }
    // проверить видимость сообщения об ошибке "Некорректный пароль"
    public void shouldBeVisibleIncorrectPassword() {
        incorrectPassword.shouldBe(Condition.visible);
    }
    // кликнуть "Войти" в форме авторизации
    public LoginPage clickSignInButtonInAuthForm() {
        signInLinkInAuthForm.click();
        return page(LoginPage.class);
    }

}
