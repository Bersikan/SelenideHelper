package general_helpers

class MapHelper {

    boolean search(def root) {
        return root.find {
            if (it.value instanceof Map) {
                return search(it.value)
            } else if (it.value == null) {
                return true
            }
            return false
        }
    }


    static List nestedSearch(Map root, List results, String key) {
        root.each { it ->
            if (it.key == key) {
                results.add(it.value)
                if (it.value instanceof Map) {
                    return nestedSearch(it.value, results, key)
                }
            } else if (it.value instanceof Map) {
                return nestedSearch(it.value, results, key)
            }
            return results
        }
        return results
    }

}
