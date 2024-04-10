package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    에디터_1406().solution()
}

class 에디터_1406 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val str = readLine()
        val arr = LinkedList<Char>()
        str.forEach { arr.add(it) }
        var n = arr.listIterator(arr.size)

        val m = readLine().toInt()
        repeat(m) {
            val st = StringTokenizer(readLine(), " ")
            //단순 LinkedList로 접근하면 시간초과 발생 - LinkedList는 특정 인덱스를 찾을 때 순회를 하면서 찾기 때문에 시간복잡도 O(n)
            //LinkedList의 ListIterator를 사용하여 현재 위치를 기억하고 이를 활용하는 방법으로 접근
            when(st.nextToken()) {
                "L" -> if(n.hasPrevious()) n.previous()
                "D" -> if(n.hasNext()) n.next()
                "B" -> {
                    if(n.hasPrevious()) {
                        n.previous()
                        n.remove()
                    }
                }
                "P" -> {
                    n.add(st.nextToken().single())
                }
            }
        }
        println(arr.joinToString(""))
    }
}