package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    for(n in 0 until num) {
        var st = StringTokenizer(readLine(), " ")
        val count = st.nextToken().toInt()
        val findIndex = st.nextToken().toInt()
        st = StringTokenizer(readLine(), " ")

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        for(i in 0 until count) {
            val token = st.nextToken().toInt()
            queue.offer(Pair(token, i))
            pq.offer(token)
        }
        println(queue.toString())
        println(pq.toString())

        var result = 0
        while(!queue.isEmpty()) {
            val printQ = queue.poll()
            println("${printQ.first}, ${pq.peek()}")
            if(printQ.first == pq.peek()) {
                result++
                pq.poll()
                if(printQ.second == findIndex) break
            } else {
                queue.offer(printQ)
            }
        }
        println(result)
    }
    close()
}