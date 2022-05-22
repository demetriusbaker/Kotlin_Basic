package lesson11

open abstract class AbstractClass {
    var count = 0

    fun a(){
        println("default realisation ${++count}")
    }

    abstract fun realiseFunction()
}

// open - ключ слово для возможности наследования!