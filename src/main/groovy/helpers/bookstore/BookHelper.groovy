package helpers.bookstore


import io.restassured.http.ContentType
import restAssuredConfigGroovy.RaResponse

import static io.restassured.RestAssured.given

class BookHelper {

    BookHelper() {

    }


    static assignBook(String userToken, Map payload) {
        return new RaResponse(given().contentType(ContentType.JSON).header("Authorization", "Bearer ${userToken}")
                .body(payload)
                .when().post("https://bookstore.demoqa.com/BookStore/v1/Books"))
    }

}
