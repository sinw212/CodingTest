package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution양궁대회().solution(5, intArrayOf(2,1,1,1,0,0,0,0,0,0,0)).joinToString(", ")) //[0,2,2,0,1,0,0,0,0,0,0]
    println(Solution양궁대회().solution(1, intArrayOf(1,0,0,0,0,0,0,0,0,0,0)).joinToString(", ")) //[-1]
    println(Solution양궁대회().solution(9, intArrayOf(0,0,1,2,0,1,1,1,1,1,1)).joinToString(", ")) //[1,1,2,0,1,2,2,0,0,0,0]
    println(Solution양궁대회().solution(10, intArrayOf(0,0,0,0,0,0,0,0,3,4,3)).joinToString(", ")) //[1,1,1,1,1,1,1,1,0,0,2]

    println(Solution양궁대회().solution(3, intArrayOf(0,0,1,0,0,0,0,0,0,1,1)).joinToString(", ")) //[1,1,0,1,0,0,0,0,0,0,0]
}

class Solution양궁대회 {
    fun solution(n: Int, info: IntArray): IntArray {
        var answer = IntArray(info.size) { 0 }
        var result = IntArray(info.size) { 0 }
        var maxValue = -1

        fun getMax(lSum: Int, aSum: Int) {
            if(maxValue == lSum - aSum) {
                for(i in answer.indices.reversed()) {
                    if(answer[i] != result[i]) {
                        if(answer[i] < result[i]) {
                            answer = result.copyOf()
                        }
                        break
                    }
                }
            } else {
                maxValue = maxOf(maxValue, lSum - aSum)
                if(maxValue == lSum - aSum) {
                    answer = result.copyOf()
                }
            }
        }

        fun dfs(num: Int, add: Int, count: Int, lionSum: Int, apeachSum: Int) {
            result[num] = add
            if (count == n) {
                var apSum = apeachSum
                for(i in num+1 until info.size) {
                    if(info[i] > 0) {
                        apSum += (10 - i)
                    }
                }
                getMax(lionSum, apSum)
                return
            }
            if(num >= info.size - 1 || count > n) {
                if(num >= info.size - 1 && count < n) {
                    result[num] = n - count
                    getMax(lionSum, apeachSum)
                    result[num] = 0
                }
                return
            }
            dfs(num+1, info[num+1] + 1, count + info[num+1] + 1, lionSum + (10-(num+1)), apeachSum) // 라이언이 이기는 경우
            dfs(num+1, info[num+1], count + info[num+1], lionSum, apeachSum + (if(info[num+1] == 0) 0 else 10-(num+1))) // 비기는 경우
            dfs(num+1, 0, count, lionSum, apeachSum + (10-(num+1))) // 어피치가 이기는 경우
        }

        dfs(0, info[0] + 1, info[0] + 1, 10, 0)
        dfs(0, info[0], info[0], 0, if(info[0] == 0) 0 else 10)
        dfs(0, 0, 0, 0, 10)

        return if(maxValue <= 0) intArrayOf(-1) else answer
    }
}