import client.UserClient;
import client_steps.UserSteps;
import generators.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    @Override
    @Before
    @Step("setUp")
    public void setUp() {
        userSteps = new UserSteps(new UserClient());
        createUserRequest = User.generateNewRandomUser();
        driver = getWebDriver(getWebDriverName());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @Test
    @DisplayName("Проверка регистрации на странице регистрации")
    @Description("Проверка, что после регистрации и входа под созданным аккаунтом на основной страницк отображается кнопка Оформить заказ")
    public void successfullyRegistrationOnRegisterPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .fillRegistrationFields(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickRegistrationButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAuthorized());
    }

    @Test
    @DisplayName("Проверка регистрации через переход из формы Логина")
    @Description("Проверка, что после регистрации и входа под созданным аккаунтом на основной страницк отображается кнопка Оформить заказ")
    public void successfullyRegistrationOnLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .clickRegisterButtonLoginPage()
                .fillRegistrationFields(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickRegistrationButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isAuthorized());
    }

    @Test
    @DisplayName("Проверка регистрации через переход из Личный кабинет")
    @Description("Проверка, что после регистрации и входа под созданным аккаунтом на основной страницк отображается кнопка Оформить заказ")
    public void successfullyRegistrationOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .clickRegisterButtonLoginPage()
                .fillRegistrationFields(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickRegistrationButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isAuthorized());
    }

    @Override
    @After
    @Step("Удалить пользователя и закрыть браузер")
    public void tearDown() {
        String accessToken = userSteps.getUserToken(createUserRequest.getEmail(), createUserRequest.getPassword());
        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
        driver.quit();
    }
}
