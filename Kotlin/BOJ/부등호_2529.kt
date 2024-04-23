package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    부등호_2529().solution()
}

class 부등호_2529 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine(), " ")
        val arr = Array<String>(n) { st.nextToken() }

        println(calculate(0, 1, StringBuilder(), "", 9, arr))
        println(calculate(1, 1, StringBuilder(), "", 0, arr))
    }

    fun calculate(
        k: Int, cnt: Int, sb: StringBuilder, str: String, num: Int, arr: Array<String>
    ): StringBuilder {
        var cCnt = cnt
        val cSb = sb
        var cStr = str
        var cNum = num

        for(i in arr.indices) {
            when(arr[i]) {
                if(k==0) "<" else ">" -> cCnt += 1
                if(k==0) ">" else "<" -> {
                    if(cCnt > 1) {
                        repeat(cCnt - 1) {
                            cStr += if(k==0) cNum-- else cNum++
                        }
                        cCnt = 1
                    }
                    cStr += if(k==0) cNum-- else cNum++
                    cSb.append(cStr.reversed())
                    cStr = ""
                }
            }
        }

        val n = arr.size
        val size = if(k==0) 9-n else n
        if(k==0) {
            if(cNum >= size) {
                repeat(cNum - size + 1) {
                    cStr += cNum--
                }
                cSb.append(if(arr[n-1]==">") cStr else cStr.reversed())
            }
        } else {
            if(cNum <= size) {
                repeat(size - cNum + 1) {
                    cStr += cNum++
                }
                cSb.append(if(arr[n-1]=="<") cStr else cStr.reversed())
            }
        }
        return cSb
    }
}