/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Kane.Sun
 */
//given an array contains the share price and corresponding time in a whole day , to get the best buy and sell time to make the stock maximum
public class MaximizeSharePrice {
    //I guess we use a map to store the info , key for time , value for share price

    public static void main(String... args) {
        Map<String, Integer> sharePrice = new LinkedHashMap<String, Integer>();
        sharePrice = generateTestData();
        int[] priceArray = toPrimitive(sharePrice.values().toArray(new Integer[sharePrice.size()]));

        String[] timeArray = sharePrice.keySet().toArray(new String[sharePrice.size()]);

        int[] timeIndexes = getTheMaximumDifferenceIndex(priceArray);
        if (timeIndexes[0] == 0 && timeIndexes[1] == 0) {
            System.out.println("shit , it's alwasy jumping , don't buy anything");
        } else {
            System.out.println("we should buy stock at " + timeArray[timeIndexes[0]]);
            System.out.println("we should sell stock at " + timeArray[timeIndexes[1]]);
        }


    }

    private static int[] getTheMaximumDifferenceIndex(int[] priceArray) {
        int tempSum = 0;
        int minSum = 0;
        int preIndex = 0;
        int sufIndex = 0;

        int[] priceDiffArray = new int[priceArray.length - 1];
        for (int i = 0; i < priceArray.length - 1; i++) {
            priceDiffArray[i] = priceArray[i] - priceArray[i + 1];
        }
        int[] indexArray = new int[2];
        for (int i = 0; i < priceDiffArray.length; i++) {
            tempSum += priceDiffArray[i];
            if (tempSum > 0) {
                tempSum = 0;
            } else {
                if (tempSum == priceDiffArray[i]) {
                    preIndex = i;
                }
            }

            if (minSum > tempSum) {
                minSum = tempSum;
                sufIndex = i;
            }
        }

        indexArray[0] = preIndex;
        indexArray[1] = sufIndex + 1;

        return indexArray;
    }

    private static Map<String, Integer> generateTestData() {
        Map<String,Integer> data = new LinkedHashMap<String,Integer>();
        data.put("9:10", 31);
        data.put("10:20", -41);
        data.put("11:00", 59);
        data.put("12:09", 26);
        data.put("14:08", -53);
        data.put("14:20", 58);
        data.put("14:50", 97);
        data.put("14:58", -93);
        data.put("15:10", -23);
        data.put("15:40", 84);

        return data;
    }

    public static int[] toPrimitive(Integer[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            return new int[0];
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            result[i] = array[i].intValue();
        }
        return result;
    }
}
