package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine()
    val stack = Stack<Char>()
    var result = 0
    var value = 1
    for(i in str.indices) {
        when (str[i]) {
            '(' -> {
                value *= 2
                stack.push('(')
            }
            '[' -> {
                value *= 3
                stack.push('[')
            }
            ')' -> {
                if(stack.isEmpty() || stack.peek() == '[') {
                    result = 0
                    break
                }
                if(str[i-1] == '(') {
                    result += value
                }
                stack.pop()
                value /= 2
            }
            ']' -> {
                if(stack.isEmpty() || stack.peek() == '(') {
                    result = 0
                    break
                }
                if(str[i-1] == '[') {
                    result += value
                }
                stack.pop()
                value /= 3
            }
        }
    }
    println(if(stack.isEmpty()) result else 0)
}