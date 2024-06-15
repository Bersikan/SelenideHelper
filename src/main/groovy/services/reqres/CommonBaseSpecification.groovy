package services.reqres

import general_helpers.ThreadSafeBaseURI
import org.testng.annotations.BeforeMethod

import static io.restassured.RestAssured.baseURI

class CommonBaseSpecification {
    @BeforeMethod(alwaysRun = true)
    void setup() {
        ThreadSafeBaseURI.setEndPoint("https://reqres.in")
        baseURI = ThreadSafeBaseURI.getEndPoint()
    }
}
