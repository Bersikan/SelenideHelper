package general_helpers

class MapHelper {
    static List nestedSearch(Map root, String key) {
        List results = []
        search(root, results, key)
        return results
    }


    static List search(Map root, List results, String key) {
        root.each { it ->
            if (it.key == key) {
                results.add(it.value)
                if (it.value instanceof Map) {
                    return search(it.value, results, key)
                }
            } else if (it.value instanceof Map) {
                return search(it.value, results, key)
            }
            return results
        }
        return results
    }

}
