package lesson13

internal class SuperMouse : Mouse(){
    public override fun inherit(){
        println("Inheritance!")
    }
/*
    Если вы переопределите protected член и явно не укажете
    его видимость, переопределённый элемент также будет
    иметь модификатор доступа protected
    Ctr + Shift + /
*/

//    Если вы используете internal, видимость будет распространяться на весь модуль
}