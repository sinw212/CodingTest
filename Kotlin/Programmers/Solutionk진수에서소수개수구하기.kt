package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solutionk진수에서소수개수구하기().solution(437674, 3)) //3
    println(Solutionk진수에서소수개수구하기().solution(110011, 10)) //2

    println(Solutionk진수에서소수개수구하기().solution(883438, 3)) //0
    println(Solutionk진수에서소수개수구하기().solution(10000, 10)) //0
}

class Solutionk진수에서소수개수구하기 {
    fun solution(n: Int, k: Int): Int =
        n.toString(k)
            .replace(Regex("0+"), "0")
            .split("0").filter { it.isNotEmpty() }
            .count { isPrime(it.toLong()) }

    private fun isPrime(num: Long): Boolean =
        num > 1 && (2..kotlin.math.sqrt(num.toDouble()).toInt()).none { num % it == 0L }
}