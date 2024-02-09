package com.example.kotlincodingtest.algorithm

fun main() {
    SortMethod().sort(listOf(1, 3, 5, 2, 4), mutableListOf(1, 3, 5, 2, 4))
    println("------------")
    SortMethod().sortWith(listOf("Apple", "Banana", "Cherry", "Kiwi"))
    println("------------")
    SortMethod().sortBy(mutableListOf("b" to 10, "a" to 5, "c" to 1))
    println("------------")
    SortMethod().sortMap(mutableMapOf(3 to "bbb", 1 to "ccc", 2 to "aaa"))
}

class SortMethod {
    // sorted(), sort() : 요소를 자연스러운 순서로 정렬한 새 리스트 반환
    fun sort(immutable: List<Int>, mutable: MutableList<Int>) { //*mutable : *listOf(1, 3, 5, 2, 4)
        //수정 불가 - sorted() : 새로운 리스트 생성하여 반환
        val imList = immutable.sorted()
        val reversedImList = immutable.reversed()
        println(imList) //[1, 2, 3, 4, 5]
        println(reversedImList) //[4, 2, 5, 3, 1]

        //수정 가능 - sort() : 리스트 자신의 순서 변경
        mutable.sort()
        println(mutable) //[1, 2, 3, 4, 5]
        mutable.reverse()
        println(mutable) //[5, 4, 3, 2, 1]
        //immutableList의 reversed()와 mutableList의 reverse() 동작이 다른 것 확인
    }

    // sortedWith(comparator), sortWith(comparator) : comparator를 사용하여 리스트 요소 정렬
    fun sortWith(arr: List<String>) { //arr : listOf("Apple", "Bananaaa", "Cherryyy", "Kiwi")
        //수정 불가 - sortedWith() : 새로운 리스트 생성하여 반환
        //단순 길이 순 정렬
        val length1 = arr.sortedWith { o1, o2 -> o1.length - o2.length }
        val length2 = arr.sortedWith(compareBy { it.length })
        println(length1) //[Kiwi, Apple, Banana, Cherry]
        println(length2) //[Kiwi, Apple, Banana, Cherry]

        //두가지 기준 정렬 (길이 순 오름차순 후, 길이가 같을 경우 내림차순 정렬)
        val sortedList1 = arr.sortedWith(Comparator<String> { o1, o2 -> o1.length - o2.length }
            .thenComparing(Comparator.reverseOrder()))
        val sortedList2 = arr.sortedWith(compareBy<String> { it.length }.thenByDescending { it })
        val sortedList3 = arr.sortedWith(compareByDescending<String> { it.length }.thenBy { it }) //sortedList2 반대 조건
        println(sortedList1) //[Kiwi, Apple, Cherry, Banana]
        println(sortedList2) //[Kiwi, Apple, Cherry, Banana]
        println(sortedList3) //[Banana, Cherry, Apple, Kiwi]

        //수정 가능 - sortWith() : 리스트 자신의 순서 변경
    }

    // sortedBy(selector), sortBy(selector) : selector를 사용하여 리스트 요소 정렬
    fun sortBy(arr: MutableList<Pair<String, Int>>) { //arr: mutableListOf("b" to 10, "a" to 5, "c" to 1)
        //수정 불가 - sortedBy() : 새로운 리스트 생성하여 반환
        //수정 가능 - sortBy() : 리스트 자신의 순서 변경
        println(arr.sortedBy { it.first }) //[(a, 5), (b, 10), (c, 1)]
    }

    fun sortMap(map : MutableMap<Int, String>) { //map : mutableMapOf(3 to "bbb", 1 to "ccc", 2 to "aaa")
        val key1 = map.keys.sorted()
        val value1 = map.values.sorted()
        println(key1) //[1, 2, 3]
        println(value1) //[aaa, bbb, ccc]

        val key2 = map.entries.sortedBy { it.key }
        val value2 = map.entries.sortedBy { it.value }
        println(key2) //[1=ccc, 2=aaa, 3=bbb]
        println(value2) //[2=aaa, 3=bbb, 1=ccc]

        val key3 = map.toSortedMap()
        val key4 = map.toSortedMap(compareByDescending { it })
        println(key3) //{1=ccc, 2=aaa, 3=bbb}
        println(key4) //{3=bbb, 2=aaa, 1=ccc}

        val value3 = map.toList().sortedBy { it.second }.toMap() as MutableMap
        val value4 = map.toList().sortedByDescending { it.second }.toMap() as MutableMap
        println(value3) //{2=aaa, 3=bbb, 1=ccc}
        println(value4) //{1=ccc, 3=bbb, 2=aaa}
    }
}