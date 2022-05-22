fun rowSumOddNumbers(n: Int): Int {
    return n * n * n
}

// Best Solution
// fun rowSumOddNumbers(n: Int): Int = n * n * n

class SmallestIntegerFinder {
    fun findSmallestInt(nums: List<Int>): Int = nums.minOrNull()!!
}

fun crap(x: Array<CharArray>, bags: Int, cap: Int): String {
    var countCrap = 0
    for (i in x)
        for (j in i) {
            if (j == '@')
                countCrap++
            if (j == 'D')
                return "Dog!!"
        }

    return if (bags * cap >= countCrap) "Clean" else "Cr@p"
}

// Best Solution
/*
fun crap(x: Array<CharArray>, bags: Int, cap: Int) =
    if (x.any { chars -> chars.any { it == 'D' } })
     "Dog!!" else if (x.sumBy { chars -> chars.count { it == '@' } } <= bags * cap) "Clean"
     else "Cr@p"
 */

fun longest(s1: String, s2: String): String =
    (s1 + s2).toSortedSet().joinToString().replace(", ", "")

// Best Solution
// fun longest(s1:String, s2:String) = "$s1$s2".toSortedSet().joinToString("")

fun highAndLow(numbers: String): String {
    val separateNumbers = numbers.split(" ").toTypedArray()
    var max = separateNumbers[0].toInt()
    var min = separateNumbers[0].toInt()

    for (sN in separateNumbers) {
        if (max < sN.toInt())
            max = sN.toInt()
        if (min > sN.toInt())
            min = sN.toInt()
    }

    return "$max $min"
}

// Best Solution
/*
fun highAndLow(numbers: String): String {
    val intList = numbers.split(" ").map{it.toInt()}
    return "${intList.max()} ${intList.min()}"
}
 */

fun nbDig(n: Int, d: Int): Int {
    val k = Array(n + 1) { "0" }

    var count = 0
    for (i in 0..n) {
        k[i] = (i * i).toString()

        for (el in k[i])
            if (el.toInt() - 48 == d)
                count++
    }

    return count
}

// Best Solution
/*
fun nbDig(n:Int, d:Int) = (0..n).sumBy { (it * it).toString().count
 { it == Character.forDigit(d, 10) } }
 */

fun getMiddle(word: String): String {
    return if (word.length % 2 != 0)
        word[word.length / 2].toString()
    else word[word.length / 2 - 1].toString() +
            word[word.length / 2].toString()
}

// Best Solution
/*
fun getMiddle(word : String) : String {
  return word.substring((word.length - 1) / 2, word.length / 2 + 1)
}
 */

// ###################################

fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int {
    var count = 0
    var percentage = 100.0
    while (percentage > threshold) {
        count++
        percentage *= 1 - evap_per_day / 100
    }
    return count
}

/*
fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int =
Math.ceil(Math.log(threshold / 100) / Math.log(1 - (evap_per_day / 100))).toInt()
 */

fun findScreenHeight(width: Int, ratio: String): String =
    "${width}x${width * (ratio.substringAfter(":").toInt()) / (ratio.substringBefore(":").toInt())}"

/*
fun findScreenHeight(width: Int, ratio: String) =
"${width}x${ratio.split(":").let { width * it[1].toInt() / it[0].toInt() }}"
 */

fun alphabetWar(fight: String): String {
    var countLeft = 0
    var countRight = 0

    for (f in fight) {
        countLeft += when (f) {
            'w' -> 4
            'p' -> 3
            'b' -> 2
            's' -> 1
            else -> 0
        }

        countRight += when (f) {
            'm' -> 4
            'q' -> 3
            'd' -> 2
            'z' -> 1
            else -> 0
        }
    }

    return when {
        countLeft > countRight -> "Left side wins!"
        countLeft == countRight -> "Let's fight again!"
        else -> "Right side wins!"
    }
}

