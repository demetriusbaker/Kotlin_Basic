import kotlin.reflect.KClass

fun main(){
    cookOld()
    someValue
    lambda("")
    value
    Class.f1()
    Class.f2()
    val someClass: KClass<Class> = Class::class
    println(someClass.isData)
}

@Deprecated("OLD", ReplaceWith("println(\"cook in old\")"))
fun cookOld(){
    println("cook in old")
}

/** Annotation */
@Suppress("useless")
val someValue = 0

@JvmField
val lambda = @Suppress("UNUSED_PARAMETER"){ _: String -> println("lambda")}

@get:[Suppress Deprecated("mess")] val value = 131

@MyAnnotation("Message")
class Class {
    companion object {
        @JvmStatic fun f1(){}
        fun f2(){}
    }
}

annotation class MyAnnotation(val message: String)