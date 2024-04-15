package services.bookstore


import io.restassured.http.ContentType
import response_parser.RaResponse
import services.bookstore.constants.Endpoints

import static io.restassured.RestAssured.given
import static services.bookstore.constants.Endpoints.BASE_URL
import static services.bookstore.constants.Endpoints.BOOKSTORE

class BookHelper {
    BookHelper() {
    }

    static assignBook(String userToken, Map payload) {
        return new RaResponse(given().contentType(ContentType.JSON).header("Authorization", "Bearer ${userToken}")
                .body(payload)
                .when().post(BOOKSTORE.value))

    }

}
