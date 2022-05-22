package lesson8

enum class Lesson8(var colorHex: String, var opacity: Double? = 1.0) {
    WHITE("#FFFFFF"),
    BLACK("#000000"),
    RED("#22r3333", 0.5),
    GREEN("#qweqwee");

    fun some(){
        print("Do with enum")
    }

    /*
    Замечание: когда инам класс кончается перечислением,
    точку с запятой не обязательно ставить!
     */
}