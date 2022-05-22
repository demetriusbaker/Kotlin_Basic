import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main(args: Array<String>){ // функция верхнего порядка
    println(getIncrementNumber())
    println(getIncrementNumber(5))

    println("------------------------")
    println("Open class:")
    val openPerson = OpenPerson("Vasya", 16)
    println(openPerson)
    println(openPerson.name)
    println(openPerson.age)
    openPerson.name = "Vasiliy"
    openPerson.age = 66
    println(openPerson)
    println()

    println("Class:")
    val person = Person("Dima", 19)
    println(person)
    println(person.age)
    println(person.name)
    // person.age = 2
    println()

    println("Close class:")
    val closePerson = ClosePerson("Petya", 23)
    println(closePerson)
    // println(closePerson.name)
    // println(closePerson.age)
    println()

    println("------------------------")

    println(Beer("Zhigulevskoe", 0.5))

    println(max(5.4,3.3))
    println(max(2.3,9.1))

    var i = 2.56e6
    println("i: $i")

    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    println(languages)

    val name = if (args.isNotEmpty()) args[0] else "Kotlin!"
    println(name)

    println("------------------------")

    var rectangle = Rectangle(20,25)
    println(rectangle.height)
    println(rectangle.width)
    println(rectangle.isSquare)
    rectangle = createRandomRectangle()
    println(rectangle.height)
    println(rectangle.width)
    println(rectangle.isSquare)

    println("------------------------")

    println(Color.ORANGE)
    println(Color.ORANGE.gerRGB())

    println(Color.VIOLET)
    println(Color.VIOLET.gerRGB())

    println(getMnemonic(Color.BLUE))

    println(getWarmth(Color.ORANGE))
    println(getWarmth(Color.GREEN))
    println(getWarmth(Color.VIOLET))

    println(getMixColors(Color.RED, Color.YELLOW))
    println(getMixColors(Color.VIOLET, Color.INDIGO))
    println(mixOptimized(Color.RED, Color.YELLOW))
    println(mixOptimized(Color.VIOLET, Color.INDIGO))
}