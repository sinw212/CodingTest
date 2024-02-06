package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var count = 0
fun calcNum(n: Long, a: Int, b: Int) {
    if(b < n) {
        return
    }
    if(a <= n) {
        if(n in a..b) count++
    }
    calcNum(n * 10 + 4, a, b)
    calcNum(n * 10 + 7, a, b)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readlnOrNull(), " ")
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    calcNum(4, a, b)
    calcNum(7, a, b)

    println(count)

    /*
    //메모리 초과
    var answer = 0
    for(i in a .. b) {
        var count = 0
        i.toString().forEach {
            if (it.toString() == "4" || it.toString() == "7") count++
        }
        if(count == i.toString().length - 1) answer++
    }
    println(answer)
     */
}