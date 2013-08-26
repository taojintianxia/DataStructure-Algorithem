/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.interview;

/**
 *
 * @author Kane.Sun
 */
public class MaxmizeSubArraySum {

    public static void main(String... args) {
        int[] testArray = {2, 4, 1, 16, 7, 5, 11, 9};
        maxSubArraySum(testArray);
    }

    public static void maxSubArraySum(int[] array) {
        int start = 0;
        int end = 0;
        int tempSum = 0;
        int mostSum = 0;
        int[] diffArray = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            diffArray[i] = array[i] - array[i + 1];
        }

        for (int i = 0; i < diffArray.length; i++) {
            tempSum += diffArray[i];
            if (tempSum < 0) {
                tempSum = 0;
            } else {
                if (tempSum == diffArray[i]) {
                    start = i;
                }
            }

            if (mostSum < tempSum) {
                mostSum = tempSum;
                end = i;
            }
        }

        System.out.println(mostSum);
        System.out.println("start : " + array[start]);
        System.out.println("end : " +array[end+1]);
    }
}
