package algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchCommonDataInTwoArray {

    public static void main(String... args) {
        int[] arrayA = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 8};
        int[] arrayB = new int[]{4, 7};
        List commenData = findCommon(arrayA, arrayB);

        Iterator it = commenData.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static List<Integer> findCommon(int[] arrayA, int[] arrayB) {
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        List<Integer> tempList = new ArrayList<Integer>();
        Integer counter = 0;
        for (int i : arrayB) {
            if (mapB.get(Integer.valueOf(i)) != null) {
                counter = mapB.get(Integer.valueOf(i));
                counter++;
            }
            mapB.put(Integer.valueOf(i), Integer.valueOf(counter));
        }

        for (int i : arrayA) {
            if (mapB.get(Integer.valueOf(i)) != null) {
                tempList.add(i);
            }
        }

        return tempList;
    }
}
