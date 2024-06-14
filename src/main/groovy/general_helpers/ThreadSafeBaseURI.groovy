package general_helpers

class ThreadSafeBaseURI {

    private static ThreadLocal<String> endPoint = ThreadLocal.withInitial(() -> null);


     static void setEndPoint(String apiEndPoint) {
        endPoint.set(apiEndPoint);
    }

     static String getEndPoint() {
        return endPoint.get();
    }
}