/*
  fun alphabetWar(fight: String): String {
    val s = fight.sumBy { if (it in "zdqmsbpw") "mqdz|sbpw".indexOf(it) - 4 else 0 }
    return if (s < 0) "Right side wins!" else if (s > 0) "Left side wins!" else "Let's fight again!"
}
 */

fun fizzBuzz(n: Int): Array<String> {
    val arr = Array<String>(n) { "" }
    for (i in 0 until n) {
        when {
            (i + 1) % 15 == 0 -> arr[i] = "FizzBuzz"
            (i + 1) % 3 == 0 -> arr[i] = "Fizz"
            (i + 1) % 5 == 0 -> arr[i] = "Buzz"
            else -> arr[i] = (i + 1).toString()
        }
    }
    return arr
}

/*
fun fizzBuzz(n: Int): Array<String> {
    return (1..n).map{
    if(it.rem(3) == 0 && it.rem(5) == 0)
    "FizzBuzz" else if (it.rem(3) == 0) "Fizz" else if (it.rem(5) == 0) "Buzz" else it.toString() }.toTypedArray()
}
 */

fun getCount(str: String): Int {
    val arr = "aeiou".toCharArray()
    var sum = 0
    for (s in str)
        for (a in arr)
            if (s == a) sum++
    return sum
}

// fun getCount(str : String) = str.count { it in "aeiou" }

fun findShort(s: String): Int = s.split(" ").minByOrNull { it.length }!!.length
// fun findShort(s: String) = s.split(' ').map(String::length).min()

fun accum(s: String): String {
    var arr = arrayListOf<String>()
    for (i in s.indices) arr.add((s[i].toString().repeat(i + 1)).toLowerCase().capitalize())
    return arr.joinToString("-")
}

// fun accum(s:String):String =
// s.mapIndexed { index, char -> char.toUpperCase() + char.toString().toLowerCase().repeat(index) }.joinToString("-")

fun makeComplement(dna: String): String =
    dna.replace("A", "a").replace("T", "A").replace("a", "T").replace("G", "g").replace("C", "G").replace("g", "C")

fun people(busStops: Array<Pair<Int, Int>>): Int {
    var people = 0
    busStops.forEach { (first, second) -> people += first - second }
    return people
}

// fun people(busStops: Array<Pair<Int, Int>>) = busStops.sumBy { it.first - it.second }

fun smallEnough(array: IntArray, limit: Int): Boolean =
    array.all { it <= limit }

fun maxRot(n: Long): Long {
    var max = n;
    var strn = n.toString()
    var left = 1
    strn = strn.slice(1 until strn.length) + strn[0]
    while (left < strn.length - 1) {
        if (strn.toLong() >= max) max = strn.toLong()
        strn = strn.slice(0 until left) + strn.slice(left + 1 until strn.length) + strn[left]
        left += 1
    }
    return max
}

/*
fun maxRot(n:Long):Long {
    var max = n
    var s = n.toString()
    for (pos in 0..s.length - 2) {
        s = s.substring(0, pos) + s.substring(pos + 1, s.length) + s[pos]
        max = max.coerceAtLeast(s.toLong())
    }
    return max
}
 */

fun gps(s: Int, x: DoubleArray): Int =
    if (x.size <= 1) 0 else DoubleArray(x.size - 1) { i -> (x[i + 1] - x[i]) * 3600 / s }.maxOrNull()?.toInt()!!

fun printerError(s: String): String = "${s.filter { it !in 'a'..'m' }.count()}/${s.length}"

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
    if (a1.isEmpty() || a2.isEmpty()) return -1
    val mutableList = mutableListOf<Int>()
    for (x in a1)
        for (y in a2)
            mutableList.add(kotlin.math.abs(x.length - y.length))
    return mutableList.maxOrNull()!!
}

fun maxMultiple(d: Int, b: Int): Int = b - b % d

fun reverseLetter(str: String): String = str.filter { it in 'a'..'z' }.reversed()

