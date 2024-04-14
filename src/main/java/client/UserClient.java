package client;

import dto.CreateUserRequest;
import dto.LoginUserRequest;
import io.restassured.response.Response;

public class UserClient extends RestClient {

    public Response createUser(CreateUserRequest createUserRequest) {
        return getDefaultRequestSpecification()
                .body(createUserRequest)//.log().all()
                .when()
                .post("/api/auth/register");

    }

    public Response loginUser(LoginUserRequest loginUserRequest) {
        return getDefaultRequestSpecification()
                .body(loginUserRequest)
                .when()
                .post("api/auth/login");
    }

    public Response deleteUser(String bearerToken) {
        return getDefaultRequestSpecification()
                .header("authorization", bearerToken)
                .when()
                .delete("/api/auth/user");
    }


}
