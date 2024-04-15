package services.bookstore.constants

enum Endpoints {
    BASE_URL("https://bookstore.demoqa.com/"),
    BOOKSTORE("BookStore/v1/Books");

    private String value;

    Endpoints(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value
    }
}
