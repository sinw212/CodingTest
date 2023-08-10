package com.example.kotlincodingtest.programmers

import java.lang.Math.abs

fun main() {
    var res = Solution특이한정렬().solution(intArrayOf(1, 2, 3, 4, 5, 6), 4)
    println(res.joinToString(", "))
}
class Solution특이한정렬 {
    fun solution(numlist: IntArray, n: Int): IntArray {
//        var map = LinkedHashMap<Int, Double>()
//        for(num in numlist) {
//            map[num] = if(num>n) (num-n).toDouble() else (n-num+0.5)
//        }
//        map = map.toList().sortedBy {it.second}.toMap() as LinkedHashMap<Int, Double>
//
//        return map.keys.toIntArray()
//마지막 테스트케이스 시간 초과

        val arr = ArrayList<Int>()
        for(num in numlist) {
            arr.add(num)
        }
        numlist.sortedWith {a, b ->
            if(abs(a-n) == abs(b-n)) {
                if(a>b) -1 else 1
            } else {
                abs(a-n) - abs(b-n)
            }
        }
        return arr.toIntArray()

//        return numlist.sortedWith { a, b ->
//            if(abs(a-n) == abs(b-n)) b.compareTo(a) else abs(a-n).compareTo(abs(b-n))
//        }.toIntArray()
    }
}

/* map 정렬 */
//map.toSortedMap() //Key 기준 오름차순
//toList() 로 변환하면 List는 Pair<Key, Value> 로 구성됨
//map.toList().sortedBy {it.second}.toMap() as MutableMap //Value 기준 오름차순
//map.toList().sortedByDescending {it.second}.toMap() as MutableMap //Value 기준 내림차순
//map.forEach { (k,v) -> println("${k}, ${v}")} //map 출력