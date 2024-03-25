package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    잠수함식별_2671().solution()
}

class 잠수함식별_2671 {
    fun solution() = println(if(BufferedReader(InputStreamReader(System.`in`)).readLine().matches(Regex("(100(0*)1(1*)|01)+"))) "SUBMARINE" else "NOISE")
}