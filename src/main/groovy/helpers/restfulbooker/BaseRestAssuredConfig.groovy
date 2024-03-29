package helpers.restfulbooker

import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.restassured.AllureRestAssured
import io.qameta.allure.selenide.AllureSelenide
import org.testng.annotations.BeforeClass

import static io.restassured.RestAssured.baseURI
import static java.util.Objects.isNull

class BaseRestAssuredConfig {
    private static LoginHelper loginHelper
    private static String userToken

    @BeforeClass
    void setup() {
        baseURI = "https://restful-booker.herokuapp.com"
    }

    public loginHelper() {
        loginHelper = new LoginHelper()
        return loginHelper
    }


    synchronized String userToken() {
        if (isNull(userToken)) {
            userToken = loginHelper().generateToken()
        }
        return userToken
    }
}
