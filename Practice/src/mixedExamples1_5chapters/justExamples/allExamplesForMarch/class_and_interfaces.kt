package mixedExamples1_5chapters.justExamples.allExamplesForMarch

import mixedExamples1_5chapters.justExamples.javaClassExamples.*
import java.io.File
import java.io.Serializable
import javax.naming.Context
import javax.print.attribute.AttributeSet

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr): Expr

open class View {
    open fun click(): String = "View clicked"
}

open class Button: View() {
    override fun click(): String = "Button clicked"
}

object Class{
    fun method(): String = "method"
}

class User(val id: Int, val name: String, val address: String)

interface Clickable{
    fun click(): String
    fun showOff(i: Int): String = "I'm clickable $i!"
}

interface Focusable{
    fun setFocus(b: Boolean): String = "I ${if (b) "got" else "lost"} focus"
    fun showOff(i: Int): String = "I'm focusable $i!"
}

class ClickButton: Clickable, Focusable {
    override fun click(): String = "I'm was clicked"

    override fun showOff(i: Int): String = when(i) {
        1 -> super<Clickable>.showOff(i)
        else -> super<Focusable>.showOff(i)
    }
}

open class RichButton: Clickable{
    fun disable() {}

    open fun animate() {}

    final override fun click(): String {
        return "RichButtonClass"
    }

    override fun showOff(i: Int): String {
        return super.showOff(i)
    }
}

class RichButton2: RichButton() {
    override fun animate() {
        super.animate()
    }

    override fun showOff(i: Int): String {
        return super.showOff(i)
    }
}

internal open class InternalTalkativeButton: Focusable{
    private fun yell(): String = "Hey!"
    protected fun whisper(): String = "Let's talk!"
}

/*
it's not public, but internal!
fun InternalTalkativeButton.giveSpeech(){

}
 */

open class TalkativeButton: Focusable{
    private fun yell(): String = "Hey!"
    protected fun whisper(): String = "Let's talk!"
}

interface State: Serializable
interface ViewInterface {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

// interface - java
// class - kotlin

class Kotlin: JavaInterface {}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

sealed class ResultSum {
    class Num(val value: Double) : ResultSum()
    class Sum(val left: ResultSum, val right: ResultSum): ResultSum()
}

open class Person constructor(nickname: String, isSubscribed: Boolean = true){
    val nickname: String
    val isSubscribed: Boolean

    init {
        this.nickname = nickname
        this.isSubscribed = isSubscribed
    }
}

class VkontakteUser(nickname: String) : Person(nickname) {}

class RadioButton: Button()

class Secretive private constructor() {}

open class View2 {
    constructor(ctx: Context){}

    constructor(cxt: Context, attr: AttributeSet){}
}

class MyButton: View2 {
    constructor(ctx: Context): super(ctx)

    constructor(cxt: Context, attr: AttributeSet): super(cxt, attr)
}

interface UserProgrammer {
    val nickname: String
}

class PrivateUserProgrammer(override val nickname: String): UserProgrammer

class SubscribingUserProgrammer(private val email: String): UserProgrammer{
    override val nickname: String
        get() = email.substringBefore('@')
}

class UserProger(val name: String){
    var address: String = "unspecified"

    set(value: String){
        field = value
    }

    fun getInfo(): String = "Adress: $address, name: $name"
}

class LengthCounter {
    var counter = 0
    private set

    fun addWord(word: String){
        counter += word.length
    }
}

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String = "$name ($postalCode)"

    override fun equals(other: Any?): Boolean =
        if (other == null || other !is Client) false else
            name == other.name && postalCode == other.postalCode

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) =
        Client(name, postalCode)
}

data class DataClient(val name: String, val postalCode: Int)

/*
class DelegatingCollection<T> : Collection<T>{
    private val innerList = arrayListOf<T>()

    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean =
        innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean =
        innerList.containsAll(elements)

    override fun isEmpty(): Boolean =
        innerList.isEmpty()

    override fun iterator(): Iterator<T> =
        innerList.iterator()
}
 */

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) :
        Collection<T> by innerList

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) :
    MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>) : Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

/*
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary(){
        for (person in allEmployees){
            // ...
        }
    }
}
 */

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        return o2?.path?.let { o1?.path?.compareTo(it, ignoreCase = true) }!!
    }
}

data class Human(val name: String){
    object NameComparator : Comparator<Human> {
        override fun compare(o1: Human, o2: Human): Int =
            o1.name.compareTo(o2.name)
    }
}

class A {
    companion object {
        fun bar(): String = "Companion object called!"
    }
}

/*
class UserExample {
    val nickname: String

    constructor(email: String){
        nickname = email.substringBefore('@')
    }

    constructor(vkontakteAccountId: Int){
        nickname = vkontakteAccountId.toString()
    }
}
 */

class UserExample private constructor(val nickname: String){
    companion object{
        fun newSubscribingUser(email: String) =
            UserExample(email.substringBefore('@'))

        fun newVkontakteUser(accountId: Int) =
            UserExample(accountId.toString())
    }
}

class Man(val name: String){
    companion object Loader {
        fun fromJSON(jsonText: String): Man = Man(jsonText)
    }
}

interface JSONFactory<T>{
    fun fromJSON(jsonText: String): T
}

class JSONPErson(val name: String){
    companion object : JSONFactory<JSONPErson>{
        override fun fromJSON(jsonText: String): JSONPErson = JSONPErson("Java-Strips")
    }
}

data class StudentAge(val name: String, val age: Int)

data class Volume(val square: Double, val height: Double){
    override fun toString(): String = "Volume: ${square * height} ($square, $height)"
}

data class Student(val name: String, val course: Int)

class Book(val title : String, val authors: List<String>)








