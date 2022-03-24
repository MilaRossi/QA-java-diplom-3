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
    // локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = "//button[text() = 'Оформить заказ']")
    private SelenideElement makeOrderButton;
    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = "//button[text() = 'Войти в аккаунт']")
    private SelenideElement signInButton;
    // локатор секции Булки/Соусы/Начинки
    @FindBy(how = How.XPATH,using = "//div/main/section[1]/div[1]")
    private SelenideElement topSection;
    // локатор раздела "Булки"
    @FindBy(how = How.XPATH,using = "//span[text() = 'Булки']")
    private SelenideElement bunsSection;
    // локатор раздела "Соусы"
    @FindBy(how = How.XPATH,using = "//span[text() = 'Соусы']")
    private SelenideElement saucesSection;
    // локатор раздела "Начинки"
    @FindBy(how = How.XPATH,using = "//span[text() = 'Начинки']")
    private SelenideElement fillingsSection;
    // локатор перечня "Булки"
    @FindBy(how = How.XPATH,using = "//h2[text() = 'Булки']")
    private SelenideElement buns;
//    // локатор перечня "Соусы"
//    @FindBy(how = How.XPATH,using = "//h2[text() = 'Соусы']")
//    private SelenideElement sauces;
//    // локатор перечня "Начинки"
//    @FindBy(how = How.XPATH,using = "//h2[text() = 'Начинки']")
//    private SelenideElement fillings;

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
    // кликнуть "Личный Кабинет", находясь на стартовой странице
    public ProfilePage clickAuthUserProfile() {
        userProfile.click();
        return page(ProfilePage.class);
    }
    // перейти к разделу "Булки"
    public void chooseBuns() {
        bunsSection.hover();
        topSection.click();
    }
    // перейти к разделу "Соусы"
    public void chooseSauces() {
        saucesSection.hover();
        topSection.click();
    }
    // перейти к разделу "Начинки"
    public void chooseFillings() {
        fillingsSection.hover();
        topSection.click();
    }

    public void isUserInTheBunsSection() {
        bunsSection.getAttribute("class").contains("text_type_main-default");
    }

    // проверить видимость перечня "Соусы"
    public void isUserInTheSaucesSection() {
        saucesSection.getAttribute("class").contains("text_type_main-default");
    }

    // проверить видимость перечня "Начинки"
    public void isUserInTheFillingsSection() {
        fillingsSection.getAttribute("class").contains("text_type_main-default");
    }

}
