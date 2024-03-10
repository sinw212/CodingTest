package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution퍼즐조각채우기().solution(
        arrayOf(intArrayOf(1,1,0,0,1,0),intArrayOf(0,0,1,0,1,0),intArrayOf(0,1,1,0,0,1),
            intArrayOf(1,1,0,1,1,1), intArrayOf(1,0,0,0,1,0), intArrayOf(0,1,1,1,0,0)),
        arrayOf(intArrayOf(1,0,0,1,1,0), intArrayOf(1,0,1,0,1,0), intArrayOf(0,1,1,0,1,1),
            intArrayOf(0,0,1,0,0,0), intArrayOf(1,1,0,1,1,0), intArrayOf(0,1,0,0,0,0))
    )) //14
    println(Solution퍼즐조각채우기().solution(
        arrayOf(intArrayOf(0,0,0), intArrayOf(1,1,0), intArrayOf(1,1,1)),
        arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,0), intArrayOf(0,0,0))
    )) //0

    println(Solution퍼즐조각채우기().solution(
        arrayOf(intArrayOf(1,0,0), intArrayOf(0,0,1), intArrayOf(1,0,0)),
        arrayOf(intArrayOf(0,1,0), intArrayOf(1,1,1), intArrayOf(1,0,1))
    )) //6
}

class Solution퍼즐조각채우기 {
    lateinit var newBoard: Array<IntArray>
    lateinit var newPuzzle: Array<IntArray>
    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        newBoard = game_board.copyOf()
        newPuzzle = table.copyOf()
        val emptySpace = mutableListOf<MutableList<Point>>()
        val puzzleList = mutableListOf<MutableList<Point>>()
        for(i in game_board.indices) {
            for(j in game_board[i].indices) {
                if(newBoard[i][j] == 0) {
                    emptySpace += getBlocks(0, i, j, mutableListOf(), newBoard)
                }
                if(newPuzzle[i][j] == 1) {
                    puzzleList += getBlocks(1, i, j, mutableListOf(), newPuzzle)
                }
            }
        }

        val visitedPuzzle = BooleanArray(puzzleList.size) { false }
        var count = 0
        for(board in emptySpace) {
            for(idx in puzzleList.indices) {
                if(!visitedPuzzle[idx] && checkEquals(board, puzzleList[idx])) {
                    visitedPuzzle[idx] = true
                    count += puzzleList[idx].size
                    break
                }
            }
        }
        return count
    }


    fun checkEquals(board: MutableList<Point>, puzzle: MutableList<Point>): Boolean {
        if(board.size != puzzle.size) return false

        val sortedBoard = board.sortedWith (compareBy<Point> { it.x }.thenBy { it.y })
        var rotationPuzzle = puzzle.toList()
        var isMatch = true
        for(n in 0 until 4) { //원상태 + 회전3번
            val arr = mutableListOf<Point>()
            for(i in rotationPuzzle.indices) {
                val tempX = rotationPuzzle[i].x
                val tempY = rotationPuzzle[i].y
                arr += Point(tempY, -tempX)
            }
            val sortedPuzzle = arr.sortedWith (compareBy<Point> { it.x }.thenBy { it.y })
            rotationPuzzle = sortedPuzzle
            val diffX = sortedBoard[0].x - rotationPuzzle[0].x
            val diffY = sortedBoard[0].y - rotationPuzzle[0].y
            for(i in 1 until sortedBoard.size) {
                if(sortedBoard[i].x - rotationPuzzle[i].x != diffX
                    || sortedBoard[i].y - rotationPuzzle[i].y != diffY) {
                    isMatch = false
                    break
                }
            }
            if(isMatch) {
                return true
            }
            isMatch = true
        }
        return false
    }

    val dirX = listOf(1, -1, 0, 0)
    val dirY = listOf(0, 0, 1, -1)
    fun getBlocks(num: Int, i: Int, j: Int, blocks: MutableList<Point>, arr: Array<IntArray>): MutableList<Point> {
        arr[i][j] = if(num == 1) 0 else 1
        blocks += Point(i, j)
        for(x in dirX.indices) {
            val dx = i + dirX[x]
            val dy = j + dirY[x]
            if(dx in arr.indices && dy in arr.indices && arr[dx][dy] == num) {
                getBlocks(num, dx, dy, blocks, arr)
            }
        }
        return blocks
    }

    data class Point(val x: Int, val y: Int)
}