package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    치킨배달_15686().solution()
}

class 치킨배달_15686 {
    val combis = mutableListOf<MutableList<CkPoint>>()
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val city = Array(n + 1) { IntArray(n + 1) }
        repeat(n) {
            val st = StringTokenizer(readLine(), " ")
            city[it + 1] = IntArray(n + 1) { c ->
                when (c) {
                    0 -> 0
                    else -> st.nextToken().toInt()
                }
            }
        }

        val homes = mutableListOf<CkPoint>()
        val chickens = mutableListOf<CkPoint>()
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(city[i][j] == 1) {
                    homes.add(CkPoint(i, j))
                }
                if(city[i][j] == 2) {
                    chickens.add(CkPoint(i, j))
                }
            }
        }

        for(i in chickens.indices) {
            val arr = mutableListOf<CkPoint>()
            arr.add(chickens[i])
            combination(m, chickens, arr, i)
        }

        var minValue = Integer.MAX_VALUE
        combis.forEach { chicken ->
            var homeSum = 0
            homes.forEach { home ->
                var minDir = Integer.MAX_VALUE
                for(i in chicken.indices) {
                    minDir = minOf(
                        minDir,
                        kotlin.math.abs(home.x - chicken[i].x) + kotlin.math.abs(home.y - chicken[i].y)
                    )
                }
                homeSum += minDir
            }
            minValue = minOf(minValue, homeSum)
        }
        println(minValue)
    }

    fun combination(m: Int, chickens: MutableList<CkPoint>, arr: MutableList<CkPoint>, idx: Int) {
        if(arr.size == m) {
            combis.add(arr.toMutableList())
            return
        }
        for(i in idx+1 until chickens.size) {
            arr.add(chickens[i])
            combination(m, chickens, arr, i)
            arr.removeAt(arr.size - 1)
        }
    }
}
data class CkPoint(val x: Int, val y: Int)