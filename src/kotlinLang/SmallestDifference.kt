package kotlinLang

import utility.Utility
import java.util.*
import kotlin.math.abs

class SmallestDifference {
    /*
     * The Smallest Difference Problem
     *
     * Category: Array
     * Difficulty: Medium
     *
     * Write a function that takes in two non-empty arrays of integers. The function should find the pair of numbers
     * (one from the first array, one from the second array) whose absolute difference is closest to zero. The function
     * should return an array containing these two numbers, with the number from the first array in the first position.
     * Assume that there will only be one pair of numbers with the smallest difference.
     *
     * Sample input: [-1, 5, 10, 20, 28, 3], [26, 134, 135, 15, 17]
     * Sample output: [28, 26]
     * */


    //Solutions

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * This algorithm uses very simple logic,
     * 1. We use two loops, iterating the array, and adding the number and checking with the targetSum
     * */

    private fun smallestDifference1(arrayOne: IntArray, arrayTwo: IntArray): IntArray {

        var smallestArr = intArrayOf()
        var smallestDiff = Int.MAX_VALUE
        var currentDiff: Int

        for (value1 in arrayOne) {
            for (value2 in arrayTwo) {
                if (value1 == value2) {
                    smallestArr = intArrayOf(value1, value2)
                    return smallestArr
                } else {
                    currentDiff = abs(value1 - value2)
                    if (currentDiff < smallestDiff) {
                        smallestDiff = currentDiff
                        smallestArr = intArrayOf(value1, value2)
                    }
                }
            }
        }
        return smallestArr
    }

    /*
     * Time Complexity: O(nlog(n) + mlog(m))
     * Space Complexity: O(1)
     *
     * This algorithm uses one index for each array,
     * 1. We start by sorting both arrays
     * 2. Then use iterate through both arrays using a while loop
     * 3. To iterate, we use two indices and keep the currentDifference, if the numbers are equal, return them.
     * 4. As the arrays are sorted, if the firstNumber is larger than the secondNumber,
     *      then increasing the firstIndex will increase the difference even more,
     *      so we increase the second index.
     * 5. If the secondNumber is larger than the firstNumber, then we increase the first Index
     * 6. Finally if the currentDiff is smaller than smallestDiff , then we update the smallestDiff and smallestArray
     * 7. At the end of loop, we return the smallestArray
     * */

    private fun smallestDifference2(arrayOne: IntArray, arrayTwo: IntArray): IntArray {

        var smallestArr = intArrayOf()
        var smallestDiff = Int.MAX_VALUE
        var currentDiff: Int
        var indexOne = 0
        var indexTwo = 0

        Arrays.sort(arrayOne)
        Arrays.sort(arrayTwo)

        while (indexOne < arrayOne.size && indexTwo < arrayTwo.size) {
            val numOne = arrayOne[indexOne]
            val numTwo = arrayTwo[indexTwo]

            when {
                numOne > numTwo -> {
                    currentDiff = numOne - numTwo
                    indexTwo++
                }
                numTwo > numOne -> {
                    currentDiff = numTwo - numOne
                    indexOne++
                }
                else -> {
                    smallestArr = intArrayOf(numOne, numTwo)
                    return smallestArr
                }
            }

            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff
                smallestArr = intArrayOf(numOne, numTwo)
            }
        }
        return smallestArr
    }

    fun runSmallestDifferenceTest() {

        val arr1 = intArrayOf(-1, 5, 10, 20, 28, 3)
        val arr2 = intArrayOf(26, 134, 135, 15, 17)

        var resultArr = smallestDifference1(arr1, arr2)
        println("Kotlin: Smallest Difference Problem using 2 Loops: ")
        println(Utility.intArrayToString(resultArr))

        resultArr = smallestDifference2(arr1, arr2)
        println("Kotlin: Smallest Difference Problem using Index ")
        println(Utility.intArrayToString(resultArr))
    }
}