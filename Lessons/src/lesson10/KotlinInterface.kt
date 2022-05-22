package lesson10

interface KotlinInterface {
    fun function()

    fun defaultFunction(){
        println("Default")
    }

    val prop1: Int
    get() = 10
}