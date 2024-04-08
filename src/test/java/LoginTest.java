import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Checking the login by Login button on the main page")
    @Description("Check that the main page is displayed with Checkout")
    public void loginFromMainePageByEnterAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .fillAuthFormLoginPage(createUserRequest.getEmail(), createUserRequest.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isAuthorized());
    }
//
//    @Test
//    @DisplayName("Checking the login using the Dashboard button on the main page")
//    @Description("Check that the main page is displayed with Checkout")
//    public void loginFromMainPageProfileButton() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.openMainPage()
//                .clickProfileButton()
//                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
//                .clickLoginEnterButton();
//        Assert.assertTrue(mainPage.isManePageOpen());
//    }
//
//    @Test
//    @DisplayName("Checking the login by Login on the register page")
//    @Description("Check that the main page is displayed with Checkout")
//    public void loginFromRegistrationPage() {
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.openRegisterPage()
//                .clickEnterButtonOnRegistrationPage()
//                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
//                .clickLoginEnterButton();
//        MainPage mainPage = new MainPage(driver);
//        Assert.assertTrue(mainPage.isManePageOpen());
//    }
//
//    @Test
//    @DisplayName("Checking the login by Login on the recovery page")
//    @Description("Check that the main page is displayed with Checkout")
//    public void loginFromRecoveryPage() {
//        PasswordRecoverPage passwordRecoverPage = new PasswordRecoverPage(driver);
//        passwordRecoverPage.openRecoveryPage()
//                .clickEnterButtonOnRecoveryPage()
//                .authorizationFromLoginPage(user.getEmail(), user.getPassword())
//                .clickLoginEnterButton();
//        MainPage mainPage = new MainPage(driver);
//        Assert.assertTrue(mainPage.isManePageOpen());
//    }
}
