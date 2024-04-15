package services.bookstore

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.testng.annotations.BeforeClass
import services.bookstore.constants.Endpoints

import static UserIdentifier.USUAL_USER
import static io.restassured.RestAssured.baseURI
import static java.util.Objects.isNull

abstract class CommonBaseSpecification {
    private volatile TokenHelper tokenHelper
    private volatile BookHelper bookHelper
    private volatile String userToken

    @BeforeClass(alwaysRun = true)
    void setup() {
        RestAssured.filters([new AllureRestAssured()])
        baseURI = Endpoints.BASE_URL.value
    }

    synchronized TokenHelper tokenHelper() {
        if (isNull(tokenHelper)) {
            tokenHelper = new TokenHelper()
        }
        return tokenHelper
    }

     synchronized String userToken(){
        if(isNull(userToken)){
            userToken = tokenHelper().createToken(USUAL_USER).bodyAsMap["token"]
        }
        return userToken
    }

    synchronized BookHelper bookHelper() {
        if (isNull(bookHelper)) {
            bookHelper = new BookHelper()
        }
        return bookHelper
    }


}


