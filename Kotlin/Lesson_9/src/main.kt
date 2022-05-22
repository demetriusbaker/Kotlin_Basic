fun main(){
    val objI = Generic(12)
    val int = runFun {
        objI.getObj()
    }
    println(int)

    val objStr = Generic("Hi!")
    val str = runFun {
        objStr.getObj()
    }
    println(str)

//    val obAny = Generic<String>(null)
//    obAny.obj = 125
//    obAny.obj = '@'

    println(listOf(1,2,3,5.6,3.14, 3L, 1.3f))
    println(listOf(1,2,3,5.6,3.14, 3L, 1.3f).average())

    // println(Generic2<Int?>().someFunc(null))
    println(Generic2<Int>().someFunc(125))

    val list1 = listOf<Int>()
    val list2 = listOf<String>()
    val sequence = 1..2
    compare(list1)
    compare(list2)
    compare(sequence)

    compare2<String>("")
    compare2<String>(880005553535)

    val list = listOf(1, "hello", true, '#', Generic(1), 3.14, null)
    filter<String?>(list)

    val listOf1 = mutableListOf(1, "hello", Generic(123), "32r3efdsv fd ")
    val listOf2 = mutableListOf(1,2,3)

    concatList(listOf2)
    concatListAny(listOf1)
    addListAny(listOf1)
    // addListAny(listOf2)
}