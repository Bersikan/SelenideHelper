package general_helpers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class DateHelper {
    static def stringToDateIfNeed(def value, String pattern) {
        if (value instanceof String) {
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
                return localDateTime
            } catch (DateTimeParseException ignored) {
                return value
            }
        } else {
            return value
        }
    }
}
