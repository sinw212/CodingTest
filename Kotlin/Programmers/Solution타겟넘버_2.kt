package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution타겟넘버_2().solution(intArrayOf(1,1,1,1,1), 3)) //5
    println(Solution타겟넘버_2().solution(intArrayOf(4,1,2,1), 4)) //2
}
class Solution타겟넘버_2 {
    fun solution(numbers: IntArray, target: Int): Int {
        var count = 0
        fun dfs(num: Int, sum: Int) {
            if(num  == numbers.size) {
                if(sum == target) count++
                return
            }
            dfs(num + 1, sum + numbers[num])
            dfs(num + 1, sum - numbers[num])
        }
        dfs(0, 0)
        return count

        /*
        //다른 사람 풀이
        return numbers.fold(listOf(0)) { list, i ->
            //초기값을 listOf(0)으로 설정한다는 의미
            list.run {
                //누적 값 계산이 가능
                map { it + i } + map { it - i }
            }
        }.count { it == target }
         */
    }
}