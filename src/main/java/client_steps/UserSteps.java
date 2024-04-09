package client_steps;

import client.UserClient;
import dto.CreateUserRequest;
//import dto.LoginUserRequest;
//import dto.UpdateUserRequest;
import dto.LoginUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class UserSteps {
    private final UserClient userClient;

    public UserSteps(UserClient userClient) {
        this.userClient = userClient;
    }

    @Step("Cоздание пользователя c помощью API")
    public ValidatableResponse createUser(String email, String password, String name) {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();


        return userClient.createUser(createUserRequest)
                .then();
    }


    @Step("Авторизация пользователя по API")
    public ValidatableResponse loginUser(String email, String password) {
        LoginUserRequest loginUserRequest = LoginUserRequest.builder()
                .email(email)
                .password(password)
                .build();

        return userClient.loginUser(loginUserRequest)
                .then();
    }

    @Step("Получение токена")
    public String getUserToken(String email, String password) {
        return loginUser(email, password)
                .extract()
                .path("accessToken");

    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
//        String bearerToken = getUserToken(email, password);
        return userClient.deleteUser(accessToken)
                .then();
    }


}
