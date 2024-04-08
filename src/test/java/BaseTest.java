import client.UserClient;
import client_steps.UserSteps;
import dto.CreateUserRequest;
import generators.User;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTest {
    CreateUserRequest createUserRequest;
    String accessToken;
    WebDriver driver;
    UserSteps userSteps;

    private String getWebDriverName() {
        Properties driverPropertiesFile = new Properties();
        try {
            driverPropertiesFile.load(new FileReader("src/main/resources/browser.properties"));
            return driverPropertiesFile.getProperty("browserName");
        } catch (IOException e) {
            e.printStackTrace();
            return "chrome";
        }
    }

    private WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized", "--disable-dev-shm-usage", "--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--start-maximized");
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    @Before
    @Step("Precondition step")
    public void setUp() {
        userSteps = new UserSteps(new UserClient());
        createUserRequest = User.generateNewRandomUser();
        ValidatableResponse responseCreateUser = userSteps.createUser(createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                createUserRequest.getName());
        accessToken = responseCreateUser
                .extract()
                .path("accessToken")
                .toString();
        driver = getWebDriver(getWebDriverName());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    @Step("Delete test user and close browser")
    public void tearDown() {
        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
        driver.quit();
    }
}
