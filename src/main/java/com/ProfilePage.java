package com;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    // локатор кнопки "Выход"
    @FindBy(how = How.XPATH,using = "//button[text() = 'Выход']")
    private SelenideElement signOutButton;
    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH,using = "//p[text() = 'Конструктор']")
    private SelenideElement constructorButton;
    // локатор логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH,using = "//div/header/nav/div/a/svg")
    private SelenideElement logoStellarBurgers;

    // кликнуть "Выход", находясь на стартовой странице
    public LoginPage clickSignOut() {
        signOutButton.click();
        return page(LoginPage.class);
    }
    // кликнуть "Конструктор"
    public StartPage clickConstructorButton() {
        constructorButton.click();
        return page(StartPage.class);
    }

    // кликнуть "Stellar Burgers"
    public StartPage clickStellarBurgers() {
        constructorButton.click();
        return page(StartPage.class);
    }
}
