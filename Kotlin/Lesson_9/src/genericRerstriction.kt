interface IGeneric<A>{
    fun deleteObj(): A?
}

class Generic<T>(var obj: T?): IGeneric<T>{
    override fun deleteObj(): T? {
        val temp = obj
        obj = null
        return temp
    }

    @JvmName("getObj1")
    fun getObj(): T? = obj
}

fun <T> runFun(func: () -> T): T = func()

class Generic2<T: Any>{
    fun someFunc(value: T): T = value!!
}

fun <T> compare(value: T){
    println(value is List<*>)
}

inline fun <reified T> compare2(value: Any){
    println(value is T)
}

inline fun <reified T> filter(list: List<Any?>){
    list.forEach { if (it is T) println(it) }
}