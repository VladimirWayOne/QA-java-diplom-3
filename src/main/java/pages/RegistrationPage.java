package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Urls.REGISTER_PAGE_URL;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);

    }

    private static final By registerName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registerEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registerPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By enterButtonOnRegistrationPage = By.xpath(".//*[text()='Войти']"); //кнопка "войти" на форме регистрации
    public static By registerWrongPasswordMessageInRegisterPage = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Открыть страницу регистрации")
    public RegistrationPage openRegistrationPage() {
        openUrl(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Ввести имя (Name) в странице регистрации")
    public RegistrationPage enterRegisterName(String name) {
        click(registerName);
        sendKeys(registerName, name);
        return this;
    }

    @Step("Ввести Email в странице регистрации")
    public RegistrationPage enterRegisterEmail(String email) {
        click(registerEmail);
        sendKeys(registerEmail, email);
        return this;
    }

    @Step("Ввести пароль (Password) в странице регистрации")
    public RegistrationPage enterRegisterPassword(String password) {
        click(registerPassword);
        sendKeys(registerPassword, password);
        return this;
    }

    @Step("Нажать на кнопку Зарегистрироваться (Register) в странице регистрации")
    public LoginPage clickRegistrationButton() {
        click(registrationButton);
        return new LoginPage(driver);
    }

    @Step("Нажать на кнопку Вход в странице регистрации")
    public LoginPage clickEnterButtonOnRegistrationPage() {
        click(enterButtonOnRegistrationPage);
        return new LoginPage(driver);
    }

    @Step("Заполнение полей для регистрации")
    public RegistrationPage fillRegistrationFields(String name, String email, String password) {
        enterRegisterName(name);
        enterRegisterEmail(email);
        enterRegisterPassword(password);
        return this;

    }

}
