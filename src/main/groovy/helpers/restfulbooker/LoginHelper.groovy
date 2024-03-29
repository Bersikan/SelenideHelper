package helpers.restfulbooker

import io.restassured.http.ContentType
import restAssuredConfigGroovy.RaResponse

import static io.restassured.RestAssured.given
import static java.util.Objects.isNull

class LoginHelper {


    private static final String ENDPOINT = "/auth"
    private static String token


    LoginHelper() {
    }

    String generateToken() {
        Map loginBody = ["username": "admin",
                         "password": "password123"]
        if (isNull(token)) {
            this.token = new RaResponse(given().contentType(ContentType.JSON).body(loginBody).when().post(ENDPOINT)).bodyAsMap.token
        }
        return token
    }


    static getToken() {
        return token
    }

}
