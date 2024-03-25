package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    문서검색_1543().solution()
}

class 문서검색_1543 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        var doc = readLine()
        val word = readLine()
        println((doc.length - doc.replace(word, "").length) / word.length)
    }
}