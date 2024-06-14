package services.swapi

import general_helpers.ThreadSafeBaseURI
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.testng.annotations.BeforeMethod

import static io.restassured.RestAssured.baseURI

class CommonBaseSpecification {
    @BeforeMethod(alwaysRun = true)
    void setup() {
        RestAssured.filters([new AllureRestAssured()])
        ThreadSafeBaseURI.setEndPoint("https://swapi.dev/api/")
        baseURI = ThreadSafeBaseURI.getEndPoint()
    }

}
