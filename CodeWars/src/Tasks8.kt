fun makeNegative(x: Int): Int = if (x >= 0) -x else x

fun productFib(prod:Long):LongArray {
    var prev: Long = 0
    var curr: Long = 1
    var multiply: Long = 0
    while (multiply < prod){
        var temp = curr
        curr += prev
        prev = temp
        multiply = prev * curr
    }

    return longArrayOf(prev, curr, if (multiply == prod) 1 else 0)
}

// Best Solution
/*
fun kyu_8.productFib(prod:Long):LongArray {
  var f1 = 0L
  var f2 = 1L
  while (f1*f2 < prod) {
      val f3 = f2+f1
      f1 = f2
      f2 = f3
  }
  return longArrayOf(f1, f2, if (f1*f2==prod) 1L else 0L)
 */

fun grow(arr: IntArray): Int = arr.reduce{acc, i -> acc * i}

fun maps(x: IntArray): IntArray {
    for (i in x.indices) x[i] *= 2
    return x
}

// fun kyu_8.maps(x : IntArray) = x.map { it * 2 }.toIntArray()

fun century(number: Int): Int = Math.ceil(number.toDouble() / 100).toInt()

fun removeChar(str: String): String = str.substring(1, str.length - 1)

// fun kyu_8.removeChar(str: String) = str.drop(1).dropLast(1)

fun noSpace(x: String): String = x.replace(" ", "")

// fun kyu_8.noSpace(x: String) = x.filterNot(Char::isWhitespace)
// fun kyu_8.noSpace(x: String) = x.filter { it != ' ' }

fun checkForFactor(base: Int, factor: Int): Boolean = base % factor == 0

// fun kyu_8.checkForFactor(base: Int, factor: Int) = base.rem(factor) == 0

class MixedSum {
    fun sum(mixed: List<Any>): Int {
        var arr = IntArray(mixed.size)
        for (i in mixed.indices)
            arr[i] = mixed[i].toString().toInt()
        return arr.sum();
    }
}

/*
public class kyu_8.MixedSum {
    public fun sum(mixed: List<Any>) = mixed.sumBy { it.toString().toInt() }
}
 */

fun evenOrOdd(number: Int): String = if (number % 2 == 0) "Even" else "Odd"

fun numberToString(num: Int): String = num.toString()

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int = Math.abs(dadYearsOld - 2 * sonYearsOld)

fun simpleMultiplication(n: Int): Int = if (n % 2 == 0) n * 8 else n * 9

// fun kyu_8.simpleMultiplication(n: Int) = n * (8 + n % 2)

fun loveFun(flowerA: Int, flowerB: Int): Boolean =
    (flowerA % 2 == 0 && flowerB % 2 == 1) || (flowerA % 2 == 1 && flowerB % 2 == 0)

// fun kyu_8.loveFun(flowerA: Int, flowerB: Int) = flowerA % 2 != flowerB % 2

fun countPositivesSumNegatives(input : Array<Int>?) : Array<Int> =
    if (input == null || input.isEmpty())
        arrayOf()
    else
        arrayOf(input.filter{ it > 0 }.count(), input.filter{ it < 0 }.sum())

fun elevator(left: Int, right: Int, call: Int): String =
    if (Math.abs(call - right) <= Math.abs(call - left)) "right" else "left"

fun reverseSeq(n: Int): List<Int> {
    val arr = IntArray(n)
    var count = n
    for (i in arr.indices)
        arr[i] = count--
    return arr.toList()
}

// fun kyu_8.reverseSeq(n: Int) = (n downTo 1).toList()
// fun kyu_8.reverseSeq(n: Int) = List(n) { n  - it }

fun subtractSum(n: Int): String {
    var number = n

    do{
        val digits = number.toString().toCharArray()
        var sum = 0
        for (d in digits)
            sum += d - '0'
        number -= sum
    }while (number > 100)

    return when (number) {
        1->"kiwi"
            2->"pear"
        3->"kiwi"
            4->"banana"
        5->"melon"
            6->"banana"
        7->"melon"
            8->"pineapple"
        9->"apple"
            10->"pineapple"
        11->"cucumber"
            12->"pineapple"
        13->"cucumber"
            14->"orange"
        15->"grape"
            16->"orange"
        17->"grape"
            18->"apple"
        19->"grape"
            20->"cherry"
        21->"pear"
            22->"cherry"
        23->"pear"
            24->"kiwi"
        25->"banana"
            26->"kiwi"
        27->"apple"
            28->"melon"
        29->"banana"
            30->"melon"
        31->"pineapple"
            32->"melon"
        33->"pineapple"
            34->"cucumber"
        35->"orange"
            36->"apple"
        37->"orange"
            38->"grape"
        39->"orange"
            40->"grape"
        41->"cherry"
            42->"pear"
        43->"cherry"
            44->"pear"
        45->"apple"
            46->"pear"
        47->"kiwi"
            48->"banana"
        49->"kiwi"
            50->"banana"
        51->"melon"
            52->"pineapple"
        53->"melon"
            54->"apple"
        55->"cucumber"
            56->"pineapple"
        57->"cucumber"
            58->"orange"
        59->"cucumber"
            60->"orange"
        61->"grape"
            62->"cherry"
        63->"apple"
            64->"cherry"
        65->"pear"
            66->"cherry"
        67->"pear"
            68->"kiwi"
        69->"pear"
            70->"kiwi"
        71->"banana"
            72->"apple"
        73->"banana"
            74->"melon"
        75->"pineapple"
            76->"melon"
        77->"pineapple"
            78->"cucumber"
        79->"pineapple"
            80->"cucumber"
        81->"apple"
            82->"grape"
        83->"orange"
            84->"grape"
        85->"cherry"
            86->"grape"
        87->"cherry"
            88->"pear"
        89->"cherry"
            90->"apple"
        91->"kiwi"
            92->"banana"
        93->"kiwi"
            94->"banana"
        95->"melon"
            96->"banana"
        97->"melon"
            98->"pineapple"
        99->"apple"
            100->"pineapple"
        else -> "LOL"
    }
}

// BUT!!!!!!
// fun kyu_8.subtractSum(n: Int): String = "apple"

fun seatsInTheater(nCols: Int, nRows: Int, col: Int, row: Int): Int = (nRows - row) * (nCols - col + 1)

fun oddCount(n: Int): Int = n / 2

// fun kyu_8.oddCount(n: Int) = n shr 1

fun feast(beast: String, dish: String): Boolean =
    beast[0] == dish[0] && beast[beast.length - 1] == dish[dish.length - 1]

// fun kyu_8.feast(beast: String, dish: String) = beast.first() == dish.first() && beast.last() == dish.last()
// fun kyu_8.feast(beast: String, dish: String) = beast.take(1) + beast.takeLast(1) == dish.take(1) + dish.takeLast(1)

fun include(arr: IntArray, item : Int): Boolean = arr.contains(item)

// fun kyu_8.include(arr: IntArray, item: Int) = item in arr

fun replace(s: String) = s.replace(Regex("[aeiouAEIOU]"), "!")

fun calculateYears(years: Int): Array<Int> {
    val catYears = if (years == 1) 15 else 24 + (years - 2) * 4
    val dogYears = if (years == 1) 15 else 24 + (years - 2) * 5
    return arrayOf(years, catYears, dogYears);
}

/*
fun kyu_8.calculateYears(years: Int): Array<Int> =
    if (years == 1) arrayOf(1, 15, 15) else arrayOf(years, 16 + 4 * years, 14 + 5 * years)
 */