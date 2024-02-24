package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution수식최대화().solution("100-200*300-500+20")) //60420
    println(Solution수식최대화().solution("50*6-3*2")) //300
}

class Solution수식최대화 {
    fun solution(expression: String): Long {
        val operationArr = arrayOf(
            arrayOf("*", "+", "-"),
            arrayOf("+", "*", "-"),
            arrayOf("+", "-", "*"),
            arrayOf("-", "*", "+"),
            arrayOf("-", "+", "*")
        )

        val newExpression = newExpre(expression)
        var maxValue = Long.MIN_VALUE
        var newExp: MutableList<String>
        var newStr: MutableList<String>
        var strNum = ""
        for(operation in operationArr) {
            newExp = newExpression
            for(i in operation.indices) {
                newStr = mutableListOf()
                newExp.forEach {
                    if(it.toLongOrNull() != null) {
                        strNum = if(strNum.isEmpty()) {
                            it
                        } else {
                            when(strNum.last()) {
                                '+' -> (strNum.substring(0, strNum.length-1).toLong() + it.toLong()).toString()
                                '*' -> (strNum.substring(0, strNum.length-1).toLong() * it.toLong()).toString()
                                else -> (strNum.substring(0, strNum.length-1).toLong() - it.toLong()).toString()
                            }
                        }
                    } else {
                        if(it == operation[i]) {
                            strNum += it
                        } else {
                            newStr.add(strNum)
                            newStr.add(it)
                            strNum = ""
                        }
                    }
                }
                newStr.add(strNum)
                strNum = ""
                newExp = newStr.toMutableList()
            }
            val value = newExp.last().toLong()
            maxValue = maxOf(maxValue, if(value >= 0) value else -value)
        }
        return maxValue
    }

    private fun newExpre(expression: String): MutableList<String> {
        val tokens = mutableListOf<String>()
        var currentNumber = ""

        for (char in expression) {
            if (char.isDigit()) {
                currentNumber += char
            } else if (char in listOf('+', '-', '*')) {
                if (currentNumber.isNotEmpty()) {
                    tokens.add(currentNumber)
                    currentNumber = ""
                }
                tokens.add(char.toString())
            }
        }

        if (currentNumber.isNotEmpty()) {
            tokens.add(currentNumber)
        }
        return tokens
    }
}