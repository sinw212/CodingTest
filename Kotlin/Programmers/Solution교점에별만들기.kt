package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution교점에별만들기().solution(arrayOf(intArrayOf(2, -1, 4), intArrayOf(-2, -1, 4), intArrayOf(0, -1, 1), intArrayOf(5, -8, -12), intArrayOf(5, 8, 12))).joinToString(separator = "\n")) ////["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
    println(Solution교점에별만들기().solution(arrayOf(intArrayOf(0, 1, -1), intArrayOf(1, 0, -1), intArrayOf(1, 0, 1))).joinToString(separator = "\n")) //["*.*"]
    println(Solution교점에별만들기().solution(arrayOf(intArrayOf(1, -1, 0), intArrayOf(2, -1, 0))).joinToString(separator = "\n")) //["*"]
    println(Solution교점에별만들기().solution(arrayOf(intArrayOf(1, -1, 0), intArrayOf(2, -1, 0), intArrayOf(4, -1, 0))).joinToString(separator = "\n")) //["*"]
}

class Solution교점에별만들기 {
    fun solution(line: Array<IntArray>): Array<String> {
        val arr = ArrayList<Pair<Long, Long>>()
        var maxX = Integer.MIN_VALUE
        var minX = Integer.MAX_VALUE
        var maxY = Integer.MIN_VALUE
        var minY = Integer.MAX_VALUE

        for(i in line.indices) {
            for(j in i+1 until line.size) {
                val (A, B, E) = line[i].map { it.toLong() }
                val (C, D, F) = line[j].map { it.toLong() }

                val adbc = A * D - B * C
                val bfed = B * F - E * D
                val ecaf = E * C - A * F

                if(adbc == 0L) {
                    continue
                } else {
                    if(bfed % adbc != 0L || ecaf % adbc != 0L) {
                        continue
                    }
                    val x = bfed / adbc
                    val y = ecaf / adbc
                    arr.add(Pair(x, y))

                    maxX = maxOf(maxX, x.toInt())
                    minX = minOf(minX, x.toInt())
                    maxY = maxOf(maxY, y.toInt())
                    minY = minOf(minY, y.toInt())
                }
            }
        }

        val answer = Array(maxY - minY + 1) { Array(maxX - minX + 1) { "." } }
        for((x, y) in arr) {
            answer[(maxY - y).toInt()][(x - minX).toInt()] = "*"
        }
        return answer.map { it.joinToString("") }.toTypedArray()
    }
}