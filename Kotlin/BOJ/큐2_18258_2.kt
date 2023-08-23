package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val num: Int = readLine().toInt()
    val queue = ArrayQueue()

    for(n in 0 until num) {
        val st = StringTokenizer(readLine(), " ")
        when(st.nextToken()) {
            "push" -> queue.push(st.nextToken().toInt())
            "pop" -> sb.append(if(queue.isEmpty()) "-1\n" else "${queue.pop()}\n")
            "size" -> sb.append("${queue.size()}\n")
            "empty" -> sb.append(if(queue.isEmpty()) "1\n" else "0\n")
            "front" -> sb.append(if(queue.isEmpty()) "-1\n" else "${queue.front()}\n")
            "back" -> sb.append(if(queue.isEmpty()) "-1\n" else "${queue.back()}\n")
        }
    }
    println(sb.toString())
    close()
}

class ArrayQueue() {
    private var rear = -1
    private var front = 0
    private val queue = arrayListOf<Int>()

    fun isEmpty(): Boolean = (rear + 1 == front)

    fun size(): Int = rear - front + 1

    fun push(num: Int) {
        queue.add(num)
        rear++
    }

    fun pop(): Int {
        front++
        return queue[front-1]
    }

    fun front(): Int = queue[front]

    fun back(): Int = queue[rear]
}