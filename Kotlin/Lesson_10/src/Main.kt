import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException
import kotlin.reflect.jvm.internal.impl.util.CheckResult
import kotlin.system.exitProcess

fun main(){
    println(toInt("21343"))
    println(toInt("21@"))

//    fail("Function fail()!")
    try {
        println("try 1")
        fail()
        throw NullPointerException()
        println("try 2")
    } catch (e: java.lang.IllegalStateException){
        println("NullBeerException = $e")
    } catch (e: Throwable){
        println("Exception = $e")
    } finally {
        println("Okay!")
    }

    // от частного к общему!

    throwEx(null)

    println(getDiv(6,2))
    println(getDiv(656,0))

    System.err.println("ERROR!")

    a()
}

fun toInt(str: String): Int?{
    return try {
        str.toInt()
    } catch (e: NumberFormatException){
        println("Error: incorrect string format!")
        null
    }
}

fun fail(mess: String = ""): Nothing{
    throw IllegalStateException(mess)
}

fun throwEx(e: NullPointerException?){
    try {
//        exitProcess(666)
//        return
        throw e!!
    } catch (ex: NullPointerException){
        try {
            throwEx(ex)
        } catch (e: StackOverflowError){
            println("STACK IS OVER!!")
        }
    } finally {
        println("throwEx end!")
    }
}

fun getDiv(a: Int, b: Int): Int = try {
    a / b
} catch (e: ArithmeticException){
    println("Ebombo, a?")
    a
}

fun a(){
    println("--a in")
    b()
    println("--a out")
}

fun b(){
    println("----b in")
    try {
        c()
    } catch (e: Exception){
        println("exception")
    }
    println("----b out")
}

fun c(){
    println("------c in")
    d()
    println("------c out")
}

fun d(){
    println("--------d in")
    println("--------d out")
}