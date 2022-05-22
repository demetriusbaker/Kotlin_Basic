package lesson12

class Driver(name: String) : Person(name) {
    override fun getAddress(): String {
        return "Pushkina 82"
    }

    override val age: Int = 19

    override fun toString(): String {
        return "Name: $name; age: $age"
    }
}