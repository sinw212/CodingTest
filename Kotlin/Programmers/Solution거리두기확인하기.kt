package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution거리두기확인하기().solution(
        arrayOf(
            arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
            arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
            arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
        )
    ).joinToString(", ")) //[1, 0, 1, 1, 1]
}

class Solution거리두기확인하기 {
    fun solution(places: Array<Array<String>>): IntArray {
        fun isValid(i: Int, j: Int, place: Array<String>, visited: Array<Array<Boolean>>): Boolean {
            val dirXTwo = listOf(2, 0, -2, 0)
            val dirYTwo = listOf(0, 2, 0, -2)
            val dirXOne = listOf(1, 0, -1, 0)
            val dirYOne = listOf(0, 1, 0, -1)
            val dirXDig = listOf(1, -1, -1, 1)
            val dirYDig = listOf(1, 1, -1, -1)
            for(dir in dirXTwo.indices) {
                val newXTwo = i + dirXTwo[dir]
                val newYTwo = j + dirYTwo[dir]
                val newXOne = i + dirXOne[dir]
                val newYOne = j + dirYOne[dir]
                val newXDig = i + dirXDig[dir]
                val newYDig = j + dirYDig[dir]
                if(newXTwo in place.indices && newYTwo in place.indices) {
                    if(place[newXTwo][newYTwo] == 'P' && !visited[newXTwo][newYTwo]) {
                        if(place[newXOne][newYOne] != 'X') {
                            return false
                        }
                    }
                }
                if(newXOne in place.indices && newYOne in place.indices) {
                    if(place[newXOne][newYOne] == 'P' && !visited[newXOne][newYOne]) {
                        return false
                    }
                }
                if(newXDig in place.indices && newYDig in place.indices) {
                    if(place[newXDig][newYDig] == 'P' && !visited[newXDig][newYDig]) {
                        val newXOne2 = i + dirXOne[(dir+1)%dirXTwo.size]
                        val newYOne2 = j + dirYOne[(dir+1)%dirXTwo.size]
                        if(place[newXOne][newYOne] != 'X' || place[newXOne2][newYOne2] != 'X') {
                            return false
                        }
                    }
                }
            }
            return true
        }

        var answer = intArrayOf()
        places.forEach { place ->
            val visited = Array(places.size) { Array(places.size) { false } }
            var validNum = 1
            loop@for(i in place.indices) {
                for(j in place.indices) {
                    if(place[i][j] == 'P' && !visited[i][j]) {
                        if(isValid(i, j, place, visited)) {
                            visited[i][j] = true
                        } else {
                            validNum = 0
                            break@loop
                        }
                    }
                }
            }
            answer += validNum
        }
        return answer
    }
}