fun capitalize(text: String): List<String> {
    var (res1, res2) = "" to ""
    for (i in text.indices) {
        if (i % 2 == 0) {
            res1 += text[i].toUpperCase()
            res2 += text[i]
        } else {
            res1 += text[i]
            res2 += text[i].toUpperCase()
        }
    }
    return listOf(res1, res2)
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    val list = ages.toMutableList()
    val oldestAge = list.maxOrNull()!!
    list.remove(oldestAge)
    val secondOldestAge = list.maxOrNull()!!
    return listOf(secondOldestAge, oldestAge)
}

// fun twoOldestAges(ages: List<Int>) = ages.sorted().takeLast(2)

fun isLeapYear(year: Int): Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

fun seven(n: Long): LongArray {
    var count = 0L
    var num = n
    while (num % 100 != num) {
        num = num / 10 - 2 * (num % 10)
        count += 1
    }
    return longArrayOf(num, count)
}

fun count(number: Int): Int {
    if (number % 10 != 0) return -1
    var count = 0
    var money = number
    for (n in arrayOf(500, 200, 100, 50, 20, 10)) {
        while (money >= n) {
            money -= n
            count++
        }
        if (money == 0) break
    }
    return count
}

/*
fun count(number: Int): Int {
    return if (number % 10 != 0) {
        -1
    } else {
        listOf(500, 200, 100, 50, 20, 10)
            .fold(listOf(number, 0)) { acc, i -> listOf(acc[0] % i, acc[1] + acc[0] / i) }[1]
    }
}
 */

//fun addLetters(arr: List<Char>): Char {
//    var sum = arr.sumBy { it.toInt() }
//    while (sum > 26) sum %= 26 + 1
////    if (sum == 0) sum++
//
//
//    return sum.toChar() + 97
//}

fun addLetters(arr: List<Char>): Char =
    if (arr.isEmpty()) 'z' else ((arr.sumBy { it - 'a' + 1 } - 1) % 26 + 97).toChar()

// fun addLetters(arr: List<Char>) = 'z' - arr.sumBy { 'z' - it } % 26

fun repeats(arr: IntArray): Int {
    var (sum, list) = 0 to arr.toList()
    for (number in list) {
        if (java.util.Collections.frequency(list, number) == 1)
            sum += number
    }
    return sum
}

// fun repeats(arr: IntArray): Int = 2 * arr.distinct().sum() - arr.sum()

fun moveTen(s: String): String =
    Array(s.length) { i -> s[i] }.map { if (it + 10 > 'z') it + 10 - 26 else it + 10 }.joinToString("")

// fun moveTen(s: String) = s.map { 'a' + (((it - 'a') + 10) % 26) }.joinToString("")

fun potatoes(p0: Int, w0: Int, p1: Int): Int = w0 / (2 * (p0 - p1))

fun angle(n: Int): Int = 180 * (n - 2)

fun nameValue(arr: Array<String>): IntArray = IntArray(arr.size)
{ i -> arr[i].replace(" ", "").toCharArray().sumBy { it.toInt() - 96 } * (i + 1) }

// fun nameValue(arr: Array<String>) =
// arr.mapIndexed { i, s -> s.replace(" ", "").sumBy { it.toInt() - 96 } * (i + 1) }.toIntArray()

//fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int =
//    kotlin.math.sqrt(((age1 * age1 + age2 * age2 + age3 * age3 + age4 * age4 + age5 * age5 + age6 * age6 + age7 * age7 + age8 * age8).toDouble()))
//        .toInt()) / 2

fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int =
    kotlin.math.sqrt(
        (age1 * age1 + age2 * age2 + age3 * age3 + age4 * age4 +
                age5 * age5 + age6 * age6 + age7 * age7 + age8 * age8).toFloat()
    ).toInt() / 2

fun containAllRots(string: String, arr: ArrayList<String>): Boolean {
    if (string !in arr) return false

    val listOfAllWords = arrayListOf<String>()
    var word = string
    for (i in string.indices) {
        listOfAllWords.add(word)
        word = "${word[word.length - 1]}${word.substring(0, word.length - 1)}"
    }

    var count = 0
    for (lOAW in listOfAllWords)
        if (lOAW in arr)
            count++

    return count == string.length
}

