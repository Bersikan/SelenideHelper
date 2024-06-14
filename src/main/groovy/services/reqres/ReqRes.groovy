package services.reqres


import io.restassured.http.ContentType
import response_parser.RaResponse

import static io.restassured.RestAssured.given

class ReqRes {
    private static final String ENDPOINT = "/api/users"
    private static final String ENDPOINT_USER_REGISTRATION = "/api/register"
    private static final String ENDPOINT_LOGIN = "/api/login"
    private static final String TEST_USER_LOGIN = "eve.holt@reqres.in"
    private static final String TEST_USER_PASSWORD = "pistol"

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

    static String getTEST_USER_LOGIN() {
        return TEST_USER_LOGIN
    }

    static String getTEST_USER_PASSWORD() {
        return TEST_USER_PASSWORD
    }

}
