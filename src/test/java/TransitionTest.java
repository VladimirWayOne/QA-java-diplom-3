import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import static constants.Urls.*;

public class TransitionTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода в личный кабинет для неавторизированного пользователя")
    @Description("Проверка, что осуществляется переход на страницу Логина")
    public void clickOnProfileByNotAuthUser() {
        MainPage mainPage = new MainPage(driver);
        String actualUrl = mainPage.openMainPage()
                .clickProfileButtonNotAuthorized()
                .getCurrentUrl();
        Assert.assertEquals("Не выполнен переход на страницу Логина", LOGIN_PAGE_URL, actualUrl);
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет для авторизированного пользователя с основной страницы")
    @Description("Проверка, что осуществляется переход в личный профиль Пользователя")
    public void clickOnProfileByAuthUser() {
        MainPage mainPage = new MainPage(driver);
        String actualUrl = mainPage.openMainPage()
                .clickAccountButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonAuthorized()
                .getCurrentUrl();
        Assert.assertTrue("Не выполнен переход на страницу Профиля пользователя",
                PROFILE_URL.equalsIgnoreCase(actualUrl) || ACCOUNT_URL.equalsIgnoreCase(actualUrl));
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет для авторизированного пользователя с основной страницы")
    @Description("Проверка, что осуществляется переход на Главную страницу")
    public void clickOnLogo() {
        MainPage mainPage = new MainPage(driver);
        String actualUrl = mainPage.openMainPage()
                .clickAccountButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonAuthorized()
                .clickOnLogo()
                .getCurrentUrl();
        Assert.assertEquals("Не выполнен переход на Главную страницу", BASE_URL, actualUrl);
    }

}
