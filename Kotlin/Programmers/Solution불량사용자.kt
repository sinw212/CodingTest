package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution불량사용자().solution(arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"), arrayOf("fr*d*", "abc1**"))) //2
    println(Solution불량사용자().solution(arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"), arrayOf("*rodo", "*rodo", "******"))) //2
    println(Solution불량사용자().solution(arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"), arrayOf("fr*d*", "*rodo", "******", "******"))) //3
}

class Solution불량사용자 {
    var arr: Array<Pair<String, MutableList<String>>> = arrayOf()
    val mutableSet = mutableSetOf<MutableList<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        arr = Array(banned_id.size) { Pair("", mutableListOf()) }
        for(i in banned_id.indices) {
            val list = mutableListOf<String>()
            for(j in user_id.indices) {
                if(banned_id[i].length == user_id[j].length && matchId(user_id[j], banned_id[i])) {
                    list.add(user_id[j])
                }
            }
            arr[i] = banned_id[i] to list
        }
        val result = mutableListOf<String>()
        for(str in arr[0].second) {
            result.add(str)
            combination(1, banned_id.size, result)
            result.removeAt(result.lastIndex)
        }
        return mutableSet.size
    }

    private fun combination(listCnt: Int, bannedIdSize: Int, result: MutableList<String>) {
        if(result.size >= bannedIdSize) {
            if(result.size == result.distinct().size) {
                mutableSet.add(result.sorted().toMutableList())
            }
            return
        }
        for(str in arr[listCnt].second) {
            result.add(str)
            combination(listCnt+1, bannedIdSize, result)
            result.removeAt(result.lastIndex)
        }
    }

    private fun matchId(userId: String, bannedId: String): Boolean {
        val indexList = mutableListOf<Int>()
        bannedId.forEachIndexed { index, c ->
            if(c == '*') indexList.add(index)
        }
        var newStr = userId
        for(index in indexList) {
            val sb = StringBuilder(newStr)
            sb[index] = '*'
            newStr = sb.toString()
        }
        return newStr == bannedId
    }
}