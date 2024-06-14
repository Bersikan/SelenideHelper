package general_helpers


import static general_helpers.DateHelper.stringToDateIfNeed

class ListHelper {
    enum sortOrder {
        ASC,
        DESC
    }

    static List<Map<String, Object>> getSortedListOfMaps(
            final List list,
            String keyValueName1,
            sortOrder order1,
            String keyValueName2 = "id",
            sortOrder order2 = sortOrder.ASC,
            String dateTimePattern = "dd/MM/yyyy HH:mm:ss"
    ) {
        List<Map<String, Object>> listToSort = new ArrayList<>(list)
        List<Map<String, Object>> newList
        newList = listToSort.sort { Map map1, Map map2 ->
            compare(map1, map2, keyValueName1, order1, dateTimePattern) ?: compare(map1, map2, keyValueName2, order2, dateTimePattern)
        }.toList();
        return newList
    }

    static List<Map<String, Object>> getSortedList(final List list, sortOrder order,
                                                   String dateTimePattern = "dd/MM/yyyy HH:mm:ss") {
        List listToSort = new ArrayList<>(list)
        List newList
        newList = listToSort.sort { a, b ->
            (order == sortOrder.ASC) ?
                    stringToDateIfNeed(a, dateTimePattern) <=> stringToDateIfNeed(b, dateTimePattern) :
                    stringToDateIfNeed(b, dateTimePattern) <=> stringToDateIfNeed(a, dateTimePattern)
        }.toList();
        return newList
    }


    private static def compare(def map1, def map2, String keyValueName, sortOrder order, String dateTimePattern) {
        def map1Value = stringToDateIfNeed(map1.get(keyValueName), dateTimePattern)
        def map2Value = stringToDateIfNeed(map2.get(keyValueName), dateTimePattern)
        return (order == sortOrder.ASC) ? map1Value <=> map2Value : map2Value <=> map1Value
    }


}
