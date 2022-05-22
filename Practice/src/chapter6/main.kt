package chapter6

fun main(){
    println("Система типов Kotlin - 6 глава")
    println("------------------------------")

    println(strLen("qwerty12"))
    println(strLen(null))

    println(strLenSafe("qwerty12"))
    println(strLenSafe(null))

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    var person = Person("Dima", null)
    println(person.countryName())

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("DetBrains", address)
    person = Person("Dmitry", jetbrains)
    printShippingLabel(person)
    // printShippingLabel(Person("Novak", null))

    val p1 = Persona("Dmitriy", "Jemerov")
    val p2 = Persona("Dmitriy", "Jemerov")
    println(p1 == p2)
    println(p1.equals(Pair(25, "beer is tasty!")))

    println(ignoreNulls("312425564"))
    // println(ignoreNulls(null))

    // 186

    println("------------------------------")
}