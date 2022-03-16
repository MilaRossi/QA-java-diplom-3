package com;
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
    @FindBy(how = How.XPATH,using = "//form/button")
    public SelenideElement signUp;
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

}
