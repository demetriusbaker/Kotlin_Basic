package lesson9

class Lesson9 {
    fun function(){
        var a = 2
        var b = 5

        when {
            (a > b) -> println("$a > $b is true")
            (a < b || a == b) -> println("$a > $b is false")
        }
    }
}