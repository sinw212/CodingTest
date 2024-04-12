package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    AC_5430().solution()
}

class AC_5430 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(tc) {
            val p = readLine()
            val n = readLine().toInt()
            val str = readLine()
            val splitArr = str.substring(1, str.length - 1).split(",")

            val deque = ArrayDeque<String>()
            for(i in splitArr) {
                deque.add(i)
            }
            var dir = "L"
            var isStop = false
            for(i in p.indices) {
                when(p[i]) {
                    'R' -> dir = if(dir == "L") "R" else "L"
                    'D' -> {
                        if(deque.isEmpty() || deque.first() == "") {
                            isStop = true
                            break
                        }
                        if(dir == "L") deque.removeFirst() else deque.removeLast()
                    }
                }
            }

            if(isStop) {
                bw.write("error\n")
            } else {
                val answer = Array(deque.size) { "" }
                if(dir == "L") {
                    repeat(deque.size) {
                        answer[it] = deque.first()
                        deque.removeFirst()
                    }
                } else {
                    repeat(deque.size) {
                        answer[it] = deque.last()
                        deque.removeLast()
                    }
                }
                bw.write("[${answer.joinToString(",")}]\n")
            }
        }
        bw.flush()
        bw.close()
    }
}