package com.example.kotlincodingtest.algorithm

fun main() {
    RegularExpression().regex()
}

class RegularExpression {
    fun regex() {
        println("가나다라 09 aAVz".matches(Regex("^[\\s가-힣a-zA-z]{2,10}$"))) //false - 0-9가 포함되지 않고 10글자가 넘기 때문
        println("가나다라 09 aAVz".matches(Regex("^[가-힣0-9a-zA-z]"))) //false - 공백이 있기 때문
        println("가나다라 09 aAVz".matches(Regex("^[\\s가-힣0-9a-zA-z]{2,20}$"))) //true - 전부 충족
        println()
        println(".!@BaT#*...y.ab".replace(Regex("[^a-z0-9._-]"), "")) //소문자, 숫자, -, _, . 제외한 모든 문자 제거
        println(".!@BaT#*...y.ab".replace(Regex("^[.]|[.]$"), "")) //.가 처음이나 끝에 위치한다면 제거
        println(".!@BaT#*...y.ab".replace(Regex("[.]{2,}"), ".")) //.가 2번 이상 연속된 부분을 하나의 .로 치환
    }
}
/**
 * 문법
 * ^ : 문자열의 시작을 의미
 * $ : 문자열의 끝을 의미
 * . : 문자 한 개를 의미 - ’.’이 위치한 곳에 어떤 문자든지 1개의 문자가 들어감
 * [] : 대괄호에 있는 문자 중 한개를 의미 - [abc ]는 a, b, c 중 하나를 선택
 * [^] : not의 의미 - [^abc]는 a, b, c 제외하고 나머지를 의미
 * | : or를 의미 - a|b는 a 또는 b
 * () : 공통되는 부분을 묶을 때, 서브 패턴을 지정할 때 사용 - abc|abd → ab(c|d)로 변경 가능
 * ? : 문자가 0회 또는 1회 등장 - a? b = ab, b
 * * : 문자가 0회 이상 등장 - a*b = b, ab, aab, aaab …
 * + : 문자가 1회 이상 등장 - a+b = ab, aab, aaab …
 * {n} : 문자가 n개 나옴 - a {2} b = aab
 * {n,} : 문자가 n개 이상 나옴 - a {2,} b = aab, aaab, aaaab …
 * {n, m} : 문자가 n개 이상 m개 이하로 나옴 - a {1, 3} b : ab, aab, aaab
 * \s : 공백 제거
 * \t : tab
 * \d : 숫자, [0-9]와 동일
 * \b : 단어의 경계, 문자 사이의 공백
 * \w : 알파벳이나 숫자, [a-zA-Z0-9]와 동일
 * \s, \t, \d, \b, \w는 대문자로 바꾸면 반대 의미가 됨
 */