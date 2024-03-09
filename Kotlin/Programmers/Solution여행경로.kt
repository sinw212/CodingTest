package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution여행경로().solution(arrayOf(
        arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND")
    )).joinToString(", ")) //["ICN", "JFK", "HND", "IAD"]
    println(Solution여행경로().solution(arrayOf(
        arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL","SFO")
    )).joinToString(", ")) //["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
}

class Solution여행경로 {
    var answer = ArrayList<Array<String>>()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        dfs("ICN", tickets, BooleanArray(tickets.size + 1) { false }, arrayOf())
        return answer.sortedBy { it.joinToString() }.first()
    }

    fun dfs(start: String, tickets: Array<Array<String>>, visited: BooleanArray, result: Array<String>) {
        var temp = result
        if(temp.size == tickets.size) {
            temp += start
            answer += temp
            return
        }
        for(i in tickets.indices) {
            if(!visited[i] && tickets[i][0] == start) {
                visited[i] = true
                dfs(tickets[i][1], tickets, visited, result + start)
                visited[i] = false
            }
        }
    }
}