package com.example.kotlincodingtest.programmers.running

import kotlin.math.*

fun main() {
    println(Solution조이스틱().solution("JEROEN")) //56
    println(Solution조이스틱().solution("JAN")) //23

    println(Solution조이스틱().solution("AAA")) //0
    println(Solution조이스틱().solution("AAB")) //2
    println(Solution조이스틱().solution("NOTBAAAAD")) //41
    println(Solution조이스틱().solution("BBBBAAAABA")) //12
    println(Solution조이스틱().solution("BBBAAABAAA")) //10
}

class Solution조이스틱 {
    fun solution(name: String): Int {
        var vertical = 0
        var horizontal = name.length - 1
        var lastIndex = 0
        name.forEachIndexed { i, c ->
//            val bottomRotate = c - 'A'
//            val topRotate = 'Z' - c + 1
//            vertical += if(bottomRotate < topRotate) bottomRotate else topRotate
            vertical += min(c - 'A', 'Z' - c + 1)

            //연속되는 A 찾기
            lastIndex = i + 1
            while (lastIndex < name.length && name[lastIndex] == 'A') {
                lastIndex++
            }

            horizontal = min(
                min(horizontal, i * 2 + name.length - lastIndex),
                (name.length - lastIndex) * 2 + i
            )
        }
        return vertical + horizontal
    }
}