package mixedExamples1_5chapters.justExamples.allExamplesForMarch

import java.io.BufferedReader
import java.io.File
import java.lang.NumberFormatException
import java.lang.StringBuilder

/*
fun eval(e: Expr): Int{
    if (e is Num) return e.value
    if (e is Sum) return eval(e.left) + eval(e.right)
    throw IllegalArgumentException("X expression!")
}
 */

fun eval(e: Expr): Int = when(e){
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("X expression!")
}

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("X expression!")
    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 5 == 0 -> "Buzz"
    i % 3 == 0 -> "Fizz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "Its a digit!"
    in 'a'..'z' -> "Its a letter!"
    in 'A'..'Z' -> "Its a letter!"
    else -> "HZ!"
}

fun readNumber(reader: BufferedReader): Int?{
    return try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        null
    } finally {
        reader.close()
    }
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = " ", // разделитель
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)

    for ((index, value) in collection.withIndex()){
        if (index > 0)
            result.append(separator)
        result.append(value)
    }

    return (result.append(postfix)).toString()
}

fun String.getFirstAndLastChar(): String = "${this[0]}${this[this.length - 1]}"
// String - тип-получатель
// this - объект-получатель

@JvmName("joinToStringT")
fun <T> Collection<T>.joinToString(
    separator: String = " ",
    prefix: String = "(",
    postfix: String = ")"
): String{
    val result = StringBuilder(prefix)

    for ((index, value) in this.withIndex()){
        if (index > 0)
            result.append(separator)
        result.append(value)
    }

    return (result.append(postfix)).toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)


fun View.showOff(): String = "I'm a view!"
fun Button.showOff(): String = "I'm a button!"

fun Class.method(): String = "function"
fun Class.method2(): String = "function"

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char){
        this.setCharAt(length - 1, value)
    }

fun getSum(vararg values: Int): Int = values.sum()

infix fun Int.plus(num: Int) = this + num
infix fun Int.minus(num: Int) = this - num
infix fun Int.multiply(num: Int) = this * num
infix fun Int.divide(num: Int) = this / num

fun parsePath(path: String): String {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    return "Directory: $directory, name: $fileName, ext: $extension"
}

fun parsePathRex(path: String): String?{
    val regex = """(.+ )/(.+ )\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    return if (matchResult != null){
        val (directory, filename, extension) = matchResult.destructured
        "Directory: $directory, name: $filename, ext: $extension"
    } else
        null
}

/*
fun safeUser(user: User){
    if (user.name.isEmpty())
        throw IllegalArgumentException("Can't save user ${user.id}: empty name")
    if (user.address.isEmpty())
        throw IllegalArgumentException("Can't save address ${user.address}: empty address")
}
 */

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty())
            println("Can't save user $id: empty $fieldName")
            // throw IllegalArgumentException("Can't save user $id: empty $fieldName")
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User){
    user.validateBeforeSave()
}

fun TalkativeButton.giveSpeech(){
    // yell() - private!
    // whisper() - protected!
}

fun getSum(res: ResultSum): Double = when(res){
    is ResultSum.Num -> res.value
    is ResultSum.Sum -> getSum(res.left) + getSum(res.right)
}

fun findTheOldest(students: List<StudentAge>): StudentAge? {
    var maxAge = 0
    var theOldest: StudentAge? = null

    for (s in students)
        if (s.age > maxAge){
            maxAge = s.age
            theOldest = s
        }

    return theOldest
}

fun printMessageWithPrefix(message: Collection<String>, prefix: String){
    message.forEach{
        println("$prefix $it")
    }
}

fun printProblemCounts(response: Collection<String>){
    var clientsErrors = 0
    var serverErrors = 0

    response.forEach{
        if (it.startsWith("4"))
            clientsErrors++
        else if (it.startsWith("5"))
            serverErrors++
    }

    println("$clientsErrors client errors, $serverErrors server errors")
}

fun salute(): String = "Salute!"

fun File.isInsideHiddenDirectory() =
    generateSequence(this){it.parentFile}.any{it.isHidden}

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') result.append(letter)
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder){
        for (letter in 'a'..'z') this.append(letter)
        append("\nNow I know the alphabet!".toUpperCase())
        this.toString()
    }
}

fun alphabet3(): String = with(StringBuilder()){
    for (letter in 'a'..'z')
        append(letter)
    append("\nNow I know the alphabet!".toLowerCase())
    toString()
}

fun alphabet4(): String = StringBuilder().apply {
    for (letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet!")
}.toString()

fun alphabet5(): String = buildString {
    for (letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet!".toLowerCase())
}







