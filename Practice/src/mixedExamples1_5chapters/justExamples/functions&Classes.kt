import java.io.BufferedReader
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.util.Random

fun getIncrementNumber(n: Int = 0): Int = n + 1

class OpenPerson(var name: String, var age: Int){
    override fun toString(): String {
        return "Person: $name, $age"
    }
}

class Person(val name: String, val age: Int){
    override fun toString(): String {
        return "Person: $name, $age"
    }
}

class ClosePerson(private val name: String,private val age: Int){
    override fun toString(): String {
        return "Person: $name, $age"
    }
}

data class Beer(val name: String, val volume: Double)

fun max(a: Double, b: Double): Double = if (a > b) a else b

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle{
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

enum class Color(private val r: Int, private val g: Int, private val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(75,0,130),
    VIOLET(238,130,238),
    NEUTRAL(0,0,0); // ";" !!!!!

    fun gerRGB() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "of"
        Color.YELLOW -> "York"
        Color.GREEN -> "gave"
        Color.BLUE -> "battle"
        Color.INDIGO -> "in"
        Color.VIOLET -> "vain"
        Color.NEUTRAL -> "neutral"
    }

fun getWarmth(color: Color) = when(color){
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN, Color.NEUTRAL -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun getMixColors(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> Color.NEUTRAL
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) ||
        (c1 == Color.YELLOW && c2 == Color.RED) ->
            Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) ->
            Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) ->
            Color.INDIGO
        else -> Color.NEUTRAL
    }

