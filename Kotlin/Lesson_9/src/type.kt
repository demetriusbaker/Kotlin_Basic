fun <T> concatList(list: MutableList<T>){
    println(list.joinToString())
}

fun concatListAny(list: List<Any>){
    println(list.joinToString())
}

fun addListAny(list: MutableList<Any>){
    println(list.add(0.0))
}