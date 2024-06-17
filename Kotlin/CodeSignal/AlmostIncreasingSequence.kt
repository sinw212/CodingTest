package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(AlmostIncreasingSequence().solution(mutableListOf(1,3,2,1))) //false
    println(AlmostIncreasingSequence().solution(mutableListOf(1,3,2))) //true
    println(AlmostIncreasingSequence().solution(mutableListOf(1,2,3,4,3,6))) //true
}
class AlmostIncreasingSequence {
    fun solution(sequence: MutableList<Int>): Boolean {
        var removeCnt = 0
        for(i in 1 until sequence.size) {
            if(sequence[i] <= sequence[i-1]) {
                removeCnt++
                if(removeCnt > 1) {
                    return false
                }
                if(i in 2 until sequence.size - 1) {
                    if(sequence[i] <= sequence[i-2] && sequence[i+1] <= sequence[i-1]) {
                        return false
                    }
                }
            }
        }
        return true
    }
}