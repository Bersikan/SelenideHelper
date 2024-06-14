package services.swapi

import response_parser.RaResponse

import static io.restassured.RestAssured.given
class Swapi {
   static String people = "people"

    static RaResponse getPeople(Map queryParams = [:]) {
        return new RaResponse(given().queryParams(queryParams).when().get(people))
    }

    static RaResponse searchByName(String name) {
        return new RaResponse(given().queryParams(["search": name]).when().get(people))
    }

    static RaResponse getPeopleById(String id) {
        return new RaResponse(given().when().get(people+"/${id}"))
    }


}
