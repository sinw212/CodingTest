package com.example.kotlincodingtest.algorithm

fun main() {
    println(Sort().selectionSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).joinToString(", "))
    println(Sort().bubbleSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).joinToString(", "))
    println(Sort().insertSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).joinToString(", "))
    println(Sort().quickSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).joinToString(", "))
    println(Sort().mergeSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).joinToString(", "))
    println(Sort().heapSort(intArrayOf(5, 7, 4, 5, 2, 8, 1, 3, 2)).reversed().joinToString(", "))
}

class Sort {
    /**
     * 선택 정렬
     */
    fun selectionSort(arr: IntArray): IntArray {
        for(i in 0 until arr.size - 1) {
            var minIdx = i
            for(j in i + 1 until arr.size) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j
                }
            }
            val temp = arr[i]
            arr[i] = arr[minIdx]
            arr[minIdx] = temp
        }
        return arr
    }

    /**
     * 버블 정렬
     */
    fun bubbleSort(arr: IntArray): IntArray {
        for(i in 0 until arr.size - 1) {
            for(j in 0 until arr.size - 1 - i) {
                if(arr[j] > arr[j+1]) {
                    val temp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = temp
                }
            }
        }
        return arr
    }

    /**
     * 삽입 정렬
     */
    fun insertSort(arr: IntArray): IntArray {
        for(i in 1 until arr.size) {
            for(j in i downTo 1) {
                if(arr[j] < arr[j-1]) {
                    val temp = arr[j]
                    arr[j] = arr[j-1]
                    arr[j-1] = temp
                } else break
            }
        }
        return arr
    }

    /**
     * 퀵 정렬
     * (제일 왼쪽 값을 pivot으로 정한 경우)
     */
    fun quickSort(arr: IntArray, low: Int = 0, high: Int = arr.size - 1): IntArray {
        if(low >= high) return arr

        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex-1)
        quickSort(arr, pivotIndex+1, high)

        return arr
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[low]
        var l = low + 1
        var h = high

        while(l <= h) {
            while(l <= h && arr[l] <= pivot) l++
            while(l <= h && arr[h] >= pivot) h--

            if(l < h) {
                swapQuick(arr, l, h)
            } else break
        }
        swapQuick(arr, low, h)

        return h
    }

    private fun swapQuick(arr: IntArray, low: Int, high: Int) {
        val temp = arr[low]
        arr[low] = arr[high]
        arr[high] = temp
    }

    /**
     * 병합 정렬
     */
    fun mergeSort(arr: IntArray): IntArray {
        if(arr.size < 2) return arr

        val mid = arr.size / 2
        val left = arr.sliceArray(0 until mid)
        val right = arr.sliceArray(mid until arr.size)

        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        var sortArr = intArrayOf()
        var l = 0
        var r = 0

        while(l < left.size && r < right.size) {
            sortArr += if(left[l] <= right[r]) left[l++] else right[r++]
        }

        if(l < left.size) {
            sortArr += left.sliceArray(l until left.size)
        }

        if(r < right.size) {
            sortArr += right.sliceArray(r until right.size)
        }

        return sortArr
    }

    /**
     * 힙 정렬
     * (최소 힙 구현)
     */
    fun heapSort(arr: IntArray): IntArray {
        for(i in arr.size/2 - 1 downTo 0) {
            heapify(arr, arr.size, i)
        }

        for(i in arr.size-1 downTo 1) {
            swapHeap(arr, 0, i)
            heapify(arr, i, 0)
        }

        return arr
    }

    private fun heapify(arr: IntArray, n: Int, i: Int) {
        var smallest = i
        val left = 2 * i + 1 //왼쪽 자식노드
        val right = 2 * i + 2 //오른쪽 자식노드

        if(left < n && arr[left] < arr[smallest]) {
            smallest = left
        }
        if(right < n && arr[right] < arr[smallest]) {
            smallest = right
        }

        if(smallest != i) {
            swapHeap(arr, smallest, i)
            heapify(arr, n, smallest)
        }
    }

    private fun swapHeap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}