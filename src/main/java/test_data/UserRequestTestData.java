package test_data;

import org.apache.commons.lang3.RandomStringUtils;
import pojo.UserRequest;

public class UserRequestTestData {

    public static UserRequest getUserRequestWithCorrectPassword() {
        String email = RandomStringUtils.randomAlphabetic(8).toLowerCase() +"@gmail.com";
        String name = RandomStringUtils.randomAlphabetic(5);
        String password = RandomStringUtils.randomAlphabetic(6);
        return new UserRequest(name, email, password);
    }

    public static UserRequest getUserRequestWithInCorrectPassword() {
        String email = RandomStringUtils.randomAlphabetic(8).toLowerCase() +"@gmail.com";
        String name = RandomStringUtils.randomAlphabetic(5);
        String password = RandomStringUtils.randomAlphabetic(4);
        return new UserRequest(name, email, password);
    }
}