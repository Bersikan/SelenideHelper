package data;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataHelper {

    public static String randomAlpha(int size) {
        return RandomStringUtils.randomAlphabetic(size);
    }

}
