package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val num = readLine().toInt()
    val deque = ArrayDeque<Int>()
    for(num in 0 until num) {
        val st = StringTokenizer(readLine(), " ")
        when(st.nextToken()) {
            "push_front" -> deque.addFirst(st.nextToken().toInt())
            "push_back" -> deque.addLast(st.nextToken().toInt())
            "pop_front" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.pollFirst()}\n")
            "pop_back" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.pollLast()}\n")
            "size" -> bw.write("${deque.size}\n")
            "empty" -> bw.write(if(deque.isEmpty()) "1\n" else "0\n")
            "front" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.peekFirst()}\n")
            "back" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.peekLast()}\n")
        }
    }
    bw.flush()
    bw.close()
    close()
}