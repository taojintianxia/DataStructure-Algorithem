/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.string;

/**
 *
 * @author Kane.Sun
 */
public class BF {

    public static void main(String... args) {
        String source = "abcddsdsadx";
        String pattern = "dx";

        System.out.println(search(source, pattern));
    }

    public static int search(String source, String pattern) {
        //when patern.length < source.length , error

        int index = 0;

        for (int i = 0; i < source.length(); i++) {
            index = i;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == source.charAt(i)) {
                    i++;
                } else {
                    i = index;
                    j = 0;
                    break;
                }

                if (i - index == pattern.length()) {
                    return index;
                }
            }
        }

        return 0;
    }
}
