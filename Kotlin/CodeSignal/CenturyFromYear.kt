package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(CenturyFromYear().solution(1700)) //17
    println(CenturyFromYear().solution(1905)) //20
}
class CenturyFromYear {
    fun solution(year: Int): Int {
        return Math.ceil(year / 100.0).toInt()
    }
}