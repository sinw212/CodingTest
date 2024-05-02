package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    강의실배정_11000().solution()
}

class 강의실배정_11000 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val classes = Array(n) { Cls(0, 0) }
        repeat(n) { c ->
            val (s, t) = readLine().split(" ").map { it.toInt() }
            classes[c] = Cls(s, t)
        }
        val sortedList = classes.sortedWith(compareBy { it.s })

        var answer = 0
        val pq = PriorityQueue<Int>()

        sortedList.forEach { cls ->
            pq.offer(cls.t)
            while (pq.isNotEmpty() && pq.peek() <= cls.s) {
                pq.poll()
            }
            answer = maxOf(answer, pq.size)
        }
        println(answer)

        /*
        //아래 두 방법처럼 풀면 시간복잡도 O(N^2)으로 시간초과 발생 - 그리디 & 우선순위큐로 해결
        var answer = 0
        for(i in classes.indices) {
            if(!classes[i].visited) {
                answer += 1
                classes[i] = classes[i].copy(visited = true)
                var current = classes[i]
                for(j in i+1 until classes.size) {
                    if(classes[j].s >= current.t && !classes[j].visited) {
                        classes[j] = classes[j].copy(visited = true)
                        current = classes[j]
                    }
                }
            }
        }
        println(answer)

        val queue: Queue<Class> = LinkedList()
        classes.forEach {
            queue.add(it)
        }
        var current = queue.poll()
        while(queue.isNotEmpty()) {
            println(queue)
            if(current.cnt != queue.peek().cnt) {
                current = queue.poll()
                if(queue.size == 0) {
                    break
                }
            }
            if(current.t <= queue.peek().s) {
                current = queue.poll()
            } else {
                val poll = queue.poll()
                queue.add(Class(poll.s, poll.t, poll.cnt+1))
            }
        }
        println(current.cnt)
         */
    }
}

data class Cls(val s: Int, val t: Int)