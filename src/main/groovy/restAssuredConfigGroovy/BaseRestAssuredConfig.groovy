package restAssuredConfigGroovy

import helpers.UsersHelper
import org.testng.annotations.BeforeSuite

import static io.restassured.RestAssured.baseURI

class BaseRestAssuredConfig {
    private static UsersHelper usersHelper

    @BeforeSuite
    void setup() {
        baseURI = "https://reqres.in"
    }


    public UsersHelper(){
        usersHelper = new UsersHelper()
        return usersHelper
    }
}
