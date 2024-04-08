package helpers.bookstore

import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import restAssuredConfigGroovy.RaResponse

import static io.restassured.RestAssured.given

class TokenHelper {
    private String baseUrl = "https://bookstore.demoqa.com"
    private final String ENDPOINT = "/Account/v1/GenerateToken"
    private RequestSpecification reqSpec;

    TokenHelper() {
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl).build()
    }
    
    RaResponse createToken(final UserIdentifier userIdentifier) {
        return new RaResponse(given().spec(reqSpec).body(["userName": userIdentifier.getUserName(), "password": userIdentifier.getUserPassword()]).when().post(ENDPOINT))
    }
}
