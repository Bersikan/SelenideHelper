package helpers.reqres

import com.codeborne.selenide.logevents.SelenideLogger
import helpers.reqres.reqresusers.UsersHelper
import io.qameta.allure.restassured.AllureRestAssured
import io.qameta.allure.selenide.AllureSelenide
import io.restassured.RestAssured
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeSuite

import static io.restassured.RestAssured.baseURI
import static io.restassured.RestAssured.baseURI
import static io.restassured.RestAssured.given

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
