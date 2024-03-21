package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    숫자카드2_10816().solution()
}

class 숫자카드2_10816 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val map = HashMap<Int, Int>()
        repeat(n) {
            val num = st.nextToken().toInt()
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val m = readLine().toInt()
        st = StringTokenizer(readLine(), " ")
        repeat(m) {
            bw.write("${map[st.nextToken().toInt()] ?: 0} ")
        }
        bw.flush()
        bw.close()
    }

    /*
    //이진탐색 사용한 방법
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val nums = IntArray(n) { st.nextToken().toInt() }
        val map = hashMapOf<Int, Int>()
        for(num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        val sortedNums = nums.distinct().sorted()

        val m = readLine().toInt()
        st = StringTokenizer(readLine(), " ")
        val search = IntArray(m) { st.nextToken().toInt() }

        for(i in search.indices) {
            search[i] = if(searchBinary(search[i], sortedNums)) map[search[i]] ?: 0 else 0
        }
        println(search.joinToString(" "))
    }

    fun searchBinary(num: Int, nums: List<Int>): Boolean {
        var left = 0
        var right = nums.size - 1
        while(left <= right) {
            val mid = (left + right) / 2
            when {
                nums[mid] == num -> return true
                nums[mid] < num -> left = mid + 1
                nums[mid] > num -> right = mid - 1
            }
        }
        return false
    }
     */
}