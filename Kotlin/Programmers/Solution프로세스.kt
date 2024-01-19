package com.example.kotlincodingtest.programmers.running

import java.util.Collections
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    println(Solution프로세스().solution(intArrayOf(2, 1, 3, 2), 2))
    println(Solution프로세스().solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}

class Solution프로세스 {
    fun solution(priorities: IntArray, location: Int): Int {
        var time = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

        priorities.forEachIndexed { index, value -> queue.add(index to value) }
        priorities.forEach { value -> pq.add(value) }

        while(pq.isNotEmpty()) {
            if(queue.peek().second == pq.peek()) {
                time++
                if(queue.peek().first == location) {
                    break
                }
                pq.poll()
                queue.poll()
            } else {
                queue.add(queue.poll())
            }
        }
        return time
    }
}