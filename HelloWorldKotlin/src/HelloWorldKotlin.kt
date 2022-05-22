fun main(args: Array<String>){
    println("Hello world Kotlin!")
    println("2 + 2 = " + (2 + 2))
    var valueB = false
    valueB = true
    println(valueB)
    sayHello()
    val obj: Class = Class()
    println(obj.getSum(7,3))
}

fun sayHello(){
    println("Hello my world!")
}