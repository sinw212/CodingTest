package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    염색체_9342().solution()
}

class 염색체_9342 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val num = readLine().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(num) {
            val str = readLine().replace(Regex("^[A-F]?A+F+C+[A-F]?$"), "")
            bw.write(if(str.isEmpty()) "Infected!\n" else "Good\n")
        }
        bw.flush()
        bw.close()
    }
}