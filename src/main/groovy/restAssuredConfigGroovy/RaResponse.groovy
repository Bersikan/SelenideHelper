package restAssuredConfigGroovy


import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper
import io.restassured.response.Response

class RaResponse {
    private List headersAsList
    private String bodyAsString
    private Object bodyAsMap
    private Response response
    private int status


    RaResponse(Response response) {
        this.status = response.getStatusCode()
        this.response = response
        this.bodyAsString = parseResponseToString(response)
        this.bodyAsMap = parseResponseToJsonObject()
        this.headersAsList = response.headers().asList()
    }

    LinkedHashMap<String, ?> parseResponseToJsonObject() {
        return new ObjectMapper().readValue(bodyAsString, LinkedHashMap.class)
    }

    String parseResponseToString(Response response) {
        return response.getBody().asString()
    }

    Object getBodyAsMap() {
        return bodyAsMap
    }

    Object getHeadersAsList() {
        return headersAsList
    }

    Object getStatus() {
        return status
    }

    Response getResponse() {
        return response
    }
}
