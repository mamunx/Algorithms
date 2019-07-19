package javaLang;

import java.util.ArrayList;
import java.util.Arrays;

import static utility.Utility.arrayToString;

public class ThreeNumberSum {

    /*
     * The Three Number Sum Problem
     *
     * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
     * The function should find all triplets in the array that sum up to the target sum and return a two-dimensional
     * array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets
     * themselves should be ordered in ascending order with respect to the numbers they hold. If no three numbers sum up
     *  to the target sum, the function should return an empty array.
     *
     * Sample input: [12, 3, 1, 2, -6, 5, -8, 6], 0
     * Sample output: [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
     * */


    //Solutions

    /*
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     *
     * This algorithm uses very simple logic,
     * 1. We use three loops, iterating the array, and adding the number and checking with the targetSum
     * */

    private static ArrayList<Integer[]> threeNumberSum1(int[] array, int targetSum) {
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];

            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];

                for (int k = j + 1; k < array.length; k++) {
                    int thirdNum = array[k];

                    if (firstNum + secondNum + thirdNum == targetSum)
                        arrayList.add(new Integer[]{firstNum, secondNum, thirdNum});
                }
            }
        }
        return arrayList;
    }

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * This algorithm uses two index leftIndex and rightIndex,
     * 1. We first sort the array in Ascending order.
     * 2. Then we use a loop to iterate through the array
     * 3. If the left item and the right items addition with the initial item is equal to our target, we return it
     *      and increase the rightIndex and decrease the rightIndex
     * 4. If the sum is less than target, that means the left index should point to the next item
     * 5. If the sum is larger than the target, that means the right index should point to the previous item
     * 6. We end the loop when the indexes collide
     * */

    private static ArrayList<Integer[]> threeNumberSum2(int[] array, int targetSum) {
        ArrayList<Integer[]> newList = new ArrayList();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            int leftIndex = i + 1, rightIndex = array.length - 1;
            while (leftIndex < rightIndex) {
                int currentSum = array[i] + array[leftIndex] + array[rightIndex];
                if (targetSum == currentSum) {
                    newList.add(new Integer[]{array[i], array[leftIndex], array[rightIndex]});
                    leftIndex++;
                    rightIndex--;
                } else if (currentSum <= targetSum) leftIndex++;
                else rightIndex--;
            }
        }
        return newList;
    }

    public static void runThreeNumberSumTest() {
        int[] sampleArray = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        ArrayList<Integer[]> arrayList = ThreeNumberSum.threeNumberSum1(sampleArray, 0);

        System.out.println("Java: Three Number Sum problem using only loops");

        for (Integer[] integers : arrayList)
            System.out.println(arrayToString(integers));

        arrayList = ThreeNumberSum.threeNumberSum2(sampleArray, 0);

        System.out.println("Java: Three Number Sum problem using Start and End Index");

        for (Integer[] integers : arrayList)
            System.out.println(arrayToString(integers));
    }
}