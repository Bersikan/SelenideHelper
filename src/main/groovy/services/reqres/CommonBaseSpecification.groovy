package services.reqres

import general_helpers.ThreadSafeBaseURI
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

import static io.restassured.RestAssured.baseURI

class CommonBaseSpecification {
    @BeforeMethod(alwaysRun = true)
    void setup() {
        RestAssured.filters([new AllureRestAssured()])
        ThreadSafeBaseURI.setEndPoint("https://reqres.in")
        baseURI = ThreadSafeBaseURI.getEndPoint()
        println("Tread started: "+ Thread.currentThread().getId())
    }

    @AfterMethod(alwaysRun = true)
    void down() {
        println("Tread closed: "+ Thread.currentThread().getId())
    }
}
