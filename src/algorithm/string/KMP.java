/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.string;

import util.KaneUtil;

/**
 *
 * @author Kane
 */
public class KMP {

    static int[] nextArray;
    static String source = "abababcaba";
    static String pattern = "ababc";

    public KMP() {
        nextArray = generateNextArray(pattern);
    }

    public static void main(String... args) {

        KaneUtil.printIntArray(generateNextArray("ababc"));
        System.out.println(search(source, pattern));

    }

    public static int[] generateNextArray(String pattern) {

        int[] next = new int[pattern.length()];
        next[0] = next[1] = 0;

        for (int i = 2; i < pattern.length(); i++) {
            if (next[i - 1] == 0) {
                if (pattern.charAt(i - 1) != pattern.charAt(0)) {
                    next[i] = 0;
                } else {
                    next[i] = 1;
                }
            } else {
                if (pattern.charAt(i - 1) == pattern.charAt(next[i - 1])) {
                    next[i] = next[i - 1] + 1;
                } else {
                    if (pattern.charAt(i) == pattern.charAt(0)) {
                        next[i] = 1;
                    } else {
                        next[i] = 0;
                    }
                }
            }
        }

        return next;
    }

    public static int search(String source, String pattern) {

        int patternIndex = 0;
        int[] next = generateNextArray(pattern);
        for (int i = 0; i < source.length(); i++) {

            if (source.charAt(i) == pattern.charAt(patternIndex)) {
                patternIndex++;
                if (patternIndex == pattern.length()) {
                    return i-patternIndex+1;
                } else {
                    continue;
                }

            } else {
                patternIndex = next[patternIndex];
                if (source.charAt(i) == pattern.charAt(patternIndex)) {
                    patternIndex++;
                } else {
                    patternIndex = 0;
                }
            }
        }

        return 0;
    }

}
