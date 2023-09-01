package com.example.kotlincodingtest.programmers.running

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(Solution다리를지나는트럭().solution(100, 100, intArrayOf(10)))
}

class Solution다리를지나는트럭 {
    private val queue: Queue<Int> = LinkedList()
    var front = 0
    var rear = 0
    var count = 0
    var time = 0
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var i = 0
        while(i < truck_weights.size) {
            if(empty()) {
                push(truck_weights[i])
                i++
            } else if(full() == bridge_length) {
                pop()
                time--
            } else {
                if(count + truck_weights[i] <= weight) {
                    push(truck_weights[i])
                    i++
                } else {
                    push(0)
                }
            }
            time++
        }
        return time + bridge_length
    }

    private fun empty(): Boolean = (rear - front) == 0

    private fun full(): Int = rear - front

    private fun push(n: Int) {
        queue.add(n)
        rear++
        count += n
    }

    private fun pop() {
        count -= queue.peek()
        queue.poll()
        front++
    }
}