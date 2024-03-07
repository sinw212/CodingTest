package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution주차요금계산().solution(
        intArrayOf(180, 5000, 10, 600),
        arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"),
    ).joinToString(", ")) //[14600, 34400, 5000]
    println(Solution주차요금계산().solution(
        intArrayOf(120, 0, 60, 591),
        arrayOf("16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"),
    ).joinToString(", ")) //[0, 591]
    println(Solution주차요금계산().solution(
        intArrayOf(1, 461, 1, 10),
        arrayOf("00:00 1234 IN")
    ).joinToString(", ")) //[14841]
}

class Solution주차요금계산 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        fun calcFee(time: Int): Int {
            return if(time < fees[0]) {
                fees[1]
            } else {
                val mod = time - fees[0]
                fees[1] + (if(mod%fees[2] == 0) mod/fees[2] else mod/fees[2]+1) * fees[3]
            }
        }

        val map = hashMapOf<String, MutableList<String>>()
        records.forEach { record ->
            val str = record.split(" ")
            val newList = map.getOrDefault(str[1], mutableListOf())
            newList.add(str[0])
            map[str[1]] = newList
        }

        for((key, value) in map) {
            if(value.size % 2 != 0) {
                val newList = map.getOrDefault(key, mutableListOf())
                newList.add("23:59")
                map[key] = newList
            }
        }

        var answer = IntArray(map.size)
        val arr = map.entries.sortedBy { it.key }
        arr.forEachIndexed { i, (_, value) ->
            var time = 0
            for(v in value.indices step 2) {
                val splitOut = value[v+1].split(":")
                val splitIn = value[v].split(":")
                time += (splitOut[0].toInt() - splitIn[0].toInt() - 1) * 60 + (60 - splitIn[1].toInt()) + (splitOut[1].toInt())
            }
            answer[i] = calcFee(time)
        }
        return answer
    }
}