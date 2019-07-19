@file: JvmName("KotlinThreeNumberSum")

package kotlinLang

import utility.Utility.arrayToString
import java.util.*

class ThreeNumberSum {
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

    private fun threeNumberSum1(array: IntArray, targetSum: Int): ArrayList<Array<Int>> {
        val arrayList = ArrayList<Array<Int>>()
        for (i in 0 until array.size - 1) {
            val firstNum = array[i]

            for (j in i + 1 until array.size) {
                val secondNum = array[j]

                for (k in j + 1 until array.size) {
                    val thirdNum = array[k]

                    if (firstNum + secondNum + thirdNum == targetSum)
                        arrayList.add(arrayOf(firstNum, secondNum, thirdNum))
                }
            }
        }
        return arrayList
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

    private fun threeNumberSum2(array: IntArray, targetSum: Int): ArrayList<Array<Int>> {
        val newList = ArrayList<Array<Int>>()
        Arrays.sort(array)

        for (i in array.indices) {
            var leftIndex = i + 1
            var rightIndex = array.size - 1
            while (leftIndex < rightIndex) {
                val currentSum = array[i] + array[leftIndex] + array[rightIndex]
                when {
                    targetSum == currentSum -> {
                        newList.add(arrayOf(array[i], array[leftIndex], array[rightIndex]))
                        leftIndex++
                        rightIndex--
                    }
                    currentSum <= targetSum -> leftIndex++
                    else -> rightIndex--
                }
            }
        }
        return newList
    }

    fun runThreeNumberSumTest() {
        val sampleArray = intArrayOf(12, 3, 1, 2, -6, 5, -8, 6)
        var arrayList = threeNumberSum1(sampleArray, 0)

        println("Kotlin: Three Number Sum problem using only loops")

        for (integers in arrayList)
            println(arrayToString(integers))

        arrayList = threeNumberSum2(sampleArray, 0)

        println("Kotlin: Three Number Sum problem using Start and End Index")

        for (integers in arrayList)
            println(arrayToString(integers))
    }
}