package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Urls.LOGIN_PAGE_URL;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By loginEnterButton = By.xpath(".//*[text()='Войти']");
    private static final By loginEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By loginPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registerButtonFromLogin = By.xpath(".//*[text()='Зарегистрироваться']");
    private static final By registerWrongPasswordMessageInLoginPage = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Открыть страницу Входа (Login)")
    public void openLoginPage() {
        openUrl(LOGIN_PAGE_URL);
    }

    @Step("Нажать на кнопку регистрации на странице Логина")
    public LoginPage clickRegisterButtonLoginPage() {
        click(registerButtonFromLogin);
        return this;
    }

    @Step("Нажать на кнопку Вход на странице Логина")
    public MainPage clickLoginEnterButton() {
        click(loginEnterButton);
        return new MainPage(driver);
    }

    @Step("Ввести логин (Email)")
    public void sendLogin(String login) {
        click(loginEmail);
        sendKeys(loginEmail, login);
    }

    @Step("Ввести пароль (Password)")
    public void sendPassword(String password) {
        click(loginPassword);
        sendKeys(loginPassword, password);
    }

    @Step("Заполнить формы для Входа (Login)")
    public LoginPage fillAuthFormLoginPage(String login, String password) {
        sendLogin(login);
        sendPassword(password);
        return this;
    }


}
