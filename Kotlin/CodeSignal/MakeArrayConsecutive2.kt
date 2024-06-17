package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(MakeArrayConsecutive2().solution(mutableListOf(6,2,3,8))) //3
}
class MakeArrayConsecutive2 {
    fun solution(statues: MutableList<Int>): Int {
        statues.sort()
        return statues[statues.size-1] - statues[0] - statues.size + 1
    }
}