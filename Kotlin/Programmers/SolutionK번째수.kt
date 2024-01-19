package com.example.kotlincodingtest.programmers.running

fun main() {
    val arr = SolutionK번째수().solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3)))
    println(arr.joinToString(", "))
}
class SolutionK번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for(command in commands) {
            answer = answer.plus(array.toList().subList(command[0]-1, command[1]).sorted()[command[2]-1])
        }
        return answer

        /*
        //다른 사람 풀이
        return commands.map { command ->
            array.slice(IntRange(command[0]-1, command[1]-1)).sorted()[command[2]-1]
        }.toIntArray()
         */
    }
}