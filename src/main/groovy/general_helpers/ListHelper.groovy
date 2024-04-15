package general_helpers

import io.qameta.allure.Step

import java.text.Collator

class ListHelper {
    static List getSortedListOfMapsByTextEntity(List<Map> list, String sortBy, String sortOrder = "asc") {
        def collator = Collator.getInstance(Locale.ENGLISH)
        if (sortOrder.equalsIgnoreCase("asc")) {
            list.sort { map1, map2 -> collator.compare(map1[sortBy].toString().toLowerCase(), map2[sortBy].toString().toLowerCase()) }
        } else if (sortOrder.equalsIgnoreCase("desc")) {
            list.sort { map1, map2 -> collator.compare(map2[sortBy].toString().toLowerCase(), map1[sortBy].toString().toLowerCase()) }
        }
        else {
            throw new Exception("[getSortedListOfMapsByTextEntity]: Sort order can be only 'asc' or 'desc'")
        }
        return list
    }


    static List getSortedListOfMapsByTextEntity(List<Map> list, def sortBy, String sortOrder = "asc") {
        def collator = Collator.getInstance(Locale.ENGLISH)
        Closure closure = { map1, map2 -> collator.compare(map1[sortBy].toString().toLowerCase(), map2[sortBy].toString().toLowerCase()) }
        if (sortOrder.equalsIgnoreCase("asc")) {
            list.sort { map1, map2 -> collator.compare(map1[sortBy].toString().toLowerCase(), map2[sortBy].toString().toLowerCase()) }
        } else if (sortOrder.equalsIgnoreCase("desc")) {
            list.sort { map1, map2 -> collator.compare(map2[sortBy].toString().toLowerCase(), map1[sortBy].toString().toLowerCase()) }
        }
        else {
            throw new Exception("[getSortedListOfMapsByTextEntity]: Sort order can be only 'asc' or 'desc'")
        }
        return list
    }
}
