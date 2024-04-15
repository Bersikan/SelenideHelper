package services.reqres


import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.testng.annotations.BeforeClass
import services.reqres.reqresusers.UsersHelper

import static io.restassured.RestAssured.baseURI
class CommonBaseSpecification {
    private static UsersHelper usersHelper

    @BeforeClass(alwaysRun = true)
    void setup() {
        RestAssured.filters([new AllureRestAssured()])
        baseURI = "https://reqres.in"
    }

    public UsersHelper(){
        usersHelper = new UsersHelper()
        return usersHelper
    }
}
