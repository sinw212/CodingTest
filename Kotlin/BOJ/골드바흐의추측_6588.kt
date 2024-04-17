package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    골드바흐의추측_6588().solution()
}

class 골드바흐의추측_6588 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val MAX = 1000000
        val isPrime = BooleanArray(MAX + 1) {
            when(it) {
                0, 1 -> false
                else -> true
            }
        }

        for(i in 2 .. kotlin.math.sqrt(MAX.toDouble()).toInt()) {
            if(isPrime[i]) {
                for(j in (i * i) .. MAX step i) {
                    isPrime[j] = false
                }
            }
        }

        while(true) {
            val n = readLine().toInt()
            if(n == 0) {
                break
            }
            var isFound = false
            for(i in 1 until (n/2)) {
               val num1 = 2 * i + 1
               if(isPrime[num1] && isPrime[n-num1]) {
                   println("$n = $num1 + ${n - num1}")
                   isFound = true
                   break
               }
            }
            if(!isFound) {
                println("Goldbach's conjecture is wrong.")
            }
        }
    }
}