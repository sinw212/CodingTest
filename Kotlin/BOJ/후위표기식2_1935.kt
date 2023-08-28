package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val str = readLine()
    val stack = Stack<Double>()

//    val map = mutableMapOf<String, Double>()
//    for(i in str.indices) {
//        if(str.substring(i, i+1).matches(Regex("^[A-Z]"))) {
//            if(map.getOrDefault(str.substring(i, i+1), 0) == 0) {
//                map[str.substring(i, i+1)] = readLine().toDouble()
//            }
//        }
    val value = DoubleArray(num) { readLine().toDouble() }

    for(ch in str) {
//        if(str.substring(i, i+1).matches(Regex("^[A-Z]"))) {
//            stack.push(map.getValue(str.substring(i, i+1)))
        if(ch in 'A'..'Z') {
            stack.push(value[ch - 'A'])
        } else {
            stack.push(calcPostfix(ch, stack.pop(), stack.pop()))
        }
    }
    println(String.format("%.2f", stack.pop()))
    close()
}

fun calcPostfix(operator: Char, num1: Double, num2: Double): Double {
    return when(operator) {
        '+' -> num2 + num1
        '-' -> num2 - num1
        '*' -> num2 * num1
        else -> num2 / num1
    }
}
