package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Urls.BASE_URL;

// Содержит локаторы и методы, доступные со всех страниц
public class BasePage {
    // Основная страница самоката
    protected final WebDriver driver;

    // Локаторы элементов, применимые для любой страницы
    // Конструктор
    private static final By goToConstructor = By.xpath(".//p[text()='Конструктор']");
    // Лента заказов Лента Заказов
    private static final By ORDERS_LIST_BUTTON = By.xpath(".//p[text()='Лента Заказов']");
    // Личный кабинет
    private static final By PROFILE_MANE_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    // Лого Stellar Burgers
   // private static final By PROFILE_MANE_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUrlUntilNotAboutBlank() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));
    }

    // Открыть Url
    @Step("Переход по адресу")
    public void openUrl(String url) {
        driver.get(url);
    }

    // Нажать на эелемент
    @Step("Нажать на эелемент, согласно локатору")
    public void click(By elementLocator) {
        waitElementToBeClikcable(elementLocator);
        driver.findElement(elementLocator).click();
    }

    @Step("Ввод данных в поле")
    public void sendKeys(By elementLocator, String inputText) {
        driver.findElement(elementLocator).sendKeys(inputText);
    }
    @Step("Переход в Конструктор")
    public void clickConstructorButton() {
        click(goToConstructor);

    }
    @Step("Переход в личный кабинет")
    public void clickProfileManeButton() {
        click(PROFILE_MANE_BUTTON);
    }

    @Step("Переход в ленту заказов")
    public void clickOrdersListButton() {
        click(ORDERS_LIST_BUTTON);
    }

    // Явное ожидание кликабельности данного элемента
    @Step("Ожидание кликабельности элемента")
    public void waitElementToBeClikcable(By element) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Явное ожидание перехода на URL главной страницы
    @Step("Ожидание открытия основной страницы")
    public void waitUrlToBe() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(BASE_URL));
    }

    // Явное ожидание отображения элемента с данным локатором
    @Step("Ожидание отображение элемента")
    public void waitElementToBeVisible(By elementLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    @Step("Ожидание пока элемент не пропадет")
    public void waitUntilNotVisibilityOfElementLocated(WebElement element) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOf(element));
    }
}