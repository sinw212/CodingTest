package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Deque
import java.util.LinkedList
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine(), " ")
    val queSize = st.nextToken().toInt()
    val count = st.nextToken().toInt()
    st = StringTokenizer(readLine(), " ")
    val deque: Deque<Int> = LinkedList()
    for (i in 1..queSize) {
        deque.addLast(i)
    }

    var answer = 0
    for (i in 0 until count) {
        var num = st.nextToken().toInt()

        if (deque.indexOf(num)+1 > deque.size / 2 + 1) {
            while (num != deque.peekFirst()) {
                deque.addFirst(deque.pollLast())
                answer++
            }
        } else {
            while (num != deque.peekFirst()) {
                deque.addLast(deque.pollFirst())
                answer++
            }
        }
        deque.pop()
    }
    println(answer)
    close()
}