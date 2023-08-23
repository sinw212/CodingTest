package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val queue: Queue<Int> = LinkedList()
    val num: Int = readLine().toInt()
    var lastNum = 0
    for(n in 0 until num) {
        val st = StringTokenizer(readLine(), " ")
        when(st.nextToken()) {
            "push" -> {
                val num: Int = st.nextToken().toInt()
                queue.add(num)
                lastNum = num
            }
            "pop" -> bw.write(if(queue.isEmpty()) "-1\n" else "${queue.poll()}\n")
            "size" -> bw.write("${queue.size}\n")
            "empty" -> bw.write(if(queue.isEmpty()) "1\n" else "0\n")
            "front" -> bw.write(if(queue.isEmpty()) "-1\n" else "${queue.peek()}\n")
            "back" -> bw.write(if(queue.isEmpty()) "-1\n" else "$lastNum\n")
        }
    }
    bw.flush()
    bw.close()
    close()
}