package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private static final By burgerLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By goToConstructor = By.xpath(".//p[text()='Конструктор']"); // переход на главную страницу
    private static final By logOutButton = By.xpath(".//button[text()='Выход']");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку Конструктор на странице личного кабинета")
    public void clickConstructorButton() {
        click(goToConstructor);

    }

    @Step("Нажать на Лого на странице личного кабинета")
    public void clickOnLogo() {
        click(burgerLogo);
    }

    @Step("Нажать на кнопку Выход на странице личного кабинета")
    public void clickLogOutButton() {
        click(logOutButton);
    }
}
