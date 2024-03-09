package com.example.kotlincodingtest.programmers.running

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(Solution단어변환().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))) //4
    println(Solution단어변환().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log"))) //0

    println(Solution단어변환().solution("aab", "aba", arrayOf("abb", "aba"))) //2
}

class Solution단어변환 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        if(words.contains(target).not()) {
            return 0
        }
        return bfs(begin, target, words)
    }

    fun bfs(begin: String, target: String, words: Array<String>): Int {
        val queue: Queue<Pair<String, Int>> = LinkedList()
        val visited = BooleanArray(words.size + 1) { false }
        queue.add(begin to 0)
        while(queue.isNotEmpty()) {
            val current = queue.poll()
            val word = current.first
            val count = current.second
            if(word == target) {
                return count
            }

            for(i in words.indices) {
                if(!visited[i+1] && canChange(words[i], word)) {
                    visited[i+1] = true
                    queue.add(words[i] to count+1)
                }
            }
        }
        return -1
    }

    fun canChange(word: String, current: String): Boolean {
        var count = 0
        for(i in word.indices) {
            if(word[i] != current[i]) count++
        }
        return count == 1
    }

    /*
    //처음 DFS 사용하여 해결 - 한개 테스트 케이스에서 시간 초과 발생
    //일반적으로 최단거리 탐색 문제에 대해서는 불필요한 경로를 탐색하지 않는 BFS가 적절
    var minValue = Integer.MAX_VALUE
    fun solution(begin: String, target: String, words: Array<String>): Int {
        if(words.contains(target).not()) {
            return 0
        }
        return dfs(begin, target, words, BooleanArray(words.size + 1) { false }, 0)
    }

    fun dfs(current: String, target: String, words: Array<String>, visited: BooleanArray, count: Int): Int {
        if(current == target) {
            minValue = minOf(minValue, count)
            return minValue
        }
        for(i in words.indices) {
            if(!visited[i+1] && canChange(words[i], current)) {
                visited[i+1] = true
                minValue = dfs(words[i], target, words, visited, count+1)
                visited[i+1] = false
            }
        }
        return minValue
    }

    fun canChange(word: String, current: String): Boolean {
        var count = 0
        for(i in word.indices) {
            if(word[i] != current[i]) count++
        }
        return count == 1
    }
     */
}