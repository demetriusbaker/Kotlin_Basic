import lesson1.Lesson1
import lesson2.*
import lesson3.Lesson3
import lesson4.Lesson4
import Lesson5.Lesson5
import lesson6.Lesson6
import lesson7.animals.cat.*
import lesson7.animals.dog.DogA
import lesson7.animals.printInfo
import lesson8.Lesson8
import lesson9.Lesson9
import lesson10.*
import lesson11.*
import lesson12.*
import lesson13.*
import lesson15.isChar
import lesson16.*
import lesson17.*

fun main(args: Array<String>) {
    println("Hello world!")
    println("Enter lesson (1 - 17), 0 - exit")

    var isExit: Boolean = false
    while(!isExit){
        var key : Int = Enter.getNumber()
        when (key){
            0 -> isExit = true
            1 -> {
                println("$key)\n")

                var l : Lesson1 = Lesson1();
                l.function()
                println()
            }
            2 -> {
                println("$key)\n")

                val userJava = UserJava("tcodmos@gmail.com")
                println("Java example: ${userJava.eMail}")

                val userKotlin = Lesson2("tcodmos@gmail.com")
                println("Kotlin example: ${userKotlin.email}")
                userKotlin.function()
            }
            3 -> {
                println("$key)\n")

                var l = Lesson3()
                l.function()
            }
            4 -> {
                println("$key)\n")

                var l = Lesson4()
                println(l.myFirstFunction())
                println(l.myFirstFunction(100.0))
                println(l.sum(2 * 3,3 + 1))
            }
            5 -> {
                println("$key)\n")

                var l = Lesson5()

                val str = "Programming"
                println("$str - " + str.length)

                var st: String? = l.getSt()
                println(st)
                // println(st!!.length)
                // NullPointerException

                st = l.getSt("Kotlin")
                println(st)
                println(st!!.length)
            }
            6 -> {
                println("$key)\n")

                val l = Lesson6("Dima", 19, true)
                println(l)
                println(l.name)
                println(l.age)
                println(l.isMan)

                println(Lesson6.Car(5.243f, 3).isNew)
            }
            7 -> {
                println("$key)\n")

                val catA = CatA()
                catA.a1()
                catA.a2()

                val catB = CatB()
                catB.b1()
                catB.b2()

                val dogA = DogA()
                dogA.a1()
                dogA.a2()

                printInfo()
            }
            8 -> {
                println("$key)\n")

                println(Lesson8.BLACK)
                println(Lesson8.BLACK.name)

                println(Lesson8.RED.colorHex)
                println(Lesson8.RED.opacity)

                println(Lesson8.WHITE.colorHex)
                println(Lesson8.WHITE.opacity)
            }
            9 -> {
                println("$key)\n")

                var n = 2
                when (n) {
                    1 -> println(n)
                    2 -> println("$n - two")
                    3 -> println("$n - three")
                }

                n = 0
                var res = when (n) {
                    1 -> "one"
                    2 -> "two"
                    3 -> "three"
                    else -> "not [1,3]!"
                }

                println(res)

                var color: Lesson8 = Lesson8.RED
                var result = when (color){
                    Lesson8.BLACK -> "черный"
                    Lesson8.WHITE -> "белый"
                    else -> "Мир не черно-белый!"
                }

                println(result)

                val l = Lesson9()
                l.function()
            }
            10 -> {
                println("$key)\n")

                var v1: KotlinInterface = A()
                var v2: KotlinInterface = B()

                v1.function()
                v1.defaultFunction()
                v2.function()
                v2.defaultFunction()
            }
            11 -> {
                println("$key)\n")

                var v1: AbstractClass = ConcreteClass()
                v1.a()
                v1.realiseFunction()
                v1.a()
            }
            12 -> {
                println("$key)\n")

                var p1 = Person("Dima")
                val p2 = Driver("Dima Gonshchik nelegalny")
                println(p1)
                println(p1.getAddress())
                println(p2)
                println(p2.getAddress())
            }
            13 -> {
                println("$key)\n")

                val mouse = Mouse()
                // obj.field - it's private field!
                mouse.method()

                val superMouse = SuperMouse()
                superMouse.method()
                superMouse.inherit()
            }
            14 -> {
                println("$key)\n")

                var index: Int = 0
                while (index < 10){
                    println("Index: ${index++}")
                }

                var contain = 1..10
                for (c in contain)
                    print("$c ")
                println()
                for (c in contain step 2)
                    print("$c ")
                println()
                for (c in 10 downTo 1)
                    print("$c ")
                println()
                for (c in 10 downTo 1 step 2)
                    print("$c ")
                println()
            }
            15 -> {
                println("$key)\n")

                var nums = 1..19

                val value = 6
                for (num in nums)
                    if (num == value){
                        println(true)
                        break
                    }

                println(value in nums) // true

                val chars = 'a'..'z'
                println(isChar('w', chars))
                println(isChar('9', chars))
            }
            16 -> {
                println("$key)\n")

                println(JavaClass())
                println(Pivass())
                println(DataClass("It's data!", 25))

                var dc1 = DataClass("Info", 21)

                var dc2 = dc1
                dc2.data = "Message!"
                println(dc2)

                var dc3 = dc1.copy()
                dc3.data = "MessaGE"
                println(dc3)

                var (data, number) = DataClass("ghfwrrbfd", 10)
                println("Data: $data and number: $number")
            }
            17 -> {
                println("$key)\n")

                val e1 = Expr.Const(1.235)
                val e2 = Expr.Const(3.142)

                val sum = Expr.Sum(e1, e2)
                println(eval(sum))
            }
            else -> println("Incorrect input!")
        }
    }
}