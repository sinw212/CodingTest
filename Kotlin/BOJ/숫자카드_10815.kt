package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    숫자카드_10815().solution()
}

class 숫자카드_10815 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val nArr = IntArray(n) { st.nextToken().toInt() }
        nArr.sort()
        val m = readLine().toInt()
        st = StringTokenizer(readLine(), " ")
        val mArr = IntArray(m) { st.nextToken().toInt() }

        /*
        //아래처럼 풀면 시간초과 발생 - 이진탐색으로 수정
        for(i in mArr.indices) {
            mArr[i] = if(nArr.contains(mArr[i])) 1 else 0
        }
         */
        for(i in mArr.indices) {
            mArr[i] = searchBinary(mArr[i], nArr)
        }

        println(mArr.joinToString(" "))
    }

    fun searchBinary(mNum: Int, nArr: IntArray): Int {
        var left = 0
        var right = nArr.size - 1
        while(left <= right) {
            var mid = (left + right) / 2
            when {
                mNum == nArr[mid] -> return 1
                mNum < nArr[mid] -> right = mid - 1
                mNum > nArr[mid] -> left = mid + 1
            }
        }
        return 0
    }
}