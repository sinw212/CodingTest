package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    val str1 = readLine().reversed()
    val str2 = readLine()
    val time = readLine().toInt()

    val ants = mutableListOf<Pair<Char, Int>>()

    for (ch1 in str1) {
        ants.add(Pair(ch1, 1))
    }

    for (ch2 in str2) {
        ants.add(Pair(ch2, 2))
    }

    repeat(time) {
        var i = 0
        while (i < ants.size - 1) {
            val current = ants[i]
            val next = ants[i + 1]
            if (current.second != 2 && current.second != next.second) {
                ants[i] = next
                ants[i + 1] = current
                i++
            }
            i++
        }
    }

    val result = ants.joinToString("") { it.first.toString() }
    println(result)

    close()
}