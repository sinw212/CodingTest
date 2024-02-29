package com.example.kotlincodingtest.programmers.running

fun main() {
    println(SolutionN으로표현().solution(5, 12)) //4
    println(SolutionN으로표현().solution(2, 11)) //3
    println(SolutionN으로표현().solution(5, 31168)) //-1

    println(SolutionN으로표현().solution(1, 121)) //4
    println(SolutionN으로표현().solution(5, 3025)) //4
    println(SolutionN으로표현().solution(6, 5)) //3
    println(SolutionN으로표현().solution(5, 3125)) //5
    println(SolutionN으로표현().solution(9, 0)) //2
    println(SolutionN으로표현().solution(5, 5)) //1
}

class SolutionN으로표현 {
    fun solution(n: Int, number: Int): Int {
        val calcList = Array<HashSet<Int>>(9) { HashSet() }
        for (i in 1 until 9) {
            calcList[i].add("$n".repeat(i).toInt())
            for (j in 1 until i) {
                for (a in calcList[j]) {
                    for (b in calcList[i - j]) {
                        calcList[i].add(a + b)
                        calcList[i].add(a - b)
                        calcList[i].add(a * b)
                        if (b != 0) {
                            calcList[i].add(a / b)
                        }
                    }
                }
            }
            if (calcList[i].contains(number)) {
                return i
            }
        }
        return -1
    }

        /**
         * 처음 시도했던 방법
         * 간과한 것 : 4을 만드는 방법에 대해 1+3 만 생각하고 2+2는 고려하지 않음
         */
        /*
        if(n == number) {
            return 1
        }
        val operation = listOf("+", "-", "*", "/")
        var calcList = mutableListOf(n)
        for(i in 1 until 8) {
            val result = mutableListOf<Int>()
            println("calcList : ${calcList}")
            for(j in calcList.indices) {
                if(j == 0) {
                    if(calcList[j] * 10 + n == number) {
                        return i+1
                    }
                    result.add(calcList[j] * 10 + n)
                }
                for(opr in operation) {
                    val (calcFirst: Int, calcSecond: Int) = when(opr) {
                        "+" -> Pair(n + calcList[j], calcList[j] + n)
                        "-" -> Pair(n - calcList[j], calcList[j] - n)
                        "*" -> Pair(n * calcList[j], calcList[j] * n)
                        else -> if(calcList[j] != 0) Pair(n / calcList[j], calcList[j] / n) else Pair(-1, -1)
                    }
                    if(calcFirst == number || calcSecond == number) {
                        return i+1
                    }
                    if(calcFirst != -1) {
                        result.add(calcFirst)
                    }
                    if(calcSecond != -1) {
                        result.add(calcSecond)
                    }
                }
            }
            calcList = result.distinct().toMutableList()
        }
        return -1
         */
}