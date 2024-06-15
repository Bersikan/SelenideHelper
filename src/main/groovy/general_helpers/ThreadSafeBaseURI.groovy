package general_helpers

import io.qameta.allure.restassured.AllureRestAssured

class ThreadSafeBaseURI {

    private static ThreadLocal<String> endPoint = ThreadLocal.withInitial(() -> null)
    private static ThreadLocal<AllureRestAssured> filter = ThreadLocal.withInitial(() -> null)


    static void setEndPoint(String apiEndPoint) {
        endPoint.set(apiEndPoint)
    }

    static String getEndPoint() {
        return endPoint.get()
    }

    static void setFilter(AllureRestAssured raFilter) {
        filter.set(raFilter)
    }

    static AllureRestAssured getFilter() {
        return filter.get()
    }
}
