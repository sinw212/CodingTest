package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

var answer = ArrayList<MutableList<Int>>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true) {
        val str = readLine().split(" ").map { it.toInt() }
        if(str[0] == 0) {
            break
        }
        val arr = IntArray(str[0])
        for(i in arr.indices) {
            arr[i] = str[i+1]
        }
        answer = arrayListOf()
        dfs_6603(0, arr, mutableListOf()).forEach {
            println(it.joinToString(" "))
        }
        println()
    }
}

fun dfs_6603(start: Int, arr: IntArray, result: MutableList<Int>): ArrayList<MutableList<Int>> {
    if(result.size == 6){
        answer += result
        return answer
    }

    for(i in start until arr.size){
        result.add(arr[i])
        dfs_6603(i+1, arr, result.toMutableList())
        result.removeLast()
    }
    return answer
}