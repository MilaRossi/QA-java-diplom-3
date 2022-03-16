package com;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class StartPage {
    // локатор линктекста "Личный Кабинет"
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    public SelenideElement userProfile;
    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.CLASS_NAME,using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg")
    public SelenideElement userLogin;
    // локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = "//div/main/section[2]/div/button")
    private SelenideElement makeOrderButton;
    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = "//div/main/section[2]/div/button")
    private SelenideElement signInButton;
    // кликнуть "Личный Кабинет"
    public LoginPage clickUserProfile() {
        userProfile.click();
        return page(LoginPage.class);
    }
    // проверить видимость кнопки "Оформить заказ"
    public void shouldBeVisibleMakeOrderButton() {
        makeOrderButton.shouldBe(Condition.visible);
    }
    // кликнуть "Войти в аккаунт"
    public LoginPage clickSignInButton() {
        signInButton.click();
        return page(LoginPage.class);
    }

























}
