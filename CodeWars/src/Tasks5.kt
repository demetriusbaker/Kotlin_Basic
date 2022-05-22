package kyu_5

object SumSquaredDivisors {
    fun listSquared(m: Long, n: Long): String {
        val result = mutableListOf<String>()
        for (i in m..n){
            val square = findAllDivisorsInSquare(i).sum()
            if ((kotlin.math.sqrt(square.toDouble()) * 10 % 10) == 0.0)
                result.add("[$i, ${square}]")
        }
        return result.joinToString( prefix = "[", postfix = "]")
    }

    private fun findAllDivisorsInSquare(n: Long): Set<Long> {
        val set: MutableSet<Long> = mutableSetOf(1, n * n)
        for (i in 2 until kotlin.math.sqrt(n.toDouble()).toLong() + 1)
            if (n % i == 0L){
                set.add(i * i)
                val buf = (n.toDouble() / i).toLong()
                set.add(buf * buf)
            }
        return set
    }
}

//fun longToIP(ip: UInt): String {
////    val binary: String = String.format("%32s",
////        java.lang.Long.toBinaryString(ip.toLong())).replace(' ', '0')
////    return "${binary.substring(0, 8).toLong(2)}.${binary.substring(8, 16).toLong(2)}." +
////            "${binary.substring(16, 24).toLong(2)}.${binary.substring(24).toLong(2)}"
////}

fun longToIP(ip: UInt): String =
    (0..24 step 8).map { ip shr it and 255u }.reversed().joinToString(".")

object RemovedNumbers {
    fun removNb(n: Long): Array<LongArray>  {
        val sum = n * (n + 1) / 2
        var list = ArrayList<LongArray>()

        for (a in 1..n){
            var b: Double = (sum - a).toDouble() / (a + 1)
            if (b.toLong().toDouble() == b && n >= b.toLong())
                list.add(longArrayOf(a,b.toLong()))
        }

        return list.toTypedArray()
    }
}