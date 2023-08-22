package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val stack = Stack<String>()
    val num: Int = readLine().toInt()
    for(n in 0 until num) {
        val st = StringTokenizer(readLine(), "")
        for(s in st.nextToken()) {
            stack.push(s.toString())
        }

        if(stack.size % 2 != 0) {
            bw.write("NO\n")
            stack.clear()
        } else {
            var countEnd = 0
            while(stack.size != 0) {
                if(stack.pop() == ")") {
                    countEnd++
                } else { //stack.pop == "("
                    if(countEnd == 0) {
                        stack.clear()
                    }
                    countEnd--
                }
            }
            bw.write(if(countEnd == 0) "YES\n" else "NO\n")
        }
    }
    bw.flush()
    bw.close()
    close()
}