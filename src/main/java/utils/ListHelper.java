package utils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ListHelper {

    public enum sortOrder {
        ASC,
        DESC
    }


    public static List<Map<String, Object>> getDoubleSorted(List<Map<String, Object>> listToSort,
                                                            String sortKey1, String sortKey2,
                                                            sortOrder sortOrder1, sortOrder sortOrder2) {
        List<Map<String, Object>> sortedList;
        Comparator<String> order1 = (sortOrder1.equals(sortOrder.ASC)) ? Comparator.naturalOrder() : Comparator.reverseOrder();
        Comparator<String> order2 = (sortOrder2.equals(sortOrder.ASC)) ? Comparator.naturalOrder() : Comparator.reverseOrder();


        sortedList = listToSort.stream().sorted(
                Comparator.comparing(
                        (Map<String, Object> a) -> (String) a.get(sortKey1), order2
                ).thenComparing(
                        (Map<String, Object> a) -> (String) a.get(sortKey2), order2
                )
        ).toList();
        return sortedList;
    }
}
