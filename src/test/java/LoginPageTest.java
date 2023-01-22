import API.UserAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.PersonalAccountPage;
import pojo.LoginRequest;
import pojo.UserRequest;

import static test_data.UserRequestTestData.getUserRequestWithCorrectPassword;

public class LoginPageTest extends BaseUITest{

    UserRequest userRequest;
    UserAPI userAPI;
    LoginPage loginPage;
    PersonalAccountPage personalAccountPage;

    @Before
    public void setup() {
        driver.get("http://stellarburgers.nomoreparties.site/");
        userAPI = new UserAPI();
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        userRequest = getUserRequestWithCorrectPassword();
        userAPI.create(userRequest);
    }

    @After
    public void teardown() {
        LoginRequest loginRequest = new LoginRequest(userRequest.getEmail(), userRequest.getPassword());
        Response response = userAPI.login(loginRequest);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            userAPI.delete(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Проверка кнопки 'Войти в аакаунт' с главной страницы")
    @Description("Авторизируемся с главной страницы")
    public void checkLogInToAccountWithButtonOnMainPage() {
        loginPage.clickOnLogInButton();
        loginPage.setEmailInField(userRequest.getEmail());
        loginPage.setPasswordInField(userRequest.getPassword());
        loginPage.clickOnLoginButton();
    }

    @Test
    @DisplayName("Проверка кнопки 'Личный кабинет' с главной страницы")
    @Description("Авторизируемся с главной страницы")
    public void checkLogInThroughPersonalAccount() {
        personalAccountPage.clickOnPersonalAccount();
        loginPage.setEmailInField(userRequest.getEmail());
        loginPage.setPasswordInField(userRequest.getPassword());
        loginPage.clickOnLoginButton();
    }

    @Test
    @DisplayName("Авторизация через форму регистрации")
    @Description("Авторизируемся через форму регистрации")
    public void checkLogInThroughRegistrationForm() {
        loginPage.clickOnLogInButton();
        loginPage.clickOnRegister();
        loginPage.clickOnLogInThroughRegistration();
        loginPage.setEmailInField(userRequest.getEmail());
        loginPage.setPasswordInField(userRequest.getPassword());
        loginPage.clickOnLoginButton();
    }

    @Test
    @DisplayName("Авторизация через форму восстановления пароля")
    @Description("Авторизируемся через форму восстановления пароля")
    public void checkLogInThroughRecoverPasswordForm() {
        personalAccountPage.clickOnPersonalAccount();
        loginPage.clickOnRecoverPassword();
        loginPage.clickOnLogInThroughRegistration();
        loginPage.setEmailInField(userRequest.getEmail());
        loginPage.setPasswordInField(userRequest.getPassword());
        loginPage.clickOnLoginButton();
    }
}