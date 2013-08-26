/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.interview;

/**
 *
 * @author Kane.Sun
 *
 */

/*
 *requirement : as a number which is more than 1 , could be plus or minus 1 , or divid 2.need the least steps to conver the number to 1
 * eg : when the number is 7.we need at least 4 steps as follow
 * 
 * n = 7
 * n-1 6
 * n/2 3
 * n-1 2
 * n/2 1
 */
public class ConvertBigNumberToOne {

    public static void main(String... args) {
        int i = (int)(Math.random()*1000)+2;
        System.out.println("the test number : "+i);
        System.out.println("how many steps : " + countSteps(i));
    }

    public static int countSteps(int num) {
        int counter = 0;
        while (num != 1) {

            if (num == 3) {
                counter += 2;
                break;
            }

            if (num % 2 == 0) {
                num = num/2;
                counter++;
            } else if ("11".equals(getBinaryEndNumber(num))) {
                num++;
                counter++;
            } else {
                num--;
                counter++;
            }
        }
        return counter;
    }

    private static String getBinaryEndNumber(int number) {
        String binaryNumber = Integer.toBinaryString(number);
        return binaryNumber.substring(binaryNumber.length() - 3, binaryNumber.length() - 1);
    }
}
