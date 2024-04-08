package helpers.bookstore

class UserIdentifier {
    private final String USER
    private String userName
    private String userPassword

    public static final UserIdentifier USUAL_USER = new UserIdentifier("USER1", "TOOLSQA-Test", "Test@@123")

    UserIdentifier(String USER, String userName, String userPassword) {
        this.USER = USER
        this.userName = userName
        this.userPassword = userPassword
    }

    String getUserName() {
        return userName
    }

    String getUserPassword() {
        return userPassword
    }
}
