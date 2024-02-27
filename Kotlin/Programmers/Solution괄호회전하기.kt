package com.example.kotlincodingtest.programmers.running

import java.util.Stack

fun main() {
    println(Solution괄호회전하기().solution("[](){}")) //3
    println(Solution괄호회전하기().solution("}]()[{")) //2
    println(Solution괄호회전하기().solution("[)(]")) //0
    println(Solution괄호회전하기().solution("}}}")) //0

    println(Solution괄호회전하기().solution("[{()}]")) //1
}

class Solution괄호회전하기 {
    fun solution(s: String): Int {
        if(s.length % 2 != 0) {
            return 0
        }
        if(s.count { it == '[' } != s.count { it == ']' } ||
            s.count { it == '{' } != s.count { it == '}' } ||
            s.count { it == '(' } != s.count { it == ')' }) {
            return 0
        }

        var answer = 0
        for(i in s.indices) {
            if(isCorrect(s.substring(i) + s.substring(0, i))) answer++
        }
        return answer
    }

    private fun isCorrect(s: String): Boolean {
        val stack = Stack<Char>()
        for(i in s.indices) {
            if(s[i] == '(' || s[i] == '{' || s[i] == '[') {
                stack.add(s[i])
            } else { // ), }, ]가 들어온 경우
                if(stack.isEmpty()) {
                    return false
                } else {
                    val current = stack.peek()
                    when(s[i]) {
                        ')' -> if(current == '(') stack.pop() else return false
                        '}' -> if(current == '{') stack.pop() else return false
                        ']' -> if(current == '[') stack.pop() else return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}