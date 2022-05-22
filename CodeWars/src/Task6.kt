package kyu_6

import java.math.BigInteger

fun bouncingBall(h:Double, bounce:Double, window:Double):Int {
    if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h)
        return -1

    var countOfBounce = 1
    var height: Double = h * bounce

    while (height > window){
        countOfBounce += 2
        height *= bounce
    }

    return countOfBounce
}

// Best Solution
/*
import kotlin.math.*

fun bouncingBall(h: Double, bounce: Double, window: Double)
= 1 + (ceil(log(window / h, bounce)).toInt() - 1) * 2
 */

fun sumParts(ls: IntArray): IntArray {
    val newLS = IntArray(ls.size + 1)
    for (i in newLS.size-2 downTo 0)
        newLS[i] = ls[i] + newLS[i + 1]
    return newLS
}

/*
fun sumParts(ls: IntArray) =
ls.foldRightIndexed(IntArray(ls.size + 1)) { i, n, acc  -> acc[i] = acc[i + 1] + n; acc }
 */

fun decode(str: String): Int {
    var number = 0
    val romeNumbers = str.replace("IV", "IIII").
    replace("IX", "VIIII").
    replace("XL", "XXXX").
    replace("XC", "LXXXX").
    replace("CD", "CCCC").
    replace("CM", "DCCCC")

    for (r in romeNumbers)
        when(r){
            'I' -> number++
            'V' -> number += 5
            'X' -> number += 10
            'L' -> number += 50
            'C' -> number += 100
            'D' -> number += 500
            'M' -> number += 1000
        }

    return number
}

/*
fun decode(str: String): Int {
    var result:Int = 0
    var lastDigit:Char = ' '
    for (c in str) {
        when(c) {
            'I' -> result += 1
            'V' -> if (lastDigit == 'I') result += 3 else result += 5
            'X' -> if (lastDigit == 'I') result += 8 else result += 10
            'L' -> if (lastDigit == 'X') result += 30 else result += 50
            'C' -> if (lastDigit == 'X') result += 80 else result += 100
            'D' -> if (lastDigit == 'C') result += 300 else result += 500
            'M' -> if (lastDigit == 'C') result += 800 else result += 1000
        }
        lastDigit = c;
    }
    return result
}
 */

fun encode(num: Int): String {
    if (num == 0) return ""

    var romeLine = ""
    var number = num
    val map = mapOf('M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1)

    while (number > 0)
        for ((sym, num) in map)
            if (number >= num){
                romeLine += "$sym"
                number -= num
                break
            }

    return romeLine.replace("DCCCC", "CM").
    replace("CCCC", "CD").
    replace("LXXXX", "XC").
    replace("XXXX", "XL").
    replace("VIIII", "IX").
    replace("IIII", "IV")
}

/*
fun encode(num: Int): String {
    tailrec fun encodeAux(num: Int, acc: String): String =
        if (num == 0) acc else {
            val (k, v) = numerals.first { it.second <= num }
            encodeAux(num - v, acc + k)
        }
    return encodeAux(num, "")
}

val numerals = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I").zip(
    listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
)
 */

object Finance {
    fun finance(n: Int): BigInteger {
        var money: Long = n.toLong()

        money *= n + 1
        money *= n + 2
        money /= 2

        return BigInteger.valueOf(money)
    }
}

object KataSolution {
    fun multiplicationTable(size: Int): Array<IntArray> {
        val matrix = Array(size) { IntArray(size) { 0 } }

        for (i in 0 until size)
            for (j in 0 until size)
                matrix[i][j] = (j + 1) * (i + 1)

        return matrix
    }
}

/*
object KataSolution {
    fun multiplicationTable(size: Int) =
    Array(size) { x -> IntArray(size) { y -> (x + 1) * (y + 1) } }
}
 */

fun sqInRect(length: Int, width: Int) : List<Int>? {
    var list: MutableList<Int> = mutableListOf()
    var (a, b) = length to width
    var wasEquals = false

    while (a != b || !wasEquals){
        list.add(Math.min(a, b))

        var element = Math.max(a, b) - list?.get(list.size - 1)
        when {
            a > b -> a = element
            a < b -> b = element
            else -> wasEquals = true
        }
    }

    return list
}

/*
fun sqInRect(lng:Int, wdth:Int): List<Int>? {
    if (lng == wdth) return null

    val result = mutableListOf<Int>()

    var currentLength = lng
    var currentWidth = wdth

    while (currentLength > 0 && currentWidth > 0) {
        val minSide = Math.min(currentLength, currentWidth)

        if (currentLength > currentWidth) currentLength -= minSide
        else currentWidth -= minSide

        result += minSide
    }

    return result
}

tailrec fun sqInRect(l:Int, w:Int, list:List<Int> = listOf<Int>()):List<Int>? {
    return if (l == w && list.isEmpty()) {
        null
    } else if (l == w) {
        list.plus(l)
    } else {
        val c = minOf(l, w)
        sqInRect(maxOf(l, w) - c, c, list.plus(c))
    }
}
 */

fun longestConsec(strArr: Array<String>, k: Int) : String {
    if (strArr.isEmpty() || k > strArr.size || k <= 0)
        return ""

    val list = mutableListOf<String>()
    for (i in 0..strArr.size - k){
        var str = ""
        for (j in 1..k)
            str += strArr[i + j - 1]
        list.add(str)
    }
    list.reversed()

    var line = ""
    for (l in list)
        if (l.length > line.length)
            line = l

    return line
}

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String {
    var countOfWin = 0
    for (t in ticket)
        if (t.second.toChar() in t.first.toCharArray()){
            countOfWin++
            continue
        }
    return if (countOfWin >= win) "Winner!" else "Loser!"
}

/*
fun bingo(ticket: Array<Pair<String, Int>>, win: Int) =
    if(ticket.count { (t, c) -> t.contains(c.toChar()) } >= win)
        "Winner!" else "Loser!"
 */

fun persistence(num: Int) : Int {
    var (count, digits) = Pair(0, num)
    while (digits > 9) {
        var multiplyOfDigits = 1
        for (digit in digits.toString())
            multiplyOfDigits *= digit - '0'
        digits = multiplyOfDigits
        count++
    }
    return count
}

/*
fun persistence(num: Int) = generateSequence(num) {
        it.toString().map(Character::getNumericValue).reduce { mult, element -> mult * element }
    }.takeWhile { it > 9 }.count()
 */

fun solution(number: Int): Int {
    var sum = 0
    for (i in 1 until number)
        if (i % 3 == 0 || i % 5 == 0)
            sum += i
    return sum
}

// fun solution(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()

fun spinWords(sentence: String): String {
    var string = ""
    for (word in sentence.split(" "))
        string += if (word.length >= 5)
            "${word.reversed()} "
        else
            "$word "
    return string.substring(0, string.length - 1)
}

// fun spinWords(s: String) = s.split(" ").joinToString(" ") { if (it.length > 4) it.reversed() else it }

fun find(integers: Array<Int>): Int {
    val odd = integers.filter { i -> i % 2 != 0}
    val even = integers.filter { i -> i % 2 == 0}
    return if (odd.size == 1) odd[0] else even[0]
}

// fun find(integers: Array<Int>) = integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }

fun meeting(s: String): String {
    var result = ""
    var list = s.split(";")
    for (l in list) result += "(${l.substringAfter(":")}, ${l.substringBefore(":")})".toUpperCase()
    return result
}










