import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.PasswordRecoverPage;
import pages.RegistrationPage;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Проверка логина по кнопке Войти в аккаунт")
    @Description("Проверка, что основная страница отображается после входа (появляется кнопка Оформить заказ)")
    public void loginFromMainePageByEnterAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isAuthorized());
    }

    //
    @Test
    @DisplayName("Проверка логина по кнопке Личный кабинет")
    @Description("Проверка, что основная страница отображается после входа (появляется кнопка Оформить заказ)")
    public void loginFromMainPageProfileButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButtonNotAuthorized()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isAuthorized());
    }

    @Test
    @DisplayName("Проверка логина через переход из страницы регистрации")
    @Description("Проверка, что основная страница отображается после входа (появляется кнопка Оформить заказ)")
    public void loginFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .clickEnterButtonOnRegistrationPage()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAuthorized());
    }

    @Test
    @DisplayName("Проверка логина через переход из страницы регистрации")
    @Description("Проверка, что основная страница отображается после входа (появляется кнопка Оформить заказ)")
    public void loginFromRecoveryPage() {
        PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(driver);
        passwordRecoverPage.openRecoveryPage()
                .clickEnterButtonOnRecoveryPage()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAuthorized());
    }
}
