package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    소수구하기_1929().solution()
}

class 소수구하기_1929 {
    fun solution() {
        val (n, m) = BufferedReader(InputStreamReader(System.`in`)).readLine().split(" ").map { it.toInt() }
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        for(i in n .. m) {
            if(isPrime(i.toLong())) bw.write("$i\n")
        }
        bw.flush()
        bw.close()
    }

    private fun isPrime(n: Long): Boolean = n > 1 && (2 .. kotlin.math.sqrt(n.toDouble()).toInt()).none { n % it == 0L }
}