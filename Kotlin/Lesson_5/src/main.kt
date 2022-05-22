fun main(){
    val arr = arrayOf(1,2,3,4)
    val arr2 = listOf(1,2,3,4).toIntArray()
    val arr3 = arrayOfNulls<String>(5)
    var i = 0
    val arr4: Array<Int> = Array(4){i}
    arr4.forEach {
        println(it)
    }

    val intArr = intArrayOf(2,4,8,10)
    val charArr = charArrayOf('b', 's', 'u', 'i', 'r')
    val boolArr = booleanArrayOf(true, false, true, false, true)

    val mutableArray: Array<Int?>? = arrayOf(1, 5, null, 9)
    mutableArray?.forEach { println(it?.times(2)) }

    mutableArray?.filterNotNull()?.forEach {
        println(it)
    }

    val mutableCollection: MutableCollection<String> = arrayListOf("")
    val collection: Collection<String> = mutableCollection
    println("collection size: ${collection.size}")
    mutableCollection.add("quantum")
    println("collection size: ${collection.size}")
    // две ссылки ссылаются на один и тот же объект!

    val immutableCollection: Collection<String> = arrayListOf("")
    // val immutableCollectionPlatform: Collection<String> = JavaClass.getCollection(immutableCollection).add(null)
    val immutableCollectionPlatform = JavaClass.getCollection(immutableCollection).add(null)
    // данная коллекция стала изменяемой с поддержкой null!

    val set = setOf("qwe", "rty", "uio", "p[]")
    println("${set.javaClass} size = ${set.size} $set")
    val set2 = hashSetOf("qwe", "rty", "uio", "p[]")
    val set3 = sortedSetOf("qwe", "rty", "uio", "p[]")

    val list = listOf(1,2,3)
    list.toMutableList()

    val listNotNull = listOfNotNull(null, null, null, 'q', 'w', null, '1')
    println("ListNotNull: $listNotNull")

    var count = 0; while (count++ < 5) println(listNotNull.shuffled())

    val map = mapOf(1 to "first", 2 to "second", 3 to "third")
    println(map[1])
    // println(map.get(1))

    val mutableMap = mutableMapOf(25 to "cat", 64 to "beer", 143 to "sex")
    mutableMap[144] = "love"
    // mutableMap.put(144, "love")
    println(mutableMap[144])
    mutableMap[26] = "mouse"
    println(mutableMap[143])
    println(mutableMap)

    val iterator = list.iterator()
    while (iterator.hasNext())
        println(iterator.next())

    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.joinToString())
    println(numbers.joinToString(prefix = "(", postfix = ")"))
    println(numbers.joinToString(" | ", "# ", " #"))
}