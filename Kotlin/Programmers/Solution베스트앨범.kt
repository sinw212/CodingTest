package com.example.kotlincodingtest.programmers.running

fun main() {
    val arr = Solution베스트앨범().solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
    println(arr.joinToString(", "))
}

class Solution베스트앨범 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = arrayListOf<Int>()
        var totalMap = mutableMapOf<String, Int>()
        val albumMap = mutableMapOf<Int, Pair<Int, String>>()

        for(i in genres.indices) {
            totalMap[genres[i]] = totalMap.getOrDefault(genres[i], 0) + plays[i]
            albumMap[i] = plays[i] to genres[i]
        }
        totalMap = totalMap.toList().sortedByDescending { it.second }.toMap() as MutableMap<String, Int>

        val sortedAlbumMap = albumMap.toSortedMap { o1, o2 ->
            val compare = (albumMap[o2]?.first ?: Int.MIN_VALUE).compareTo(
                albumMap[o1]?.first ?: Int.MIN_VALUE
            )
            if (compare != 0) compare else {
                o1.compareTo(o2)
            }
        }

        for(total in totalMap.keys) {
            var count = 0
            for((key, value) in sortedAlbumMap) {
               if(count < 2 && value.second == total) {
                   answer.add(key)
                   count++
               }
            }
        }
        return answer.toIntArray()

        /*
        //다른 사람 풀이
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
         */
    }
}