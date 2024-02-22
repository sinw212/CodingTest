package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution신규아이디추천().solution("...!@BaT#*..y.abcdefghijklm")) //"bat.y.abcdefghi"
    println(Solution신규아이디추천().solution("z-+.^.")) //"z--"
    println(Solution신규아이디추천().solution("=.=")) //"aaa"
    println(Solution신규아이디추천().solution("123_.def")) //"123_.def"
    println(Solution신규아이디추천().solution("abcdefghijklmn.p")) //"abcdefghijklmn"
}

class Solution신규아이디추천 {
    fun solution(new_id: String): String {
        return new_id.lowercase() //모든 대문자를 대응되는 소문자로 치환
            .replace(Regex("[^a-z0-9._-]"), "") //소문자, 숫자, -, _, . 제외한 모든 문자 제거
            .replace(Regex("[.]{2,}"), ".") //.가 2번 이상 연속된 부분을 하나의 .로 치환
            .replace(Regex("^[.]|[.]$"), "") //.가 처음이나 끝에 위치한다면 제거
            .let { if(it.isNullOrBlank()) "a" else it } //빈 문자열이라면 "a" 대입
            .let { if(it.length >= 16) it.substring(0, 15) else it } //길이가 16자 이상이면, 첫 15개의 문자 제외한 나머지 문자 모두 제거
            .replace(Regex("[.]$"), "") //제거 후 .가 끝에 위치한다면 끝에 위치한 . 문자 제거
            .let { //길이가 2자 이하라면, 길이가 3이 될 때까지 마지막 문자 반복해서 끝에 붙임
                if(it.length <= 2) {
                    StringBuilder(it).run {
                        while (length < 3) append(it.last())
                        toString()
                    }
                } else it
            }
    }
}