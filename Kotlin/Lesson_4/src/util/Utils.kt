package util

fun Int.isEvenNumber() : Boolean = this.div(2).times(2) == this

infix fun Int.multiple(i: Int) = this * i

infix fun Int.div(i: Int): Int = if (i > 0) this / i else 0

fun isEvenNumberJava(i: Int): Boolean = i.div(2).times(2) == i