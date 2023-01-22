package API;

import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.UserRequest;

import static config.Config.BASE_URL;
import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class UserAPI {

    public void create(UserRequest userRequest) {
        given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(userRequest)
                .post(USER_CREATE);
    }

    public Response login(LoginRequest loginRequest) {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(loginRequest)
                .post(USER_LOGIN);
    }

    public void delete(String accessToken) {
        given()
                .header("Authorization", BEARER + accessToken)
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .delete(USER_EDIT);
    }
}
