package helpers.reqres


import helpers.reqres.reqresusers.UsersHelper
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.testng.annotations.BeforeClass

import static io.restassured.RestAssured.baseURI

class BaseRestAssuredConfig {
    private static UsersHelper usersHelper

    @BeforeClass
    void setup() {
        RestAssured.filters([new AllureRestAssured()])
        baseURI = "https://reqres.in"
    }

    public UsersHelper(){
        usersHelper = new UsersHelper()
        return usersHelper
    }
}
