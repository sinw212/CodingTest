package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution신고결과받기().solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
        2
    ).joinToString(", ")) //[2,1,1,0]
    println(Solution신고결과받기().solution(
        arrayOf("con", "ryan"),
        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
        3
    ).joinToString(", ")) //[0,0]

    println(Solution신고결과받기().solution(
        arrayOf("abc", "acd", "add", "abd"),
        arrayOf("abc abd", "abc add", "acd abd", "abc abd", "add abd"),
        2
    ).joinToString(", ")) //[1,1,1,0]
}

class Solution신고결과받기 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val set = mutableSetOf<String>()
        report.forEach {
            set.add(it)
        }

        val map = mutableMapOf<String, Int>()
        set.forEach { rp ->
            val id = rp.split(" ")[1]
            map[id] = map.getOrDefault(id, 0) + 1
        }
        val rpId = map.filter { it.value >= k }.keys

        val answer = mutableMapOf<String, Int>()
        id_list.forEach { id ->
            answer[id] = 0
        }
        for(repo in set) {
            val (name, rp) = repo.split(" ")
            for(id in rpId) {
                if(id == rp) {
                    answer[name] = answer.getOrDefault(name, 0) + 1
                }
            }
        }
        return answer.values.toIntArray()

        //다른 사람 풀이
        /*
        return report.map { it.split(" ") }
            .groupBy { it[1] }
            .asSequence()
            .map { it.value.distinct() }
            .filter { it.size >= k }
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount()
            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
         */
    }
}