package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val stack = Stack<Int>()
    val num: Int = readLine().toInt()
    for(n in 0 until num) {
        val st = StringTokenizer(readLine(), " ")
        when(st.nextToken()) {
            "push" -> stack.push(st.nextToken().toInt())
            "pop" -> bw.write(if(stack.empty()) "-1\n" else "${stack.pop()}\n")
            "size" -> bw.write("${stack.size}\n")
            "empty" -> bw.write(if(stack.empty()) "1\n" else "0\n")
            "top" -> bw.write(if(stack.empty()) "-1\n" else "${stack.peek()}\n")
        }
    }
    bw.flush()
    bw.close()
    close()
}