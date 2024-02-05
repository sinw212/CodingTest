package com.example.kotlincodingtest.algorithm

fun main() {
    println(Greedy().greedy(intArrayOf(1, 100, 50, 500), 4720))
}

class Greedy {
    /**
     * 탐욕 알고리즘(Greedy Algorithm)
     */
    //예시) 가장 적게 지불할 수 있는 동전의 개수 구하기
    fun greedy(coins: IntArray, num: Int): Int {
        var money = num
        coins.sortDescending()

        var count = 0
        for(coin in coins) {
            count += money / coin
            money %= coin
        }
        return count
    }
}