import util.*
import util.div as divide
import util.isEvenNumber as isEven

fun main() {
    println(4.isEven())

    println(3 multiple 4)

    println(sumInt(1,2,3))
    println(sumInt(1,2,3,4,5))
    println(sumInt())
    println(sumInt(1,2))
    println(sumInt(1,2,3,4,5,6,7,8,9))

    val (key, value) = "first" to 1
    println("$key - $value")

    val array = arrayListOf(
        Programmer("Dima", 19),
        Programmer("John", 24),
        Programmer("Bill", 31),
        Programmer("Bob", 13)
    )
    println(array.maxByOrNull { it.age })

    val lambda = {a: Int, b: Int -> a divide b}
    println(lambda)
    println(lambda(126, 14))

    val age = Programmer::age
    val programmer = ::Programmer
    println(age(programmer("Maxim", 11)))

    println(array.filter { true })
    println(array.filter { it.age < 20 })

    array.map(){it.age++}
    println(array)

    val predicate = {programmer: Programmer -> programmer.age > 19}
    println(array.find(predicate))

    println(array.all(predicate)) // false
    println(array.any(predicate)) // true
    println(!array.all(predicate) == array.any(predicate)) // true
    println(array.all(predicate) == !array.any(predicate)) // true
    // any == not all and all == not any

    println(array.count(predicate))
    array.add(Programmer("Jin", 6))
    println(array.groupBy(age))

    println(arrayListOf(
        arrayListOf("Java", "Kotlin"),
        arrayListOf("Python"),
        arrayListOf("C#", "C++"),
        arrayListOf("Swift", "Objective-C"),
        arrayListOf("Javascript", "PHP")
    ))

    println(arrayListOf(
        arrayListOf("Java", "Kotlin"),
        arrayListOf("Python"),
        arrayListOf("C#", "C++", "C"),
        arrayListOf("Swift", "Objective-C"),
        arrayListOf("Javascript", "PHP")
    ).flatten())

    val ints = getArray()
    val startTime = System.currentTimeMillis()
    val result = ints.map {it * 2}.find { it.isEven() }
    val stopTime = System.currentTimeMillis()
    println("Without sequence: work time = ${stopTime - startTime} and result = $result")

    val ints2 = getArray()
    val startTime2 = System.currentTimeMillis()
    val result2 = ints2.asReversed().map {it * 2}.find { it.isEven() }
    val stopTime2 = System.currentTimeMillis()
    println("With sequence: work time = ${stopTime2 - startTime2} and result = $result2")

    with(array){
        println(this[0])
        println(get(1))
    }

    val plus = getLambda(Operaion.PLUS)
    println(plus(1,2))

    println(doWithInt(2,3, {a, b -> a + b}))
    println(doWithInt(4,1, {a, b -> a - b}))
    println(doWithInt(9,13, {a, b -> a * b}))
    println(doWithInt(12,2, {a, b -> a - b}))
}

// Функция внутри класса приоритетнее, чем функция-расширения того же класса,
// если имена функций совпадают!
// лямбда-выражения применяются при использовании парадигм
// ООП и функционала

fun sumInt(vararg value: Int) = value.sum()

data class Programmer(val name: String, var age: Int){
    override fun toString(): String = "$name - $age"
}

fun multiArgumentFunction(vararg values: Int) {
    values.forEach { print("$it ") }
}

fun getArray(): ArrayList<Int> {
    val arr = ArrayList<Int>()
    var count = 1000000; while (count >= 0) arr.add(count--)
    return arr
}

enum class Operaion{
    PLUS, MINUS, MULTIPLY, DIVIDE
}

fun getLambda(operation: Operaion): (Int, Int) -> Int =
    when (operation){
        Operaion.PLUS -> {a: Int, b: Int -> a + b}
        Operaion.MINUS -> {a: Int, b: Int -> a - b}
        Operaion.MULTIPLY -> {a: Int, b: Int -> a * b}
        Operaion.DIVIDE -> {a: Int, b: Int -> if (b != 0) a + b else Int.MAX_VALUE}
    }

fun doWithInt(a: Int, b: Int, func: (a: Int, b: Int) -> Int): Int = func(a,b)

/* Концепции Ф.программирования:
1) Функция должна быть предсказуемой
2) Переменные вне функции и используемые ей должны быть неизменяемыми
3) Использовать композицию (фрагмент кода как аргумент функции)
 */