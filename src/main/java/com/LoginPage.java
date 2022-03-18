package com;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
public class LoginPage {
    // локатор ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = "//a[text() = 'Зарегистрироваться']")
    public SelenideElement userRegister;
    // локатор поля "Email"
    @FindBy(how = How.XPATH,using = "//form/fieldset[1]/div/div/input")
    private SelenideElement email;
    // локатор поля "Пароль"
    @FindBy(how = How.XPATH,using = "//form/fieldset[2]/div/div/input")
    private SelenideElement password;
    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = "//button[text() = 'Войти']")
    private SelenideElement loginButton;
    // локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH,using = "//a[text() = 'Восстановить пароль']")
    private SelenideElement resetPassword;
    // локатор текста "Восстановление пароля"
    @FindBy(how = How.XPATH,using = "//h2[text() = 'Восстановление пароля']")
    private SelenideElement textResetPassword;

    // кликнуть "Зарегистрироваться"
    public RegisterPage clickUserLogin() {
        userRegister.click();
        return page(RegisterPage.class);
    }
    // заполнить форму логина
    public void fillLoginForm(String email, String password) {
        this.email.setValue(email);
        this.password.setValue(password);
    }
    // кликнуть "Войти"
    public StartPage clickLoginButton() {
        loginButton.click();
        return page(StartPage.class);
    }
    // проверить видимость поля "Email"
    public void shouldBeVisibleInputEmail() {
        email.shouldBe(Condition.visible);
    }
    // кликнуть "Восстановить пароль"
    public void clickResetPassword() {
        resetPassword.click();
    }
    // проверить видимость текста "Восстановить пароль"
    public void shouldBeVisibleTextResetPassword() {
        textResetPassword.shouldHave(text("Восстановление пароля"));
    }


}
