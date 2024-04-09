package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Содержит локаторы и методы, доступные со всех страниц
public class BasePage {
    // Основная страница самоката
    protected final WebDriver driver;

    // Локаторы элементов, применимые для любой страницы
    // Конструктор
    private static final By goToConstructor = By.xpath(".//p[text()='Конструктор']");
    // Лента заказов Лента Заказов
    private static final By orderListButton = By.xpath(".//p[text()='Лента Заказов']");
    // Личный кабинет
    private static final By profileManeButton = By.xpath(".//p[text()='Личный Кабинет']");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    // Открыть Url
    @Step("Переход по адресу")
    public void openUrl(String url) {
        driver.get(url);
    }

    // Нажать на эелемент
    @Step("Нажать на эелемент, согласно локатору")
    public void click(By elementLocator) {
        waitElementToBeVisible(elementLocator);
        waitElementToBeClikcable(elementLocator);
        try {
            driver.findElement(elementLocator).click();
        } catch (Exception e) {
            System.out.println("Не удалось нажать посредством стандратного метода WebElement.click()" + e.getMessage());
        } finally {
            try {
                clickViaJS(elementLocator);
            } catch (Exception e) {
                System.out.println("Не удалось нажать посредством JS Executor" + e.getMessage());
            }
        }
    }

    @Step("Ввод данных в поле")
    public void sendKeys(By elementLocator, String inputText) {
        waitElementToBeVisible(elementLocator);
        driver.findElement(elementLocator).sendKeys(inputText);
    }


    // Явное ожидание кликабельности данного элемента
    @Step("Ожидание кликабельности элемента")
    public void waitElementToBeClikcable(By element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Явное ожидание перехода на URL
    @Step("Ожидание перехода по адресу")
    public void waitUrlToBe(String url) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(url));
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

    @Step
    public void clickViaJS(By element) {
        WebElement ele = driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}