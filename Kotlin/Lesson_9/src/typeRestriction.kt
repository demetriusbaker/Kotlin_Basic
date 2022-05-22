fun <T: Number> List<T>.average(): Double {
    var average = 0.0
    this.forEach { average += it.toDouble() }
    return average.div(this.size)
}

fun <T> generic(value: T): T? where T: Generic<T>, T: IGeneric<T> = value.getObj()