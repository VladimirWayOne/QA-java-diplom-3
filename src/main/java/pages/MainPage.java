package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Urls.BASE_URL;

public class MainPage extends BasePage {

    // MainPage эквивалентна ConstructorPage для текущей реализации приложения StellarBurgers
    private static final By profileManeButton = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By menuBun = By.xpath(".//span[text()='Булки']");
    private static final By menuFillings = By.xpath(".//span[text()='Начинки']");
    private static final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private static final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private static final By menuSauce = By.xpath(".//span[text()='Соусы']");
    private static final By enterAccountButtonMain = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By loadingGif = By.className("Modal_modal__P3_V5");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на основную страницу")
    public MainPage openMainPage() {
        openUrl(BASE_URL);
        return this;
    }

    @Step("Нажать на кнопку логина")
    public LoginPage clickAccountButton() {
        waitUntilNotVisibilityOfElementLocated(driver.findElement(loadingGif));
        click(enterAccountButtonMain);
        return new LoginPage(driver);
    }

    @Step("Нажать на кнопку Личный кабинет для авторизованного пользователя")
    public ProfilePage  clickProfileButtonAuthorized() {
        click(profileManeButton);
        return new ProfilePage(driver);
    }

    @Step("Нажать на кнопку Личный кабинет для неавторизованного пользователя")
    public LoginPage  clickProfileButtonNotAuthorized() {
        click(profileManeButton);
        return new LoginPage(driver);
    }

    @Step("Проверить выполнена ли авторизация")
    public boolean isAuthorized() {
        return driver.findElement(makeOrderButton).isDisplayed();
    }

    @Step("Нажать на кнопку Булки")
    public MainPage clickMenuBun() {
        click(menuBun);
        return this;

    }

    @Step("Нажать на кнопку Соусы")
    public MainPage clickMenuSauce() {
        click(menuSauce);
        return this;

    }

    @Step("Нажать на кнопку Начинки")
    public MainPage clickMenuFillings() {
        click(menuFillings);
        return this;

    }

    @Step("Получить выбранный раздел")
    public String getTextFromSelectedMenu() {
        return driver.findElement(currentMenu).getText();
    }

}
