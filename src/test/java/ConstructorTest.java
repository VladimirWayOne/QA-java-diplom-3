import groovyjarjarantlr4.v4.runtime.RuleDependency;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import java.time.Duration;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Override
    @Before
    @Step("setUp")
    public void setUp() {
        driver = getWebDriver(getWebDriverName());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверка, что выбраны Соусы")
    @Description("Проверка, что выбранный пункт соответствует ожидаемому")
    public void menuSauceIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce();
        Assert.assertEquals("Выбрано некорректное меню", "Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка, что выбраны Булки")
    @Description("Проверка, что выбранный пункт соответствует ожидаемому")
    public void menuBunIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce()
                .clickMenuBun();
        Assert.assertEquals("Выбрано некорректное меню", "Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка, что выбраны Начинки")
    @Description("Проверка, что выбранный пункт соответствует ожидаемому")
    public void menuFillingsIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuFillings();
        Assert.assertEquals("Выбрано некорректное меню", "Начинки", mainPage.getTextFromSelectedMenu());
    }

    @Override
    @After
    @Step("Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}
