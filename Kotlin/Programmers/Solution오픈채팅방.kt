package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution오픈채팅방().solution(
        arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
    ).joinToString(", ")) //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
}

class Solution오픈채팅방 {
    fun solution(record: Array<String>): Array<String> {
        var result = arrayOf<Pair<String, String>>()
        val map = hashMapOf<String, String>()
        record.forEach { rc ->
            val str = rc.split(" ")
            when(str[0]) {
                "Enter" -> {
                    map[str[1]] = str[2]
                    result += str[0] to str[1]
                }
                "Leave" -> {
                    result += str[0] to str[1]
                }
                "Change" -> {
                    map[str[1]] = str[2]
                }
            }
        }
        val answer = Array(result.size) { "" }
        for(i in result.indices) {
            answer[i] = when(result[i].first) {
                "Enter" -> "${map[result[i].second]}님이 들어왔습니다."
                else -> "${map[result[i].second]}님이 나갔습니다."
            }
        }
        return answer
    }
}