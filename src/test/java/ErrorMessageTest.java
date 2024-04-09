import generators.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import java.time.Duration;

import static constants.Urls.ERROR_MESSAGE_OF_WRONG_PASSWORD;
import static pages.RegistrationPage.registerWrongPasswordMessageInRegisterPage;

public class ErrorMessageTest extends BaseTest {
    @Override
    @Before
    @Step("setUp")
    public void setUp() {
        createUserRequest = User.generateNewRandomUser();
        driver = getWebDriver(getWebDriverName());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @Test
    @DisplayName("Проверка создания УЗ с паролем длинной в 3 символа")
    @Description("Проверка, что при попытке создать УЗ с длинной пароля в 3 символа всплывает ошибка")
    public void shownErrorMessageWithWrongPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage()
                .enterRegisterName(createUserRequest.getName())
                .enterRegisterEmail(createUserRequest.getEmail())
                .enterRegisterPassword("123")
                .clickRegistrationButton();
        Assert.assertEquals("Ошибка не появилась", ERROR_MESSAGE_OF_WRONG_PASSWORD,
                driver.findElement(registerWrongPasswordMessageInRegisterPage).getText());
    }

    @Override
    @After
    @Step("Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}
