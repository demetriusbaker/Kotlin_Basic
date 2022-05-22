fun main(args: Array<String>){
    val a : Int = 1 // final
    var b : Int = 2
    var c = 3 // same int, as b

    var nullString: String? = null
    var nullString2: String? = "fjsajfdaklj"

    var nn0 : Int? = nullString?.length
    var nn1 : Int? = nullString?.length ?: 0
    var nn2 : Int? = nullString2?.length ?: 0

    var byte: Byte = 2
    var short: Short = 56
    var int: Int = 2569
    var long: Long = 456987L
    var float: Float = 25.3f
    var double: Double = 45.689
    var char: Char = '{'
    var boolean: Boolean = true

    var sym: Char = 69.toChar()

    println("Some text i printed!")
    printNumber()
    printNumber(5)
    println(getLengthString("fsajkdlnbjkfhaklvbsjkbnfvsj"))
    println(getLastNFirst("abcde"))
    println(nn0)
    println(nn1)
    println(nn2)
    println(sym)
    println(2.plus(2))
}

fun printNumber(number : Int = 2){
    println(number)
}

fun getLengthString(message: String) = message.length

fun getLastNFirst(message: String) : String {
    return message.last().plus(message[0].toString())
}