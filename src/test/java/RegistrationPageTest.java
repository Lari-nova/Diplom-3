import api.UserAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pojo.LoginRequest;
import pojo.UserRequest;

import static test_data.UserRequestTestData.getUserRequestWithCorrectPassword;
import static test_data.UserRequestTestData.getUserRequestWithInCorrectPassword;

public class RegistrationPageTest extends BaseUITest {

    private UserRequest userRequest;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver.get("http://stellarburgers.nomoreparties.site/");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void teardown() {
        UserAPI userAPI = new UserAPI();
        LoginRequest loginRequest = new LoginRequest(userRequest.getEmail(), userRequest.getPassword());
        Response response = userAPI.userLogin(loginRequest);
        String accessToken = response
           .then()
           .extract()
           .path("accessToken");
        if (accessToken != null) {
            userAPI.deleteUser(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверяем успешную регистрацию с валидными данными")
    public void checkRegistrationWithCorrectPassword() {
        userRequest = getUserRequestWithCorrectPassword();
        loginPage.clickOnLogInButton();
        loginPage.clickOnRegister();
        registrationPage.setDataRegisterForm(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword());
        registrationPage.clickOnRegisterButton();
        registrationPage.isDisplayLoginButton();
    }

    @Test
    @DisplayName("Не успешная регистрация")
    @Description("Проверяем ошибку: Некорректный пароль")
    public void checkRegistrationWithIncorrectPassword() {
        userRequest = getUserRequestWithInCorrectPassword();
        loginPage.clickOnLogInButton();
        loginPage.clickOnRegister();
        registrationPage.setDataRegisterForm(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword());
        registrationPage.clickOnRegisterButton();
        Assert.assertEquals("Некорректный пароль", registrationPage.getTextPasswordErrorField());
    }
}
