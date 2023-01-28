package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.UserRequest;

import static config.Config.BASE_URL;
import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class UserAPI {

    @Step("Создание юзера")
    public void createUser(UserRequest userRequest) {
        given()
           .header("Content-type", "application/json")
           .baseUri(BASE_URL)
           .body(userRequest)
           .post(USER_CREATE);
    }

    @Step("Авторизация созданного юзера")
    public Response userLogin(LoginRequest loginRequest) {
        return given()
           .header("Content-type", "application/json")
           .baseUri(BASE_URL)
           .body(loginRequest)
           .post(USER_LOGIN);
    }

    @Step("Удаление юзера")
    public void deleteUser(String accessToken) {
        given()
           .header("Authorization", BEARER + accessToken)
           .header("Content-type", "application/json")
           .baseUri(BASE_URL)
           .delete(USER_EDIT);
    }
}
