package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution의상().solution(arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))))
}

class Solution의상 {
    fun solution(clothes: Array<Array<String>>): Int {
        val hashMap = hashMapOf<String, Int>()
        for(cloth in clothes) {
            hashMap[cloth[1]] = hashMap.getOrDefault(cloth[1], 0) + 1
        }
        return hashMap.values.fold(1) { acc, value -> acc * (value + 1) } - 1

//        return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) }  - 1
    }
}