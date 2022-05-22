import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader

class MetrologyResult(val name: String, val result: Int?){
    override fun toString(): String = "$name - $result"

    companion object {
        fun printArray(array: Array<Pair<Int, MetrologyResult>>){
            for (i in array.indices)
                println("${array[i].first} ${array[i].second}")
        }
    }
}

fun main(){
    val file = File("MyClassMates")
    val fileReader = FileReader(file)
    val bufferReader = BufferedReader(fileReader)

    val fis = FileInputStream(file)
    val byteArray = ByteArray(file.length().toInt())
    fis.read(byteArray)
    val data = String(byteArray)
    val stringArray = data.split("\r\n")

    val size = stringArray.size

    var line = bufferReader.readLine()

    val array = Array(size){it to MetrologyResult("", null)}
    var i = 0
    while (line != null){
        val split = line.split(" ")
        val name = split[0]
        val result = split[1].toIntOrNull()
        array[i] = i + 1 to MetrologyResult(name, result)

        i++
        line = bufferReader.readLine()
    }

    println("Full list:")
    MetrologyResult.printArray(array)

    println("----------------------------")

    println("Not pass task:")
    val passTask = array.filter { it.second.result == null || it.second.result!! < 4 }.toTypedArray()
    MetrologyResult.printArray(passTask)

    println("----------------------------")

    println("Most success:")
    val mostSuccess = array.sortedBy { it.second.result }.reversed().toTypedArray()
    MetrologyResult.printArray(mostSuccess)
}