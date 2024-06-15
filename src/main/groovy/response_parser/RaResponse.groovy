package response_parser

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import io.qameta.allure.Allure
import io.restassured.response.Response

class RaResponse {
    private List headersAsList
    private Map cookies
    private String bodyAsString
    private Object bodyAsMap
    private synchronized Response response
    private def validateJsonSchema
    private int status


    RaResponse(Response response) {
        this.status = response.getStatusCode()
        this.response = response
        this.bodyAsString = parseResponseToString(response)
        this.bodyAsMap = parseResponseToJsonObject()
        this.headersAsList = response.headers().asList()
        this.cookies = response.getCookies()
        this.validateJsonSchema = performValidateJsonSchema
    }

    LinkedHashMap<String, Object> parseResponseToJsonObject() {
        return new JsonSlurper().parseText(bodyAsString)
    }

    String parseResponseToString(Response response) {
        return response.getBody().asString()
    }

    Map getBodyAsMap() {
        Allure.attachment("body", new JsonBuilder(bodyAsMap).toPrettyString())
        return bodyAsMap
    }

    List getHeadersAsList() {
        return headersAsList
    }

    Integer getStatus() {
        return status
    }

    Response getResponse() {
        return response
    }

    private Closure performValidateJsonSchema = {
        validator -> response.then().assertThat().body(validator)
    }

    def getValidateJsonSchema() {
        return validateJsonSchema
    }

    Map getCookies() {
        return cookies
    }
}
