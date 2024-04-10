package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    스택수열_1874().solution()
}

class 스택수열_1874 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = IntArray(n) { readLine().toInt() }

        val stack = Stack<Int>()
        val sb = StringBuilder()
        var cnt = 0
        for(i in 1 .. n) {
            stack.add(i)
            sb.append("+").append("\n")
            while(stack.isNotEmpty()) {
                if(stack.peek() == arr[cnt]) {
                    sb.append("-").append("\n")
                    stack.pop()
                    cnt++
                } else {
                    break
                }
            }
        }
        println(if(stack.isEmpty()) sb else "NO")
    }
}