/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.array;

/**
 *
 * @author Kane.Sun
 *
 */
public class ArrayLineRowRevert {

    public static void main(String... args) {
        String[][] tempStringArray = new String[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                tempStringArray[i][j] = (int) (100 * Math.random()) + "";
            }
        }
        
        printTwoDementionalArray(tempStringArray);
        reverArrayOrder(tempStringArray);
    }

    private static void printTwoDementionalArray(String[][] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                System.out.print(stringArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void reverArrayOrder(String[][] origenalStringArray){
        String[][] targetArray = new String[origenalStringArray[0].length][origenalStringArray.length];
        
        for(int i = 0 ; i < origenalStringArray[0].length ; i++){
            for(int j = 0 ; j < origenalStringArray.length ; j++){
                targetArray[i][j] = origenalStringArray[origenalStringArray.length-j-1][i];
            }
        }
        
        printTwoDementionalArray(targetArray);
    }
}
