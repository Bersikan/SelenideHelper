package restAssuredConfigJava;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class BaseRestAssuredConfig2 {

    @BeforeSuite
    void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
}
