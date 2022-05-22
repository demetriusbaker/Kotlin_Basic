package mixedExamples1_5chapters.justExamples.allExamplesForMarch

import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.util.*
import mixedExamples1_5chapters.justExamples.allExamplesForMarch.getSum as getSum

fun main(){
    println("$$$$$$$$$$ 01.03.2021 57-73 $$$$$$$$$$")

    println("Value of eval (2 + (5 + 3)): ${eval(Sum(Num(2), Sum(Num(5), Num(3))))}")
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

    println("Cycle")
    println("Play: fizzBuzz")
    val oneToHundred = 1..100 // IntRange
    for (i in oneToHundred)
        println(fizzBuzz(i))

    println("From 100 to 10 by -8")
    for (i in 100 downTo 10 step 8)
        println(i)

    println("binary Map")
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps)
        println("$letter = $binary")

    println("in")
    println(isLetter('q'))
    println(isLetter('#'))
    println(isNotDigit('x'))
    println(isNotDigit('0'))
    println("8 - ${recognize('8')}")
    println("a - ${recognize('a')}")
    println("O - ${recognize('O')}")
    println("@ - ${recognize('@')}")

    println("Exception")
    println(readNumber(BufferedReader(StringReader("1234567890"))))
    println(readNumber(BufferedReader(StringReader("A!"))))

    println("Collections")
    val list = arrayListOf(1, 23, 543.897, 634, true, '@', "Dima is very strong!!!", listOf("beer", true, "love"))
    println(list.javaClass)
    println(list)
    println("First element of list: ${list.first()}")
    println("Last element of list: ${list.last()}")

    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")
    println(map.javaClass)
    println(map)

    val numbers = setOf(1,234,234,55,23638,47,652,72364,8,733,68,84,67,47)
    println(numbers.javaClass)
    println(numbers)
    println(numbers.sum())

    println("$$$$$$$$$$ 02.03.2021 73-93 $$$$$$$$$$")

    val listNumbers = listOf("beer", "water", "juice", "milk", "tea", "cola")
    println(joinToString(listNumbers, "|", "$$$|", "|###"))
    println(joinToString(listNumbers, prefix = "[", separator = "|", postfix = "]"))
    println(joinToString(listNumbers))
    println(joinToString(listNumbers, prefix = "^_^"))
    println(joinToString(listNumbers, postfix = "$$$"))
    println(joinToString(listNumbers, "#"))

    println("[qwertyuiopasdfghjkl;'zxcvbnm,./]".getFirstAndLastChar())

    println(listNumbers.joinToString())
    println(listNumbers.joinToString("?", "-8- ", " -8-"))

    val listSTR = listOf("qwerw", "fgdsh", "ygsghs")
    println(listSTR.join(" "))

    println(View().click())
    println(View().showOff())
    println(Button().click())
    println(Button().showOff())

    val view: View = Button()
    println(view.showOff()) // "I'm a view!"

    println(Class.method())
    println(Class.method())
    println(Class.method2())

    println("0123456789@".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    println(getSum())
    println(getSum(1))
    println(getSum(1,2))
    println(getSum(1,2,3,4))
    println(getSum(1,2,3,4,5,6,7,8,9, getSum(8,6)))
    println(getSum(getSum(1,2,3), getSum(4, 10)))

    val arrPacket = arrayOf("ads", "fad", "rwe", "qaz", "vdr")
    val listPacket = listOf(*arrPacket)
    println(listPacket)

    println(mapOf(1 to "one", 7 to "seven", 53 to "fifty-three"))
    // 1.to("FIRST") == 1 to "FIRST"
    println(1 to "FIRST")
    println("89 + 11 = ${89 plus 11}")
    println("18 - 14 = ${18 minus 14}")
    println("4 * 20 = ${4 multiply 20}")
    println("36 / 12 = ${36 divide 12}")

    val (key, value) = "12x32erw" to 126
    println("Key: $key; Value: $value")

    println("12.345-6.A".split("[.\\-]".toRegex()).joinToString(" | ", "", ""))
    println("12.345-6.A".split(".", "-"))

    println(parsePath("/Users/folder/kotlin-book/chapter.doc"))

    val kotlinLogo = """| //
                       .|//
                       .|/ \
                       .| \ \
                       .|  \ \"""
    println(kotlinLogo.trimMargin("."))

    println("$$$$$$$$$$ 03.03.2021 93-107 $$$$$$$$$$")

    println("""99.99${'$'}""")

    // println(safeUser(User(0,"","")))
    saveUser(User(43236, "Dima", "Penthouse"))
    saveUser(User(0, "", ""))
    saveUser(User(0, "0", ""))
    saveUser(User(0, "", "0"))

    val clickButton = ClickButton()
    println(clickButton.click())
    println(clickButton.setFocus(true))
    println(clickButton.setFocus(false))
    println(clickButton.showOff(1))
    println(clickButton.showOff(243))

    println("$$$$$$$$$$ 05.03.2021 107-118 $$$$$$$$$$")

    val javaButton = mixedExamples1_5chapters.justExamples.javaClassExamples.Button()
    println(javaButton.ButtonState())

    println(Person("Bob", false).isSubscribed)
    println(Person("Alice").isSubscribed)
    println(Person("Carol", true).isSubscribed)

    println(PrivateUserProgrammer("test@kotlinlang.org").nickname)
    println(SubscribingUserProgrammer("test@kotlinlang.org").nickname)

    println("$$$$$$$$$$ 15.03.2021 118-130 $$$$$$$$$$")

    val up = UserProger("Dima")
    println(up.getInfo())
    up.address = "Yakuba Kolasa 28"
    println(up.getInfo())

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hello!")
    println(lengthCounter.counter)

    val client = Client("Alesya", 6912386)
    val client2 = Client("Alesya", 6912386)
    println(client)
    println(client == client2)

    val processed = hashSetOf(Client("Darya", 678342))
    println(processed.contains(Client("Darya", 678342)))

    val dataClient = DataClient("Darya", 678342)
    val dataClient2 = DataClient("Darya", 678342)
    val processed2 = hashSetOf(dataClient)
    println(dataClient)
    println(dataClient == dataClient2)
    println(processed2.contains(DataClient("Darya", 678342)))

    val client3 = Client("Stepa", 14325)
    val clientCopy = client3.copy()
    println("Copy client: $clientCopy")

    val cset = CountingSet<Int>()
    cset.addAll(listOf(0,1,2,3))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
    cset.add(4)
    cset.add(5)
    cset.add(6)
    cset.add(7)
    cset.add(8)
    cset.add(9)
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    println("$$$$$$$$$$ 16.03.2021 130-142 $$$$$$$$$$")

    val humans = listOf(Human("Dima"), Human("Vanya"), Human("Danik"), Human("Andrey"))
    println(humans.sortedWith(Human.NameComparator))

    println(A.bar())

    val subscriberUser = UserExample.newSubscribingUser("dimon081101@mail.com")
    val vkontakteUser = UserExample.newVkontakteUser(102128979)
    println("Subscriber: $subscriberUser, vkontakter: $vkontakteUser")

    println(Man.Loader.fromJSON("Demitrland"))

    val studentsAge = listOf(
        StudentAge("Vasya", 18),
        StudentAge("Misha", 13),
        StudentAge("Dima", 12),
        StudentAge("Petya", 26),
        StudentAge("Kirill", 23)
    )
    println(studentsAge)
    println("The oldest student: ${findTheOldest(studentsAge)}")
    println("The oldest student: ${studentsAge.maxByOrNull { it.age }}")
    println("The oldest student: ${studentsAge.maxByOrNull(StudentAge::age)}")

    println("$$$$$$$$$$ 17.03.2021 142-151 $$$$$$$$$$")

    val sum = {x: Int, y: Int -> x + y}
    println(sum)
    println(sum(1,2))
    val increaseTo = {x: Double, i: Double -> x * i}
    println(increaseTo)
    println(increaseTo(2.5, 5.1))

    println("First student on list: ${studentsAge.minByOrNull { it.name }}")
    println("Last student on list: ${studentsAge.maxByOrNull { it.name }}")

    val names = studentsAge.joinToString(" ", transform = {s: StudentAge -> s.name})
    println(names)
    val names2 = studentsAge.joinToString(" "){s -> s.name}
    println(names2)

    val getAge = {p: StudentAge -> p.age}
    println(getAge)

    val sumAndResidual = {a: Int, b: Int ->
        val sum = a + b
        val residual = a - b
        sum - residual
    }
    println(sumAndResidual(125,25))

    printMessageWithPrefix(listOf("Water", "Bananas", "Protein"), "Product:")

    printProblemCounts(listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error"))

    println(run(::salute))

    val action = {x: Int ->
        fizzBuzz(x)
    }
    val nextAction = ::fizzBuzz
    println("Action(3): ${action(3)} and next action(5): ${nextAction(5)}")

    val volume = ::Volume
    println(volume(123.4, 23.6))

    val v = Volume(20.0, 5.0)
    val getVolume = Volume::height
    println(getVolume(v))

    val balloon = v::height
    println(balloon())

    println("$$$$$$$$$$ 29.03.2021 151-157 $$$$$$$$$$")

    println(listOf(1,2,3,4,5,6,7,8,9).filter { it % 3 == 0 })

    var studentList = listOf(StudentAge("Danik", 34), StudentAge("Dima", 26))
    println(studentList.filter { it.age > 30 })
    println(studentList.filter { it.name == "Danik" })

    var justArray = intArrayOf(14, 10, 29, 3, 20, 21)
    println(justArray.map {it * it}) // println(List<Int>)

    var studentsArray = arrayOf<Student>(
        Student("Dima", 3),
        Student("Dima", 4),
        Student("Misha", 3),
        Student("Arseniy", 4),
        Student("Maxim", 2),
        Student("Zhenya", 2)
    )
    println(studentsArray.map { it.name }) // println(List<String>)
    println(studentsArray.filter { it.course == studentsArray.maxByOrNull(Student::course)?.course })

    val maxAge = studentsAge.maxByOrNull(StudentAge::age)?.age
    println(studentsAge.filter { it.age == maxAge })

    var numbersMap = mapOf(0 to "zero", 1 to "one")
    numbersMap = numbersMap.mapValues { it.value.toUpperCase() }
    println(numbersMap)

    val canBeInCourse3Club = { s: Student -> s.course == 3}
    println(studentsArray.all(canBeInCourse3Club))
    println(studentsArray.any(canBeInCourse3Club))
    // !any == all and any == !all
    println(!studentsArray.all(canBeInCourse3Club) == studentsArray.any(canBeInCourse3Club))
    println(studentsArray.all(canBeInCourse3Club) == !studentsArray.any(canBeInCourse3Club))

    println(studentsArray.count(canBeInCourse3Club))
    println(studentsArray.find(canBeInCourse3Club))

    println(studentsArray.groupBy {it.course})
    println(studentsArray.groupBy {it.name})

    println(listOf("abc", "def", "g", "hi").flatMap { it.toList() })
    val books = listOf(Book("Thursday Next", listOf("Dasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett",
            "Neil Gaiman")))
    println(books.flatMap { it.authors })
    println(books.flatMap { it.authors }.toSet())
    // Set don't give duplicate!!!

    println("$$$$$$$$$$ 30.03.2021 157- $$$$$$$$$$")

    println(studentsArray.asSequence().map(Student::name).filter
    { it.startsWith("M") }.toList())

    println("---")
    var a = listOf(1,2,3,4).asSequence().map { println("map($it)"); it * it}.filter{
        println("filter($it)"); it % 2 == 0
    }
    println(a.toList())
    println("---")
    var b = listOf(1,2,3,4).asSequence().map { println("map($it)"); it * it}.filter{
        println("filter($it)"); it % 2 == 0
    }.toList()
    println(b)
    println("---")

    println(listOf(0,1,2,3,4).map { it * it }.find { it > 3 }) // 4
    println(listOf(0,1,2,3,4).asSequence().map { it * it }.find { it > 3 }) // 4

    val people = listOf(Student("Andrey", 2), Student("Kirill", 1),
    Student("Dima", 4), Student("Egor", 3)
    )
    println(people.asSequence().map(Student::name).filter { it.length < 5 }.toList())
    println(people.asSequence().filter {it.name.length < 5}.map(Student::name).toList())

    val naturalNumbers = generateSequence(1) {it + 1}
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.toList())
    println(numbersTo100.sum())

    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())

    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
    println(alphabet5())
}