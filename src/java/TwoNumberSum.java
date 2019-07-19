package java;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {

    /*
     * The Two Number Sum Problem
     *
     * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
     * If any two numbers in the input array sum up to the target sum, the function should return them in an array,
     * in sorted order. If no two numbers sum up to the target sum, the function should return an empty array.
     * Assume that there will be at most one pair of numbers summing up to the target sum.
     *
     * Sample input: [3, 5, -4, 8, 11, 1, -1, 6], 10
     * Sample output: [-1, 11]
     * */


    //Solutions

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * This algorithm uses very simple logic,
     * 1. We use two loops, iterating the array, and adding the number and checking with the targetSum
     * */

    public static int[] twoNumberSum1(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];

            for (int j = i; j < array.length; j++) {
                int secondNum = array[j];

                if (firstNum + secondNum == targetSum) return new int[]{firstNum, secondNum};
            }
        }
        return new int[0];
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * This algorithm uses A HashMap and a simple formula,
     * 1. We Iterate the array once, at each iteration:
     *      a. We subtract the item with target sum,
     *      b. check if the new value is in the hashMap, if its not then add it,
     *      c. If its in the hashMap then return item with the subtracted value.
     * */
    public static int[] twoNumberSum2(int[] array, int targetSum) {

        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int num : array) {
            int potentialNum = targetSum - num;
            if (hashMap.containsKey(potentialNum)) return new int[]{num, potentialNum};
            else hashMap.put(num, true);
        }

        return new int[0];
    }


    /*
     * Time Complexity:
     * Space Complexity:
     *
     * This algorithm uses two index leftIndex and rightIndex,
     * 1. We first sort the array in Ascending order.
     * 2. Then we use a loop to iterate through the array
     * 3. If the left item and the right items addition is equal to our target, we return it
     * 4. If the sum is less than target, that means the left index should point to the next item
     * 5. If the sum is larger than the target, that means the right index should point to the previous item
     * 6. We end the loop when the indexes collide
     * */
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftIndex = 0, rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            int current = array[leftIndex] + array[rightIndex];
            if (targetSum == current) return new int[]{array[leftIndex], array[rightIndex]};
            else if (current <= targetSum) leftIndex += 1;
            else rightIndex -= 1;
        }

        return new int[0];
    }
}