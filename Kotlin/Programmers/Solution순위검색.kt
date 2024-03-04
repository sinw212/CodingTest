package com.example.kotlincodingtest.programmers.running

fun main() {
    println(
        Solution순위검색().solution(
            arrayOf(
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
            ),
            arrayOf(
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
            )
        ).joinToString(", ")
    ) //[1,1,1,1,2,4]
}

class Solution순위검색 {
    val hashMap = hashMapOf<String, MutableList<Int>>()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        info.forEach { str ->
            makeKey("", 0, str.split(" "))
        }
        hashMap.values.forEach { it.sort() }

        var answer = IntArray(query.size)
        query.forEachIndexed { idx, str ->
            val (key, target) = str.replace(" and ", "").split(" ")
            val value = hashMap[key]
            answer[idx] = if(value != null && hashMap.containsKey(key)) searchBinary(value, target.toInt()) else 0
        }
        return answer
    }

    fun makeKey(key: String, depth: Int, infoArr: List<String>) {
        if (depth == 4) {
            val newList = hashMap.getOrDefault(key, mutableListOf())
            newList.add(infoArr[depth].toInt())
            hashMap[key] = newList
            return
        }
        makeKey("$key-", depth + 1, infoArr)
        makeKey("$key${infoArr[depth]}", depth + 1, infoArr)
    }

    fun searchBinary(value: MutableList<Int>, target: Int): Int {
        var left = 0
        var right = value.size - 1

        while(left <= right) {
            val mid = (left + right) / 2
            if(value[mid] < target) left = mid + 1
            else right = mid - 1
        }
        return value.size - left
    }

    /*
    //해당 코드로 작성 시, 정확성 100점 & 효율성 0점. 이진 탐색으로 수정
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        fun getInit(idx: Int, str: String, arr: Array<Array<String>>) {
            val st = StringTokenizer(str, " ")
            for (i in arr[0].indices) {
                if (st.hasMoreTokens()) {
                    arr[idx][i] = st.nextToken()
                }
            }
        }

        val infoArr = Array(info.size) { Array(5) { "" } }
        val queryArr = Array(query.size) { Array(5) { "" } }
        info.forEachIndexed { idx, str ->
            getInit(idx, str, infoArr)
        }
        query.forEachIndexed { idx, str ->
            val newStr = str.replace("and", "")
            getInit(idx, newStr, queryArr)
        }

        var answer = intArrayOf()
        for (query in queryArr) {
            var count = 0
            for (info in infoArr) {
                if ((query[0] == "-" || query[0] == info[0])
                    && (query[1] == "-" || query[1] == info[1])
                    && (query[2] == "-" || query[2] == info[2])
                    && (query[3] == "-" || query[3] == info[3])
                    && (info[4].toInt() >= query[4].toInt())
                ) {
                    count++
                }
            }
            answer += count
        }
        return answer
    }
     */
}