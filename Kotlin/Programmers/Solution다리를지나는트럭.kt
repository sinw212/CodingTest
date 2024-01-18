package com.example.kotlincodingtest.programmers.running

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(Solution다리를지나는트럭_2().solution(2, 10, intArrayOf(7,4,5,6)))
    println(Solution다리를지나는트럭_2().solution(100, 100, intArrayOf(10)))
    println(Solution다리를지나는트럭_2().solution(100, 100, intArrayOf(10,10,10,10,10,10,10,10,10,10)))
}

class Solution다리를지나는트럭_2 {
    private val queue: Queue<Int> = LinkedList()
    private var rear: Int = 0
    private var front: Int = 0
    private var weightCount: Int = 0
    private var time: Int = 0
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
                if(weightCount + truck_weights[i] <= weight) {
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

    private fun empty(): Boolean = rear == front

    private fun full(): Int = rear - front

    private fun push(num: Int) {
        queue.add(num)
        rear++
        weightCount += num
    }

    private fun pop() {
        weightCount -= queue.peek()
        queue.poll()
        front++
    }
}