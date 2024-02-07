package com.example.kotlincodingtest.programmers.running

import kotlin.math.sqrt

fun main() {
    println(Solution소수찾기().solution("17")) //3
    println(Solution소수찾기().solution("011")) //2
    println(Solution소수찾기().solution("1231")) //18
}

class Solution소수찾기 {
    private var count = 0
    private val numSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        val digits = numbers.toCharArray()
        digits.forEachIndexed { index, c ->
            makeNumber(c.toString(), digits.filterIndexed { i, _ -> index != i })
        }

        numSet.forEach {
            if (isPrime(it)) count++
        }

        return count
    }

    private fun makeNumber(number: String, digits: List<Char>) {
        numSet.add(number.toInt())
        if (digits.isEmpty()) return

        digits.forEachIndexed { index, c ->
            makeNumber("$number$c", digits.filterIndexed { i, _ -> index != i })
        }
    }

    private fun isPrime(num: Int): Boolean = num > 1 && (2 ..sqrt(num.toDouble()).toInt()).none { num % it == 0 }
//    private fun isPrime(num: Int): Boolean {
//        if(num < 2) {
//            return false
//        }
//        for( i in 2..sqrt(num.toDouble()).toInt()) {
//            if( num % i == 0 ) return false
//        }
//        return true
//    }
}