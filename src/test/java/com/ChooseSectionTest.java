package com;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.Base.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class ChooseSectionTest {
    @Test
    @DisplayName("Переход к разделам в конструкторе")
    public void checkSwitchSection() {
        // открыть стартовую страницу
        StartPage startPage = open(BASE_URL, StartPage.class);
        // перейти к разделу "Булки"
        startPage.chooseBuns();
        // проверить видимость перечня "Булки"
        startPage.isUserInTheBunsSection();
        // перейти к разделу "Соусы"
        startPage.chooseSauces();
        // проверить видимость перечня "Соусы"
        startPage.isUserInTheSaucesSection();
        // перейти к разделу "Начинки"
        startPage.chooseFillings();
        // проверить видимость перечня "Начинки"
        startPage.isUserInTheFillingsSection();
    }
}