/*
fun containAllRots(x:String, arr:ArrayList<String>):Boolean {
    val rots = (0 until x.length).map { x.takeLast(it) + x.dropLast(it) }
    return arr.containsAll(rots)
}
 */

fun inviteMoreWomen(l: List<Int>): Boolean = l.sum() > 0

fun argsCount(vararg args: Any): Int = args.size

fun catMouse(s: String): String = if (s.length > 5) "Escaped!" else "Caught!"

fun duplicates(array: IntArray): Int {
    if (array.size < 2) return 0
    val uniqueArr = array.toHashSet()
    var pair = 0
    for (uA in uniqueArr) {
        var count = 0
        for (a in array)
            if (uA == a) count++
        if (count > 1) pair += count / 2
    }
    return pair
}

// fun duplicates(array: IntArray) = array.groupBy { it }.map { it.value.size / 2 }.sum()

fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    val filteredArray = array.filter { it % 2 == 0 }
    return List(number) { i -> filteredArray[filteredArray.size - number + i] }
}

// fun evenNumbers(array: List<Int>, number: Int) = array.filter{ it % 2 == 0 }.takeLast(number)

fun countRedBeads(nBlue: Int): Int = if (nBlue < 2) 0 else (nBlue - 1) * 2

fun newAvg(a: DoubleArray, navg: Double): Long =
    Math.ceil(navg * (a.size + 1) - a.sum()).toLong().takeIf { it > 0 } ?: throw IllegalArgumentException()

/*
fun newAvg(a:DoubleArray, navg:Double):Long {
    if (navg <= 0) {
        throw IllegalArgumentException("Illegal argument")
    } else if (navg < a.average()) {
        throw IllegalArgumentException("Illegal argument")
    } else {
        return ceil(((navg * (a.size + 1)) - a.sum())).toLong()
    }
}
 */

/*
fun newAvg(a:DoubleArray, navg:Double):Long {
    val x = navg*(a.size + 1) - a.sum()
    require(x >= 0)
    return ceil(x).roundToLong()
}
 */

object DoubleSort {
    fun dbSort(a: Array<Any>): Array<Any> {
        val listInt = a.filterIsInstance<Int>().sorted()
        val listString = a.filterIsInstance<String>().sorted()
        val array = Array<Any>(a.size){}
        var count = 0
        for (lI in listInt)
            array[count++] = lI
        for (lS in listString)
            array[count++] = lS
        return array
    }
}

/*
object DoubleSort {
    fun dbSort(a: Array<Any>): Array<Any> =
    (a.filterIsInstance<Int>().sortedBy { it } + a.filterIsInstance<String>().sorted()).toTypedArray()
}
 */

fun partlist(arr:Array<String>):Array<Array<String>> =
    Array(arr.size - 1) {
        arrayOf(
            arr.sliceArray(0..it).joinToString(" "),
            arr.sliceArray((it + 1) until arr.size).joinToString(" ")
        )
    }

fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
    var (h, day) = 0 to 1
    while (h <= desiredHeight){
        h += upSpeed
        if (h < desiredHeight)
            h -= downSpeed
        else
            break
        day++
    }
    return day
}

/*
fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
    val growFactor = upSpeed - downSpeed
    return if (desiredHeight < upSpeed) 1 else Math.ceil((desiredHeight - downSpeed).toDouble() / growFactor).toInt()
}
 */

fun babyCount(x: String): Int? {
    var aby = arrayOf(0,0,0)
    for (symbol in x)
        when (symbol) {
            'a', 'A' -> aby[0]++
            'b', 'B' -> aby[1]++
            'y', 'Y' -> aby[2]++
        }
    aby[1] /= 2
    return if (!aby.contains(0)) aby.minOrNull() else null
}