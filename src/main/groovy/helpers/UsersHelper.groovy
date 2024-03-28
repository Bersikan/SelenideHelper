package helpers


import io.restassured.http.ContentType
import restAssuredConfigGroovy.RaResponse

import static io.restassured.RestAssured.given

class UsersHelper  {

    private static final String ENDPOINT = "/api/users"

    UsersHelper() {

    }

    static RaResponse getListUsers(Map queryParams = [:]){
        return new RaResponse(given().queryParams(queryParams).when().get(ENDPOINT))
    }

    static RaResponse getSingleUser(String id){
        return new RaResponse(given().when().get(ENDPOINT +"/${id}"))
    }

    static RaResponse postUser(Map user){
        return new RaResponse(given().contentType(ContentType.JSON).body(user).when().post(ENDPOINT))
    }



}
