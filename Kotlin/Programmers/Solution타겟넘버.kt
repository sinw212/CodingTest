package com.example.kotlincodingtest.programmers.running

import java.util.LinkedList

fun main() {
    println(Solution타겟넘버().solution(intArrayOf(1, 1, 1, 1, 1), 3)) //5
    println(Solution타겟넘버().solution(intArrayOf(4, 1, 2, 1), 4)) //2
}

class Solution타겟넘버 {
    fun solution(numbers: IntArray, target: Int): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(0 to numbers[0])
        queue.add(0 to -numbers[0])
        for(i in 1 until numbers.size) {
            while(queue.peek().first == i-1) {
                val current = queue.poll()
                queue.add(i to current.second + numbers[i])
                queue.add(i to current.second - numbers[i])
            }
        }

        var count = 0
        while(queue.isNotEmpty()) {
            if(queue.poll().second == target) {
                count++
            }
        }
        return count

        /*
        //다른 사람 풀이1
        return numbers.fold(listOf(0)) { list, i ->
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
         */
    }
    /*
    //다른사람 풀이2 - DFS 활용
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0)
    }
    fun dfs(numbers: IntArray, target: Int, index: Int, num: Int): Int {
        return if(index == numbers.size) {
            if(target == num) 1 else 0
        } else {
            dfs(numbers, target, index + 1, num + numbers[index]) + dfs(numbers, target, index + 1, num - numbers[index])
        }
    }
     */
}