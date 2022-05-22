package lesson12

open class Person(val name: String) {
    open val age: Int = 0

    override fun toString(): String {
        return "Name: $name"
    }

    open fun getAddress() : String {
        return "Test address"
    }
}