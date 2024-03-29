package helpers.reqres.reqresusers

import io.qameta.allure.Step
import io.restassured.http.ContentType
import restAssuredConfigGroovy.RaResponse

import static io.restassured.RestAssured.baseURI
import static io.restassured.RestAssured.given

class UsersHelper {

    private static final String ENDPOINT = "/api/users"
    private static final String ENDPOINT_USER_REGISTRATION = "/api/register"
    private static final String ENDPOINT_LOGIN = "/api/login"
    public static final String TEST_USER_LOGIN = "eve.holt@reqres.in"
    public static final String TEST_USER_PASSWORD = "pistol"


    UsersHelper() {

    }
    static RaResponse getListUsers(Map queryParams = [:]) {
        return new RaResponse(given().queryParams(queryParams).when().get(ENDPOINT))
    }
    static RaResponse getSingleUser(String id) {
        return new RaResponse(given().when().get(ENDPOINT + "/${id}"))
    }
    static RaResponse postUser(Map user) {
        return new RaResponse(given().contentType(ContentType.JSON).body(user).when().post(ENDPOINT))
    }
    static RaResponse registerUser(String email, String password) {
        return new RaResponse(given().contentType(ContentType.JSON).body(["email": email, "password": password]).when().post(ENDPOINT_USER_REGISTRATION))
    }
    static RaResponse loginUser(String email, String password) {
        return new RaResponse(given().contentType(ContentType.JSON).body(["email": email, "password": password]).when().post(ENDPOINT_LOGIN))
    }


}
