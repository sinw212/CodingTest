package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val uspsArr = arrayListOf<Int>()
    for(i in 0 until N) {
        uspsArr.add(i+1)
    }

    val answer = arrayListOf<Int>()
    var popIndex = 0
    while(uspsArr.size > 1) {
        popIndex = (popIndex + (K - 1)) % uspsArr.size
        answer.add(uspsArr.removeAt(popIndex))
    }
    answer.add(uspsArr.removeAt(0))
    println("<${answer.joinToString(", ")}>")

    close()
}