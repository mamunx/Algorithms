package kotlin

import java.util.*

class TwoNumberSum {
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

    fun twoNumberSum1(array: IntArray, targetSum: Int): IntArray {
        for (i in 0 until array.size - 1) {
            val firstNum = array[i]

            for (j in i until array.size) {
                val secondNum = array[j]

                if (firstNum + secondNum == targetSum) return intArrayOf(firstNum, secondNum)
            }
        }
        return IntArray(0)
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
    fun twoNumberSum2(array: IntArray, targetSum: Int): IntArray {

        val hashMap = HashMap<Int, Boolean>()

        for (num in array) {
            val potentialNum = targetSum - num
            if (hashMap.containsKey(potentialNum))
                return intArrayOf(num, potentialNum)
            else
                hashMap[num] = true
        }

        return IntArray(0)
    }


    /*
     * Time Complexity: O(nlog(n))
     * Space Complexity: O(1)
     *
     * This algorithm uses two index leftIndex and rightIndex,
     * 1. We first sort the array in Ascending order.
     * 2. Then we use a loop to iterate through the array
     * 3. If the left item and the right items addition is equal to our target, we return it
     * 4. If the sum is less than target, that means the left index should point to the next item
     * 5. If the sum is larger than the target, that means the right index should point to the previous item
     * 6. We end the loop when the indexes collide
     * */
    fun twoNumberSum3(array: IntArray, targetSum: Int): IntArray {
        Arrays.sort(array)
        var leftIndex = 0
        var rightIndex = array.size - 1

        while (leftIndex < rightIndex) {
            val current = array[leftIndex] + array[rightIndex]
            when {
                targetSum == current -> return intArrayOf(array[leftIndex], array[rightIndex])
                current <= targetSum -> leftIndex += 1
                else -> rightIndex -= 1
            }
        }

        return IntArray(0)
    }
}