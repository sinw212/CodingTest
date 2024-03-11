package com.example.kotlincodingtest.programmers.running

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    println(Solution이중우선순위큐().solution(arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")).joinToString(", ")) //[0,0]
    println(Solution이중우선순위큐().solution(arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")).joinToString(", ")) //[333, -45]
}

class Solution이중우선순위큐 {
    fun solution(operations: Array<String>): IntArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        operations
            .map { it.split(" ") }
            .map { Pair(it[0], it[1]) }
            .forEach { operation ->
                when(operation.first) {
                    "I" -> {
                        minHeap.add(operation.second.toInt())
                        maxHeap.add(operation.second.toInt())
                    }
                    "D" -> when(operation.second) {
                            "1" -> { //최댓값 삭제
                                if(maxHeap.isNotEmpty()) {
                                    minHeap.remove(maxHeap.peek())
                                    maxHeap.poll()
                                }
                            }
                            "-1" -> { //최솟값 삭제
                                if(minHeap.isNotEmpty()) {
                                    maxHeap.remove(minHeap.peek())
                                    minHeap.poll()
                                }
                            }
                        }
                }
            }

        return intArrayOf(
            if(maxHeap.isEmpty()) 0 else maxHeap.poll(),
            if(minHeap.isEmpty()) 0 else minHeap.poll()
        )

        /*
        //데크 사용
        val deque = ArrayDeque<Int>()
        operations.forEach { operation ->
            val str = operation.split(" ")
            when(str[0]) {
                "I" -> deque.addLast(str[1].toInt())
                "D" -> {
                    if(deque.isNotEmpty()) {
                        when(str[1]) {
                            "1" -> deque.remove(deque.maxOrNull())
                            "-1" -> deque.remove(deque.minOrNull())
                        }
                    }
                }
            }
        }
        return if(deque.isNotEmpty()) intArrayOf(deque.maxOrNull() ?: 0, deque.minOrNull() ?: 0) else intArrayOf(0, 0)
         */
    }
}