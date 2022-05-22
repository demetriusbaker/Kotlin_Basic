fun main(){
    println(Outer().Inner())
    println(Outer.StaticInner())

    println(Robot().isInTheCentre)
    println(Robot())

    val robots = Array(3){ Robot() }
    println(robots.toList())

    println(robots[0] == robots[2])
    println(robots[0].hashCode() == robots[1].hashCode())
    println(robots[2].hashCode() == robots[1].hashCode())
    println(robots[2] == robots[1])

    val dataClass = DataClass("Jin", 2300)
    val dataClass2 = DataClass("Jin", 2300)

    println(dataClass)
    println(dataClass2)
    println(dataClass == dataClass2)

    println(Singleton.getSerialNumber())

    println(Singleton.hashCode() == Singleton.hashCode())
    println(Singleton == Singleton)

    println(Cat.getInstantion("Vasya", 19))
}

class SomeClass constructor(someValue: String){
    val value: String

    init {
        value = someValue
    }
}

class SomeClass2 constructor(someValue: String){
    val value: String = someValue
}

class SomeClass3(private val someValue: String)

open class Simple

abstract class AbstractSimple

abstract class Page {
    val title: String

    constructor(title: String){
        this.title = title
    }

    constructor(titleRes: Int) : this(titleRes.toString())
}

interface MyInterface {
    val abstractProperty: String

    fun function(){}

    fun functionWithDefaultRealisation() = println("Default realisation!")
}

class RealiseClass(override val abstractProperty: String) : MyInterface {
    override fun function() {
        println("Function: $abstractProperty")
    }

    override fun functionWithDefaultRealisation() {
        super.functionWithDefaultRealisation()
        println("Also realisation: $abstractProperty!")
    }
}

class Outer{
    inner class Inner
    class StaticInner
}

enum class Coffee {
    AMERICANO, CAPPUCCINO
}

enum class MicrowaveMode {
    UNFREEZE, WARM_UP
}

sealed class Machine {
    class CoffeeMachine(private val type: Coffee) : Machine() {
        fun makeCoffee(): Boolean =
            when (type){
                Coffee.AMERICANO -> {
                    println(Coffee.AMERICANO)
                    true
                }
                Coffee.CAPPUCCINO -> {
                    println(Coffee.CAPPUCCINO)
                    true
                }
            }
    }

    class Microwave(private val mode: MicrowaveMode) : Machine() {
        fun microwave(): Boolean =
            when (mode){
                MicrowaveMode.UNFREEZE -> {
                    println("unfreezed")
                    true
                }
                MicrowaveMode.WARM_UP -> {
                    println("warmed up")
                    true
                }
            }
    }
}

fun doAction(machine: Machine): Boolean = when (machine){
    is Machine.CoffeeMachine -> {machine.makeCoffee(); true}
    is Machine.Microwave -> {machine.microwave(); true}
    else -> false
}

class Robot {
    var x: Int = 0
        set(value) {
            when {
                value > field -> println("moved to the right")
                value < field -> println("moved to the left")
                else -> println("stayed in his place")
            }
            field = value
        }

    var y: Int = 0
        set(value) {
            when {
                value > field -> println("moved to the top")
                value < field -> println("moved to the bottom")
                else -> println("stayed in his place")
            }
            field = value
        }

    var isInTheCentre: Boolean = true
        get() = x == 0 && y == 0
        private set

    override fun hashCode(): Int = (x.hashCode() / 2) + (y.hashCode() / 2)

    override fun equals(other: Any?): Boolean = other is Robot &&
            x == other.x && y == other.y

    override fun toString(): String = "($x,$y)"
}

data class DataClass(val name: String, val id: Int)

object Singleton {
    private const val serialNumber: Int = 1234253

    fun getSerialNumber(): String = "Serial number: $serialNumber"
}

class Cat {
    val name: String
    val age: Int

    private constructor(name: String, age: Int){
        this.name = name
        this.age = age
    }

    override fun toString(): String = "Name: $name and Age: $age"

    companion object {
        fun getInstantion(name: String, age: Int): Cat = Cat(name, age)
    }
}