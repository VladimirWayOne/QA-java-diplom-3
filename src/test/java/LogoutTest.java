import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.PasswordRecoverPage;

import static constants.Urls.LOGIN_PAGE_URL;

public class LogoutTest extends BaseTest {
    @Test
    @DisplayName("Проверка выхода из Учетной записи")
    @Description("Проверка, что на основной странице отображается кнопка Войти в аккаунт (появляется кнопка Оформить заказ)")
    public void logoutIsSuccessful() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButtonNotAuthorized()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonAuthorized()
                .clickLogOutButton()
                .waitUrlToBe(LOGIN_PAGE_URL);
        Assert.assertEquals("Ожидается переход на страницу Логина", LOGIN_PAGE_URL, mainPage.getCurrentUrl());
    }

}
