package client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static constants.Urls.BASE_URL;
import static io.restassured.RestAssured.given;

public abstract class RestClient {
    protected RequestSpecification getDefaultRequestSpecification() {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }
}