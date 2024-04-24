package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    집합_11723().solution()
}

class 집합_11723 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var arr = hashSetOf<Int>()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(n) {
            val str = readLine().split(" ").map { it }
            when(str[0]) {
                "add" -> arr.add(str[1].toInt())
                "remove" -> arr.remove(str[1].toInt())
                "check" -> bw.write("${if(arr.contains(str[1].toInt())) 1 else 0}\n")
                "toggle" -> if(arr.contains(str[1].toInt())) arr.remove(str[1].toInt()) else arr.add(str[1].toInt())
                "all" -> arr = (1..20).toList().toTypedArray().toHashSet()
                "empty" -> arr = hashSetOf()
            }
        }
        bw.flush()
        bw.close()
    }
}