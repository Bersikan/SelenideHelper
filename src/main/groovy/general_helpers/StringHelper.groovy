package general_helpers

import com.github.curiousoddman.rgxgen.RgxGen
import org.apache.commons.lang3.RandomStringUtils

class StringHelper {
    public static String randomAlpha(int size) {
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String randomStringRegex(String regex) {
        RgxGen rgxGen = new RgxGen(regex);
        return rgxGen.generate();
    }
}
