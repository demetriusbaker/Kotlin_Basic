package lesson6

class Lesson6(var name: String, var age: Int, var isMan: Boolean) {
    class Car (private var weight: Float, private var size: Int) {
        var isNew: Boolean = true
        // переопределение метода гет
            get() {
                return weight > size
            }
            set(value) {
                if (value)
                    println("Yes")
                field = value
            }
    }
}

// Заметка 1: заметил такую особенность: когда я пытаюсь название класса сделать
// отличным от названия класса-файла, он превращается просто в файл,
// где обычно прописывается fun main(){}
// такая же ситуация, когда здесь создаю еще один класс

/*
   Заметка 2: когда я в скобках не указываю ключевое слово var,
   я не могу вывести поле этого класса в консоли
 */

