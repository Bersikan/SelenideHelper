package helpers.bookstore

import static helpers.bookstore.UserIdentifier.USUAL_USER
import static java.util.Objects.isNull

abstract class CommonBaseSpecification {
    private TokenHelper tokenHelper
    private BookHelper bookHelper
    private String userToken


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


