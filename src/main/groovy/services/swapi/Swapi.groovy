package services.swapi

import io.qameta.allure.Step
import response_parser.RaResponse

import static io.restassured.RestAssured.given

class Swapi {
    static String people = "people"

    @Step
    static RaResponse getPeople(Map queryParams = [:]) {
        return new RaResponse(given().queryParams(queryParams).when().get(people))
    }

    @Step
    static RaResponse searchByName(String name) {
        return new RaResponse(given().queryParams(["search": name]).when().get(people))
    }

    @Step
    static RaResponse getPeopleById(String id) {
        return new RaResponse(given().when().get(people + "/${id}"))
    }


}
