fun main(args: Array<String>){
    val tim = TimeInMillis()
    var a = tim.secondsInMillis(3)
    var b = tim.minutesInMillis(2)
    var c = tim.hoursInMillis(12)
    var d = tim.daysInMillis(7)
    println("Milliseconds in:\n3 seconds - ${a}\n2 minutes - ${b}\n" +
            "12 hours - ${c}\n7 days - ${d}")
    println(tim.getInfoAboutLastOperation())

    println("===")

    cycle()

    println("===")

    val selectedNumber = "H2ello wo9r3ld".findAll {
        str ->
        var newStr = ""
        for (s in str)
            if (s.toInt() in 48..57)
                newStr += s
        newStr
    }
    println(selectedNumber)
    println("a n dro i       d  ".findAll { s -> s.replace(" ", "").capitalize() })
}

/*
Создайте класс TimeInMillis, который инкапсулирует такие данные: сколько миллисекунд в одной
секунде, в одной минуте, в одном часе, в одном дне, потом добавьте функции для конвертации этих
мер исчисления времени в миллисекунды. Все данные должны храниться в переменных типа Long, а
функции должны принимать количество секунд, минут, часов или дней в виде значения типа Int, делать
преобразование, и возвращать количество миллисекунд в значении типа Long.

Добавьте в класс TimeInMillis переменную temp, которая должна хранить значение последней операции
конвертирования
 */

class TimeInMillis {
    private val seconds: Long = 1000
    private val minutes: Long = 60000
    private val hours: Long = 3600000
    private val days: Long = 86400000

    private var temp: Long = 0

    fun secondsInMillis(value: Int) : Long{
        temp =
        return temp
    }

    fun minutesInMillis(value: Int) : Long{
        temp = value * minutes
        return temp
    }

    fun hoursInMillis(value: Int) : Long{
        temp = value * hours
        return temp
    }

    fun daysInMillis(value: Int) : Long{
        temp = value * days
        return temp
    }

    fun getInfoAboutLastOperation() : String = "Value of last operation: $temp"
}

/*
Решить задачу, используя циклы и условные конструкции: в Китае число 4 считается плохим. Компания,
расположенная в этой стране, имеет внутреннюю телефонную сеть, с 5-ти значными номерами (номер
телефона — это пятизначное число). Руководство этой компании решило убрать все номера, содержащие
число 4 (например, 64981). Посчитать сколько доступных номеров останется.

Компания стала международной, и руководство решило, что нужно так же убрать все номера,
содержащие число 13 (например, 35136). Посчитать сколько доступных номеров останется.
 */

fun cycle(){
    var countOfFour: Int = 0
    var countOfThreeten: Int = 0

    for (i in 10000..99999){
        var s: String = i.toString()
        var charArray = s.toCharArray()

        for (j in 0..4) // 4
            if (charArray[j] == '4'){
                countOfFour++
                break
            }


        for (j in 0..3) // 13
            if (charArray[j] == '1' &&
                    charArray[j + 1] == '3'){
                countOfThreeten++
                break
            }
    }

    println("Count of free number without 4: ${90000 - countOfFour}")
    println("Count of free number without 13: ${90000 - countOfThreeten}")
}

/*
Напишите к функции findAll лямбда-выражение,
с помощью которого из строки можно достать все
числовые символы. Пример: «H2ello wo9r3ld» → «293»
 */

fun String.findAll(selectedSymbols: (s: String) -> String): String = selectedSymbols(this)