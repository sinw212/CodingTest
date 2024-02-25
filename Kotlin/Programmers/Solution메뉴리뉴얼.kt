package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution메뉴리뉴얼().solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2,3,4)).joinToString(", ")) //["AC", "ACDE", "BCFG", "CDE"]
    println(Solution메뉴리뉴얼().solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2,3,5)).joinToString(", ")) //["ACD", "AD", "ADE", "CD", "XYZ"]
    println(Solution메뉴리뉴얼().solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2,3,4)).joinToString(", ")) //["WX", "XY"]
}

class Solution메뉴리뉴얼 {
    private var cbList = mutableListOf<MutableList<String>>()
    private var answer = arrayOf<String>()
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val set = mutableSetOf<String>()
        orders.forEach { order ->
            order.forEach { alpha ->
                set.add(alpha.toString())
            }
        }
        val sortedSet = set.sorted()
        for(size in course) {
            cbList.clear()
            combination(0, size, sortedSet, mutableListOf())
            findCount(cbList, orders)
        }
        return answer.sorted().toTypedArray()
    }

    private fun findCount(cbList: MutableList<MutableList<String>>, orders: Array<String>) {
        val hashMap = hashMapOf<String, Int>()
        cbList.forEach { cbResult ->
            orders.forEach { order ->
                if(cbResult.all { order.contains(it) }) {
                    val str = cbResult.joinToString("")
                    hashMap[str] = hashMap.getOrDefault(str, 0) + 1
                }
            }
        }
        val maxValue = hashMap.values.maxOrNull()
        maxValue.let {
            answer += hashMap.filter { it.value == maxValue && it.value >= 2 }.keys
        }
    }

    private fun combination(n: Int, size: Int, sortedSet: List<String>, result: MutableList<String>) {
        if(result.size == size) {
            cbList.add(result.toMutableList())
            return
        }
        for(i in n until sortedSet.size) {
            result.add(sortedSet[i])
            combination(i+1, size, sortedSet, result)
            result.removeLast()
        }
    }
}