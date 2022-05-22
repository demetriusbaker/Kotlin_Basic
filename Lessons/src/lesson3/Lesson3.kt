package lesson3

class Lesson3 {
    fun function(){
        var a1: String = "REF"
        var value: Int = 123 // 32 bit
        var long: Long = 1234567890 // 64 bit
        var a: Short = 3 // 16 bit
        var b: Byte = 1 // 8 bit
        var numd: Double = 4.14e3 // 64 bit
        var numf: Float = .435f // 32 bit

        var b1: Long = value.toLong()

        var c1: Char = '$'
        var logic: Boolean = true

        println(a1)
        println(value)
        println(long)
        println(a)
        println(b)
        println(numd)
        println(numf)
        println(b1)
        println(c1)
        println(logic)
    }
}