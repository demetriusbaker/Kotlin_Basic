class Pivas {
    companion object {
        var a = 5
    }

    object beer {
        var b = 8
    }
}

fun main(){
    println(Pivas.a)
    Pivas.a = 10
    println(Pivas.a)

    println(Pivas.beer.b)
    Pivas.beer.b = 12
    println(Pivas.beer.b)

    println(Int.MAX_VALUE)

    println(Int.MAX_VALUE + 1)
    println(Int.MIN_VALUE - 1)
}
