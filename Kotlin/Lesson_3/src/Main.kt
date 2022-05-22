fun main(args: Array<String>){
    if (2 > 1){
        println("2 > 1")
    }

    if (3 > 4)
        println("3 > 4")

    if ("f" < "z")
        println("f > z")

    println(if (25 > 100) "25 > 100" else "25 < 100")

    var s = "fsdgsd"
    var s1 = ""

    println(!s.isEmpty()) // true
    println(!s1.isEmpty()) // false
    println('d'.toInt()) // 100

    var str1 = "ttt"
    var str2 = "ttt"
    var strO1 = String().plus("ttt")
    var strO2 = String().plus("ttt")
    var strO3 = strO1

    println(str1 === str2) // true
    println(strO1 === strO2) // false

    when (2) { // switch - case
        0 -> println("zero")
        1 -> println("one")
        2 -> println("two")
        3 -> println("three")
        121 -> {
            println("One hundred")
            println("twenty")
            println("one")
        }
        else -> println("other number")
    }

    var obj = String().plus("12345675")

    // setOf - класс-коллекция, хранящая уникальные элементы

    val setOfClass = setOf(strO1, strO2, obj) // ttt, ttt, 12345675
    println(setOfClass) // ttt, 12345675


    var o1 = String().plus("qwerty")
    var o2 = String().plus("qwerty")

    when (setOf(o1, o2)){
        setOf(o1, o2) -> println("The same o!")
    }

    when (5) {
        in 1..4 -> println("1-4")
        in 5..9 -> println("5-9")
    }

    var count = 0
    while (count < 10)
        println("while: ${count++}")

    var count2 = 0
    do {
        println("do while: ${count2++}")
    } while (count2 < 10)

    var numbers = arrayListOf(543,654,126,857,124,987,908,342)
    for (n in numbers)
        println("foreach: $n")

    /*
    var massive = arrayOf(1,3,5,7,43,2,34,9)
    while(massive.iterator().hasNext())
        println("while with iterator: ${massive.iterator().next()}")

     */
    for (i in 1..5)
        println("for: $i")

    val range = 1..10
    val two = 2
    for (i in range step two)
        println("for with step: $i")

    val reverseRange = 10 downTo 1
    for (i in reverseRange)
        println("Reverse output: $i")

    for (s in 'a'..'z')
        println("Symbol: $s")

    for (s in 'z'..'a')
        println("Symbol: $s") // print nothing!

    for (s in 'а'..'я')
        println("Symbol: $s")

    println('d' in 'a'..'z') // true

    repeat(3){
        println("repeat")
    }

    var array = arrayOf("beer", "milk", "eggs", "fish", "bananas", "carrot", "wine", "water")
    for ((index, value) in array.withIndex())
        println("array[$index] = $value")

    array.forEach {
        println("forEach: $it")
    }

    array.forEachIndexed {i, v ->
        println("forEachIndexed: $i = $v")
    }

    array.reversed().forEach{
        println("Reversed forEach: $it")
    }

    println("1 to 50")
    for (i in 1..100){
        if (i > 50)
            break
        else
            println(i)
    }

    println("Even numbers")
    for (i in 1..100)
        if (i % 2 != 0)
            continue
        else
            println(i)

    for (i in 1..10){
        for (j in 1..10)
            print("$j ")
        println()
    }

    do {
        println("Enter pin: ")
        var (pin) = readLine()!!.split(' ')
    } while (pin.toLong() != 88005553535)
    println("Yes!")
}