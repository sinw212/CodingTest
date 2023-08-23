package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val st = StringTokenizer(readLine(), " ")
    val N: Int = st.nextToken().toInt()
    val K: Int = st.nextToken().toInt()

    val cq = CircleQueue(N, K)
    sb.append("<")
    while(cq.size() != 0) {
        for(i in 1 until K) {
            cq.push()
        }
        sb.append(cq.pop())
        sb.append(", ")
    }
    sb.append("${cq.pop()}>")
    println(sb.toString())
    close()
}

class CircleQueue(N: Int, K: Int) {
    val circleQue = arrayListOf<Int>()
    var rear = -1
    var front = 0
    init {
        for(i in 0 until N) {
            circleQue.add(i+1)
            rear++
        }
    }

    fun size(): Int {
        return front - rear
    }

    fun push() {
        circleQue.add(circleQue[front++])
        rear++
    }

    fun pop(): Int = circleQue[front++]
}