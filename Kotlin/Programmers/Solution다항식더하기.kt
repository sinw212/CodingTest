package com.example.kotlincodingtest.programmers

fun main() {
    println(Solution다항식더하기().solution("1"))

    var arr = IntArray(size = 3)
    println(arr.joinToString(", "))
}

class Solution다항식더하기 {
    fun solution(polynomial: String): String {
        val splitStr = polynomial.split(" + ")

        var xPoly = 0
        var numPoly = 0
        for(i in splitStr) {
           if(i.contains("x")) {
               xPoly += if(i.replace("x", "").isEmpty()) 1 else i.replace("x", "").toInt()
           } else {
               numPoly += i.toInt()
           }
        }

        var answer = ""
        if(xPoly == 1) {
            answer = "x"
            if(numPoly != 0) answer += " + $numPoly"
        } else if(xPoly != 0) {
            answer = "${xPoly}x"
            if(numPoly != 0) answer += " + $numPoly"
        } else { //xPoly == 0
            if(numPoly != 0) answer += numPoly
        }
        return answer
    }
}